package netty.testhandler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.util.CharsetUtil;
import org.apache.xmlbeans.impl.store.CharUtil;
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
public class FrameChunkDecoderTest {

    @Test
    public void decode() {
        ByteBuf buffer = Unpooled.buffer();
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new FrameChunkDecoder(3));
        buffer.writeBytes("wubin".getBytes(CharsetUtil.UTF_8));
        ByteBuf duplicate = buffer.duplicate();
        assertTrue(embeddedChannel.writeInbound(duplicate.readBytes(5)));
        assertEquals(embeddedChannel.readInbound(),buffer.readBytes(5));
    }
}