package netty.nettypractice.channelhandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author wubin
 * @Description 继承此类时不需要显示释放,他在finally语句中已经释放与池化的 ByteBuf 实例相关的内存
 * @project Learn-develop
 * @package netty.nettypractice.channelhandler
 * @email wubin326@qq.com
 * @date 2019/01/16
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/16        wubin            0.0.1
 */
public class SimpleDiscardHandler extends SimpleChannelInboundHandler {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }
}
