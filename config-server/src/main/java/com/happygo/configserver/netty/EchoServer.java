package com.happygo.configserver.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * ClassName: EchoServer <br/>
 * Description: EchoServer <br/>
 * Date: 2018/1/15 12:19 <br/>
 * @version 1.0 <br/>
 */
public class EchoServer {

    private int port;

    EchoServer(int port) {
        this.port = port;
    }

    void start() throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(eventLoopGroup).channel(NioServerSocketChannel.class).localAddress(port)
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(new EchoServerHandler());
                    }
                });
        ChannelFuture f = bootstrap.bind().sync();
        f.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoServer(65535).start();
    }
}