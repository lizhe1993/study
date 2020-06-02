package com.lz.netty.study;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.ImmediateEventExecutor;

import java.net.InetSocketAddress;

/**
 * @ClassName: ChatServer
 * @Description:
 * @Author: LiZhe lizhej@enn.cn
 * @Date: 2020/6/2 18:18
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class ChatServer {


    private final ChannelGroup cGroup = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);

    private final EventLoopGroup lGroup = new NioEventLoopGroup();

    private Channel channel;

    public ChannelFuture start(InetSocketAddress address) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(lGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(createInitializer(cGroup));
        ChannelFuture future = bootstrap.bind(address);
        future.syncUninterruptibly();
        channel = future.channel();
        return future;
    }


    private ChannelInitializer<Channel> createInitializer(ChannelGroup cGroup) {
        return new ChatServerInitializer(cGroup);

    }

    public void destroy() {
        if (channel != null) {
            channel.close();
        }
        cGroup.close();
        lGroup.shutdownGracefully();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Please give port as argument");
            System.exit(1);
        }
        int port = Integer.parseInt(args[0]);

        final ChatServer cs = new ChatServer();

        ChannelFuture future = cs.start(new InetSocketAddress(port));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            cs.destroy();
        }));
        future.channel().closeFuture().syncUninterruptibly();
    }
}
