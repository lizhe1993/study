package com.lz.netty.study;

import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;

import javax.xml.ws.spi.http.HttpHandler;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @ClassName: HttpRequestHandler
 * @Description:
 * @Author: LiZhe lizhej@enn.cn
 * @Date: 2020/6/2 13:59
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    /**
     * web socket 地址
     */
    private final String wsUri;

    /**
     * 读取文件
     */
    private static final File INDEX;

    static {
        URL location = HttpRequestHandler.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            String path = location.toURI() + "index.html";
            path = !path.contains("file:") ? path : path.substring(5);
            INDEX = new File(path);
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Unable to locate index.html", e);
        }
    }


    public HttpRequestHandler(String wsUri) {
        this.wsUri = wsUri;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        // 判断是否是 web socket 路径
        if (wsUri.equalsIgnoreCase(request.uri())) {
            //如果请求了 WebSocket 协议升级，则增加引用计数（调用 retain()方法），并将它传递给下一个ChannelInboundHandler
            ctx.fireChannelRead(request.retain());
        } else {
            // 处理 100 Continue请求以符合 HTTP-1.1 规范
            if (HttpUtil.is100ContinueExpected(request)) {
                HttpRequestHandler.send100Continue(ctx);
            }
            RandomAccessFile file = new RandomAccessFile(INDEX, "r");
            HttpResponse response = new DefaultFullHttpResponse(request.protocolVersion(), HttpResponseStatus.OK);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=UTF-8");
            boolean keepAlive = HttpUtil.isKeepAlive(request);
            if (keepAlive) {
                // 如果请求了keep-alive，则添加所需要的 HTTP头信息
                response.headers().set(HttpHeaderNames.CONTENT_LENGTH,file.length());
                response.headers().set(HttpHeaderNames.CONNECTION,HttpHeaderValues.KEEP_ALIVE);
            }
            // 将HttpResponse写到客户端
            ctx.write(response);

            if(ctx.pipeline().get(SslHandler.class)==null){
                // 将index.html写到客户端
                ctx.write(new DefaultFileRegion(file.getChannel(),0,file.length()));
            }else{
                ctx.write(new ChunkedNioFile(file.getChannel()));
            }
            // 写 LastHttpContent 并冲刷至客户端
            ChannelFuture future = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
            // 如果没有请求keep-alive，则在写操作完成后关闭Channel
            if(!keepAlive){
                future.addListener(ChannelFutureListener.CLOSE);
            }
        }
    }

    private static void send100Continue(ChannelHandlerContext ctx) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE);
        ctx.writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
