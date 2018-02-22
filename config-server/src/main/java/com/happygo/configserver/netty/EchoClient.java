package com.happygo.configserver.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * ClassName: EchoClient <br/>
 * Description: EchoClient <br/>
 * Date: 2018/1/15 13:34 <br/>
 * @version 1.0 <br/>
 */
public class EchoClient {

    private final String host;

    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    void start() throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress(host, port))
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(new EchoClientHandler());

                    }
                });
        ChannelFuture future = bootstrap.connect().sync();
        future.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoClient("localhost", 65535).start();
    }
}