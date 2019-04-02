package netty.nettypractice.channelhandler;

import io.netty.channel.*;
import io.netty.util.ReferenceCountUtil;

/**
 * @author wubin
 * @Description 客户端也需要释放资源
 * @project Learn-develop
 * @package netty.nettypractice.channelhandler
 * @email wubin326@qq.com
 * @date 2019/01/17
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/17        wubin            0.0.1
 */
public class DiscardOutboundHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

        ReferenceCountUtil.release(msg);
        promise.setSuccess();
    }
}
