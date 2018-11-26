package thinkinjava.chapter10.innerclass.controller;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter10.innerclass.controller
 * @email wubin326@qq.com
 * @date 2018/11/26
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/26        wubin            0.0.1
 */
public class Controller{


    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event event) {
        eventList.add(event);
    }
    public void run(){
        while (eventList.size()>0){
            /**
             * 使用构造方法，拷贝了一份list，这样就不会更改原生的list
             */
            for (Event event : new ArrayList<>(eventList)) {
                if (event.readay()){
                    System.out.println(event);
                    event.action();
                    eventList.remove(event);
                }
            }
        }
    }
}
