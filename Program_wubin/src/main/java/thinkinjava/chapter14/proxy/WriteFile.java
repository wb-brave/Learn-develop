package thinkinjava.chapter14.proxy;

import java.io.FileOutputStream;
import java.io.IOException;
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
interface Writes{
    int writing(String dir,int flag);
}
public class WriteFile implements Writes{

    public int writing(String dirfile, int flag) {
        try {
            FileChannel channel = new FileOutputStream(dirfile).getChannel();
            channel.write(ByteBuffer.wrap("woshiwubin".getBytes()));
            int rs = 1/flag;
            channel.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return flag;
        }
        return flag;
    }

    public void rollback(){

    }
}
