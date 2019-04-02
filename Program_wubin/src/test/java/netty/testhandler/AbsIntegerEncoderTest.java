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
public class AbsIntegerEncoderTest {

    @Test
    public void testEncoded() {
        ByteBuf buffer = Unpooled.buffer();
        for (int i = 0; i < 10; i++) {
            buffer.writeInt(i * -1);
        }
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new AbsIntegerEncoder());
        assertTrue(embeddedChannel.writeOutbound(buffer));
        assertTrue(embeddedChannel.finish());

        for (int i = 0; i < 10; i++) {
            assertEquals(i, (int)embeddedChannel.readOutbound());
        }
        assertNull(embeddedChannel.readOutbound());
        // buffer.release();
    }
}