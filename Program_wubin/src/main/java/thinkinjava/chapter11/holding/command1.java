package thinkinjava.chapter11.holding;

import java.util.*;

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
public class command1 {

    public Queue display(Command... com){
        Queue<Command> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(com));
        return queue;
    }
}
