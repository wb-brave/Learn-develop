package netty.testhandler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

import static org.junit.Assert.*;

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
 * 2019/01/18        wubin            0.0.1
 */
public class FixedLengthFrameDecoderTest {

    @Test
    public void decode() {
        ByteBuf buffer = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buffer.writeByte(i);
        }
        ByteBuf dpbuf = buffer.duplicate();
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        //属于EmbeddedChannel的特有方法 将入站数据写入channel（会调用channel的handler方法来处理）
        assertTrue(channel.writeInbound(dpbuf.retain()));
        assertTrue(channel.finish());

        //属于EmbeddedChannel的特有方法 将channel的入站数据
        ByteBuf read = channel.readInbound();
        assertEquals(buffer.readSlice(3), read);
        //清空bytebuf
        read.release();

        read = channel.readInbound();
        assertEquals(buffer.readSlice(3), read);
        read.release();

        read = channel.readInbound();
        assertEquals(buffer.readSlice(3), read);
        read.release();

        assertNull(channel.readInbound());
        buffer.release();
    }

    @Test
    public void testFramesDecoded2() {
        ByteBuf buffer = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buffer.writeByte(i);
        }
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        ByteBuf duplicate = buffer.duplicate();
        //因为不足三位
        // assertTrue(embeddedChannel.writeInbound(duplicate.readBytes(2)));
        assertTrue(embeddedChannel.writeInbound(duplicate.readBytes(7)));
        assertTrue(embeddedChannel.finish());

        ByteBuf read = embeddedChannel.readInbound();
        assertEquals(buffer.readSlice(3),read);
        read.release();

        read = embeddedChannel.readInbound();
        assertEquals(buffer.readSlice(3),read);
        read.release();

        read = embeddedChannel.readInbound();
        assertEquals(buffer.readSlice(3),read);
        read.release();
        assertNull(embeddedChannel.readInbound());
        buffer.release();
    }
}