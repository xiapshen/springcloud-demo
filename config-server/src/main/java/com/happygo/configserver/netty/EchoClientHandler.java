package com.happygo.configserver.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * ClassName: EchoClientHandler <br/>
 * Description: EchoClientHandler <br/>
 * Date: 2018/1/15 13:42 <br/>
 * @version 1.0 <br/>
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private static final Logger logger = LoggerFactory.getLogger(EchoClientHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.write(Unpooled.copiedBuffer("hello netty", Charset.defaultCharset()));
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        logger.info("Client received:" + ByteBufUtil.hexDump(byteBuf.readBytes(byteBuf.readableBytes())));
    }
}