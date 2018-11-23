package thinkinjava.chapter15.generics;

import java.util.Date;

/**
 * @author wubin
 * @Description 使用混型(将特性和行为一致的应用于多个类里) --有种AOP的味道
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/21        wubin            0.0.1
 */
public class Mixins {

    public static void main(String[] args) {
        Mixin mixin = new Mixin();
        Mixin mixin1 = new Mixin();
        mixin.set("test string 1");
        mixin1.set("test string 2");
        System.out.println(mixin.get() + " " +
                mixin.getTimeStamp() +  " " + mixin.getSerialNumber());
        System.out.println(mixin1.get() + " " +
                mixin1.getTimeStamp() +  " " + mixin1.getSerialNumber());
    }
}

class Mixin extends BasicImpl implements TimeStamped, SerialNumbered {

    private TimeStamped timeStamped = new TimeStampedImpl();
    private SerialNumbered serialNumbered = new SerialNumberedImpl();

    @Override
    public long getTimeStamp() {
        return timeStamped.getTimeStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumbered.getSerialNumber();
    }
}

interface TimeStamped {
    long getTimeStamp();
}

class TimeStampedImpl implements TimeStamped {
    private final long timeStamp;

    public TimeStampedImpl() {
        this.timeStamp = new Date().getTime();
    }

    @Override
    public long getTimeStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {
    long getSerialNumber();
}

class SerialNumberedImpl implements SerialNumbered {
    private static long count = 1;
    private final long serialNumber = count++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {
    public void set(String var);

    public String get();
}

class BasicImpl implements Basic {

    private String value;

    @Override
    public void set(String var) {
        this.value = var;
    }

    @Override
    public String get() {
        return value;
    }
}