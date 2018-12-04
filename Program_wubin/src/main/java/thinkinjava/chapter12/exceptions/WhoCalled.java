package thinkinjava.chapter12.exceptions;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter12.exceptions
 * @email wubin326@qq.com
 * @date 2018/11/27
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/27        wubin            0.0.1
 */
public class WhoCalled {

    static void f(){
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement traceElement : e.getStackTrace()) {
                System.out.println(traceElement.getMethodName());
            }
        }
    }

    static void g(){
        f();
    }

    static void h(){
        g();
    }

    public static void main(String[] args) {
        h();
    }
}
