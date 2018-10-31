package netty.demo.encoderdecoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.demo.encoderdecoder
 * @email wubin326@qq.com
 * @date 2018/09/29
 */
public class ShortToByteEncoder extends MessageToByteEncoder<Short> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Short aShort, ByteBuf byteBuf) throws Exception {
        byteBuf.writeShort(aShort);
    }
}
