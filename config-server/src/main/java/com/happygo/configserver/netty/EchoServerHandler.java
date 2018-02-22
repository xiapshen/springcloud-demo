package com.happygo.configserver.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName: EchoServerHandler <br/>
 * Description: EchoServerHandler <br/>
 * Date: 2018/1/15 12:57 <br/>
 * @version 1.0 <br/>
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(EchoServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("Server received:" + msg);
        ctx.write(msg);
    }
}