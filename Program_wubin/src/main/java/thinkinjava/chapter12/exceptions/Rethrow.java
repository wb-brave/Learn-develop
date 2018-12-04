package thinkinjava.chapter12.exceptions;

/**
 * @author wubin
 * @Description 重新抛出异常，如果使用方法e.fillInStackTrace() 将重新抛出异常的栈信息加入堆栈信息中
 * 之前的堆栈异常信息将丢失  某种程度上等同于抛出另一种异常
 * @project Learn-develop
 * @package thinkinjava.chapter12.exceptions
 * @email wubin326@qq.com
 * @date 2018/11/27
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/27        wubin            0.0.1
 */
public class Rethrow {
    public static void f() throws Exception {
        System.out.println("Originating the exception in f()");
        throw new Exception("e from f()");
    }

    public static void g() throws Exception {

        try {
            f();
        } catch (Exception e) {
            System.out.println("rethrowing the exception in g()");
            e.printStackTrace();
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside h(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
