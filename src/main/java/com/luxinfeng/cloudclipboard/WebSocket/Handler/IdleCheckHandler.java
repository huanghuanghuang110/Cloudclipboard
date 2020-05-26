package com.luxinfeng.cloudclipboard.WebSocket.Handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class IdleCheckHandler extends IdleStateHandler {
    public IdleCheckHandler() {
        super(20, 0, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        if (evt == IdleStateEvent.FIRST_READER_IDLE_STATE_EVENT) {
            System.out.println("idle check happen, so close the connection");
            ctx.close();
            return;
        }

        super.channelIdle(ctx, evt);
    }
}
