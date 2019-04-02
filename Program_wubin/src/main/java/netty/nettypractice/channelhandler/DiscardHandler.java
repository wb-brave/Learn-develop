package netty.nettypractice.channelhandler;

import io.netty.channel.*;
import io.netty.util.ReferenceCountUtil;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.nettypractice.channelhandler
 * @email wubin326@qq.com
 * @date 2019/01/16
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/16        wubin            0.0.1
 */
@ChannelHandler.Sharable
public class DiscardHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /**
         * 当某个 ChannelInboundHandler 的实现重写 channelRead()方法时,它将负责显式地 释放与池化的 ByteBuf 实例相关的内存
         * 但是netty内置了一个ChannelInboundHandler的简单实现，继承此类时不需要显示释放,他在finally语句中已经释放
         * 丢弃已接收msg
         */
        ReferenceCountUtil.release(msg);
    }
}
