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
 * 继承这个类ChannelInboundHandlerAdapter是为了在获得输入信息后还需要将数据会写给写入信息的一方
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("激活了");
    }

    /**
     * 读取channel中的数据
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        System.out.println("server received " + in.toString(CharsetUtil.UTF_8));
        ctx.write(in);
    }

    /**
     * 将还未读取的数据冲刷到远程节点，并关闭channel
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
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
