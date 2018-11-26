package thinkinjava.chapter10.innerclass;

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
public class Callbacks {
    public static void main(String[] args) {
        Callee1 callee1 = new Callee1();
        Callee2 callee2 = new Callee2();
        /**
         * 调用的是callee2
         * 的方法
         */
        MyIncrement.f(callee2);
        Caller caller = new Caller(callee1);
        /**
         * 调用其内部类的实现
         */
        Caller caller1 = new Caller(callee2.getCallbackReference());
        caller.go();
        caller.go();
        caller1.go();
        caller1.go();
    }
}

interface Incrementable{
    void increment();
}

class Callee1 implements Incrementable{
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement{

    public void increment() {
        System.out.println("other operation");
    }

    public static void f(MyIncrement myIncrement){
        myIncrement.increment();
    }
}

class Callee2 extends MyIncrement{
    private int i = 0;
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }
    private class Closure implements Incrementable{
        @Override
        public void increment() {
            /**
             * 调用的是外部类的方法
             * 相当于是一个Callee2的钩子 hook
             */
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackReference(){
        return new Closure();
    }
}

class Caller{
    private Incrementable callbackreference;

    Caller(Incrementable callbackreference) {
        this.callbackreference = callbackreference;
    }

    void go(){
        callbackreference.increment();
    }
}