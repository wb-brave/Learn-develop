package thinkinjava.chapter11.holding;

import java.util.Iterator;
import java.util.Queue;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter11.holding
 * @email wubin326@qq.com
 * @date 2018/12/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/28        wubin            0.0.1
 */
public class Command2 {

    public static void main(String[] args) {
        command1 command1 = new command1();
        Command[] commands = new Command[5];
        for (int i = 0; i < 5; i++) {
            commands[i] = new Command(i+"");
        }
        Queue display = command1.display(commands);
        Iterator it = display.iterator();
        while (it.hasNext()){
            Object next = it.next();
            if (next instanceof Command) {
                ((Command) next).operation();
            }
            it.remove();
        }
    }
}
