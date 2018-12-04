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
public class FinallyWorks {

    private static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                if (count++ == 0) {
                    throw new Exception();
                }
                System.out.println("no exception");
            } catch (Exception e) {
                System.out.println("exception");
            } finally {
                System.out.println("finally work");
                if (count==2){
                    break;
                }
            }
        }
    }
}
