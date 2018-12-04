package thinkinjava.chapter12.exceptions;

/**
 * @author wubin
 * @Description 创建属于自己的异常，继承于Exception
 * @project Learn-develop
 * @package thinkinjava.chapter12.exceptions
 * @email wubin326@qq.com
 * @date 2018/11/27
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/27        wubin            0.0.1
 */
public class InheritingExceptions {

    public void f() throws SimpleException{
        System.out.println("throw simpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions inheritingExceptions = new InheritingExceptions();
        try {
            inheritingExceptions.f();
        } catch (SimpleException e) {
            System.out.println("caught it1!!" + e);
        }
    }
}

class SimpleException extends Exception{}
