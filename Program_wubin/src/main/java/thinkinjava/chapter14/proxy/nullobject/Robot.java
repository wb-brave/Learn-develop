package thinkinjava.chapter14.proxy.nullobject;

import util.Null;

import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5.proxy.nullobject
 * @email wubin326@qq.com
 * @date 2018/11/05
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/05        wubin            0.0.1
 */
public interface Robot {

    String name();
    String model();
    List<Operation> operations();

    class Test{
        public static void test(Robot t){
            if (t instanceof Null){
                System.out.println("[null robot]");
            }
            System.out.println("Robot name: " + t.name());
            System.out.println("Robot model: " + t.model());
            for (Operation operation : t.operations()) {
                System.out.println(operation.description());
                operation.command();
            }

        }
    }
}
