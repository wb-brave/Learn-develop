package thinkinjava.chapter10.innerclass.controller;

import java.awt.print.PrinterAbortException;

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
public abstract class Event {

    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() {
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean readay() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
