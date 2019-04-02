package netty.nettypractice;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package netty.nettypractice
 * @email wubin326@qq.com
 * @date 2019/01/15
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/15        wubin            0.0.1
 */

/**
 * 标识这个handler可以被多个channel复用
 * 由于不需要会写数据所以继承这个类
 */
@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf>{


    /**
     * 读取channel中的数据
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //当被通知channel活跃的时候发送一条消息
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty Rocks!",CharsetUtil.UTF_8));
    }

    /**
     * 将还未读取的数据冲刷到远程节点，并关闭channel
     * @param ctx
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        /**
         * 获得服务端传输过来的消息
         */
        System.out.println("Client received: "+byteBuf.toString(CharsetUtil.UTF_8));
    }


    /**
     * 调用过程中的
     * 异常处理，channel有一个调用链，这个调用链要保证至少有一个实现了这个方法
     * 异常会传递
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
