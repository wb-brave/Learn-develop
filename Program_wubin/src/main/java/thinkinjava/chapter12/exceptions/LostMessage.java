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
public class LostMessage {

    void f() throws VeryImportantException{
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException{
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lostMessage = new LostMessage();
            try {
                /**
                 * 这里的异常丢失了
                 * 不管你这里的异常有没有处理
                 * 都会执行fianlly方法
                 * 导致这里代码块的异常丢失
                 */
                lostMessage.f();
            } finally {
                lostMessage.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class VeryImportantException extends Exception{
    @Override
    public String toString() {
        return "VeryImportantException{}";
    }
}
class HoHumException extends Exception{
    @Override
    public String toString() {
        return "HoHumException{}";
    }
}