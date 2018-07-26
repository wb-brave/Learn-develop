package Thread.chapter03.ch03;

import java.util.Date;

public class InitThreadLocal extends InheritableThreadLocal{

    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }
}
