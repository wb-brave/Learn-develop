package netty.demo.encoderdecoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.demo.encoderdecoder
 * @email wubin326@qq.com
 * @date 2018/09/29
 */
public class ToIntegerDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() > 4) {
            list.add(byteBuf.readInt());
        }
    }
}
