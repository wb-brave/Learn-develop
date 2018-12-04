package thinkinjava.chapter12.exceptions;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter12.exceptions
 * @email wubin326@qq.com
 * @date 2018/11/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/28        wubin            0.0.1
 */
public class StormyInning extends Inning implements Storm {

    public StormyInning() throws BaseBallException, RainedOut {
    }

    public StormyInning(String s)
            throws Foul, BaseBallException {
    }

    /**
     * 因为他的父类此方法并没有抛出异常
     * 所以在子类中抛出异常是不允许的
     * @throws PopFoul
     */
    // void walk() throws PopFoul {}

    // Regular methods must conform to base class:
//! void walk() throws PopFoul {} //Compile error
    // Interface CANNOT add exceptions to existing
    // methods from the base class:
//! public void event() throws RainedOut {}
    // If the method doesn't already exist in the
    // base class, the exception is OK:
    public void rainHard() throws RainedOut {}
    // You can choose to not throw any exceptions,
    // even if the base version does:
    public void event() {}
    // Overridden methods can throw inherited exceptions:
    public void atBat() throws PopFoul {}

    public static void main(String[] args) {
        try {
            StormyInning stormyInning = new StormyInning();
            stormyInning.atBat();
        } catch (RainedOut rainedOut) {
            System.out.println("rain out");
        }catch (PopFoul e){
            System.out.println("pop full");
        }catch (BaseBallException e) {
            System.out.println("Generic base exception");
        }

        try {
            Inning inning = new StormyInning();
            inning.atBat();
        } catch (Strike strike) {
            System.out.println("strike");
        } catch (Foul foul) {
            System.out.println("foul");
        } catch (RainedOut rainedOut) {
            System.out.println("rain out1");
        } catch (BaseBallException e) {
            System.out.println("Generic base exception1");
        }
    }
    // 不能依据返回类型来判定重载
    // void a(){};
    // int a(){return 1;};
}

interface Storm {
    void event() throws RainedOut;

    void rainHard() throws RainedOut;
}

class BaseBallException extends Exception {
}

class Foul extends BaseBallException {
}

class Strike extends BaseBallException {
}

abstract class Inning {
    public Inning() throws BaseBallException {
    }

    public void event() throws BaseBallException {

    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {

    }
}

class StormyException extends Exception {

}

class RainedOut extends StormyException {
}

class PopFoul extends Foul {
}