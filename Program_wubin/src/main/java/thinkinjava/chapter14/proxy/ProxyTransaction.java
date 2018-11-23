package thinkinjava.chapter14.proxy;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5.proxy
 * @email wubin326@qq.com
 * @date 2018/11/05
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/05        wubin            0.0.1
 */
public class ProxyTransaction implements InvocationHandler {

    private Object object;

    public ProxyTransaction(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args != null){
            for (Object arg : args) {
                System.out.print(arg + " ");
            }
        }
        Object obj = null;
        try {
            obj = method.invoke(object, args);
            System.out.println("提交成功");
        }catch (Exception e){
            FileChannel channel = new FileOutputStream(args[0].toString()).getChannel();
            channel.write(ByteBuffer.wrap("".getBytes()));
            channel.close();
            System.out.println("提交失败，回滚");
        }finally {
            return obj;
        }
    }
}
