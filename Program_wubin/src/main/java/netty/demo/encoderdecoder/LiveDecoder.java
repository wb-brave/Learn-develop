package netty.demo.encoderdecoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.demo.encoderdecoder
 * @email wubin326@qq.com
 * @date 2018/09/29
 */
public class LiveDecoder extends ReplayingDecoder<LiveDecoder.LiveState> {

    public enum LiveState{
        LENGTH,
        CONTENT
    }

    public LiveDecoder() {
        super(LiveState.LENGTH);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

    }
}
