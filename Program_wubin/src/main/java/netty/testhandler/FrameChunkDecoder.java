package netty.testhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;

import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.testhandler
 * @email wubin326@qq.com
 * @date 2019/01/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/18        wubin            0.0.1              将入站字节转换为msg
 */
public class FrameChunkDecoder extends ByteToMessageDecoder {

    private final int frameMaxSize;

    public FrameChunkDecoder(int frameMaxSize) {
        this.frameMaxSize = frameMaxSize;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i = byteBuf.readableBytes();
        if (i > frameMaxSize) {
            byteBuf.clear();
            throw new TooLongFrameException(i + "");
        }
        ByteBuf byteBuf1 = byteBuf.readBytes(i);
        list.add(byteBuf1);
    }
}
