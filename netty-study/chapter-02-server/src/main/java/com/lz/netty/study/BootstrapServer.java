package com.lz.netty.study;

import com.lz.netty.study.handler.EchoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @ClassName: Bootstrap
 * @Description:
 * @Date: 2020/5/12 18:05
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class BootstrapServer {
    /**
     * 端口
     */
    private final int port;

    public BootstrapServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            // 如果没有端口，则输出错误
            System.err.println("Usage:" + BootstrapServer.class.getSimpleName() + " <port>");
        }
        int port = Integer.parseInt(args[0]);
        // 启动
        System.out.println("------启动端口 " + port + "-------");
        new BootstrapServer(port).start();
    }

    /**
     * 启动服务
     */
    public void start() throws InterruptedException {
        // 创建 event loop group - 这里使用了nio 传输 channel
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            // 创建服务引导启动类
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap
                    // 绑定分组
                    .group(group)
                    // 指定nio 传输 channel
                    .channel(NioServerSocketChannel.class)
                    // 使用指定的端口设置套接字地址-绑定本地地址端口
                    .localAddress(new InetSocketAddress(port))
                    // 添加一个EchoServerHandler 到子Channel的 ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            //EchoServerHandler 被标注为@Shareable，所以我们可以总是使用同样的实例
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            // 异步地绑定服务器；调用 sync()方法阻塞等待直到绑定完成
            ChannelFuture cf = bootstrap.bind().sync();
            System.out.println(BootstrapServer.class.getName() + " started and listen on " + cf.channel().localAddress());
            // 获取Channel的CloseFuture，并且阻塞当前线程直到它完成
            cf.channel().closeFuture().sync();
        } finally {
            //关闭 EventLoopGroup，释放所有的资源
            group.shutdownGracefully().sync();
        }
    }

}
