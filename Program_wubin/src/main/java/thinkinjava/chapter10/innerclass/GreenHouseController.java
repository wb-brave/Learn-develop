package thinkinjava.chapter10.innerclass;

import Thread.chapter04.condition123.Run;
import thinkinjava.chapter10.innerclass.controller.Event;
import util.MyConst;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter10.innerclass
 * @email wubin326@qq.com
 * @date 2018/11/26
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/26        wubin            0.0.1
 */
public class GreenHouseController {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GreenHouseControlls gc = new GreenHouseControlls();
        // FileInputStream fileInputStream = new FileInputStream(MyConst.FileConst.FILEPATH_DESKTOP + "GreenHouseController.txt");
        // ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // int read = fileInputStream.getChannel().read(byteBuffer);
        // byteBuffer.flip();
        // /**
        //  * 使用nio读取
        //  */
        // StringBuffer stringBuffer = new StringBuffer();
        // while (byteBuffer.hasRemaining()){
        //     char c = (char) byteBuffer.get();
        //     stringBuffer.append(c);
        // }
        // System.out.println(stringBuffer.toString());

        // BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // StringBuffer stringBuffer = new StringBuffer();
        // while (bufferedInputStream.available() > 0){
        //     char c = (char) bufferedInputStream.read();
        //     stringBuffer.append(c);
        // }
        // System.out.println(stringBuffer.toString());
        gc.addEvent(gc.new Bell(900));
        Event[] events = {gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)};
        gc.addEvent(gc.new Restart(2000,events));
        if (args.length==1){
            gc.addEvent(new GreenHouseControlls.Terminate(new Integer(args[0])));
        }
        gc.run();
    }
}
