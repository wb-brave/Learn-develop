package thinkinjava.chapter18.serializable;

import util.MyConst;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.serializable
 * @email wubin326@qq.com
 * @date 2018/10/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/23        wubin            0.0.1
 */
public class RecoverCADState {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(MyConst.FileConst.FILEPATH_DESKTOP + "CADState.out"));
        ArrayList<Class<? extends Shape>> shapeTypes = (ArrayList<Class<? extends Shape>>) objectInputStream.readObject();
        /**
         * 对于静态变量必须使用如下方法
         */
        Line.deserializeStaticState(objectInputStream);
        Circle.deserializeStaticState(objectInputStream);
        Square.deserializeStaticState(objectInputStream);
        List<Shape> shapes = (List<Shape>) objectInputStream.readObject();
        System.out.println(shapes);
    }
}
