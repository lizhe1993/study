package com.lz.netty.study;

import com.lz.netty.study.handler.EchoClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @ClassName: Bootstrap
 * @Description:
 * @Date: 2020/5/12 18:05
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class BootstrapClient {
    /**
     * 地址
     */
    private final String host;
    /**
     * 端口
     */
    private final int port;

    public BootstrapClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            // 如果没有地址和端口，则输出错误
            System.err.println("Usage:" + BootstrapClient.class.getSimpleName() + " <host> <port>");
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        System.out.println("host->" + host + "，port->" + port);
        // 启动
        new BootstrapClient(host, port).start();
    }

    /**
     * 启动服务
     */
    public void start() throws InterruptedException {
        // 创建 event loop group - 这里使用了nio 传输 channel
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 创建客户引导启动类
            Bootstrap bootstrap = new Bootstrap();
            bootstrap
                    // 绑定分组
                    .group(group)
                    // 指定nio 传输 channel
                    .channel(NioSocketChannel.class)
                    // 使用指定的端口设置套接字地址-绑定本地地址端口
                    .remoteAddress(new InetSocketAddress(host, port))
                    // 添加一个EchoServerHandler 到子Channel的 ChannelPipeline
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            //EchoServerHandler 被标注为@Shareable，所以我们可以总是使用同样的实例
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            // 异步地绑定服务器；调用 sync()方法阻塞等待直到绑定完成
            ChannelFuture cf = bootstrap.connect().sync();
            // 获取Channel的CloseFuture，并且阻塞当前线程直到它完成
            cf.channel().closeFuture().sync();
        } finally {
            //关闭 EventLoopGroup，释放所有的资源
            group.shutdownGracefully().sync();
        }
    }

}
