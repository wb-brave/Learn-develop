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
public class MultipleReturns {
    public static int f(int i) {
        System.out.println("Initialization that requires cleanup");
        try {
            System.out.println("Point 1");
            if(i == 1) return i;
            System.out.println("Point 2");
            if(i == 2) return i;
            System.out.println("Point 3");
            if(i == 3) return i;
            System.out.println("End");
            return 0;
        } finally {
            System.out.println("Performing cleanup");
            /**
             * 会覆盖前面的返回值
             */
            return 5;
        }
    }
    public static void main(String[] args) {
        for(int i = 1; i <= 4; i++)
            System.out.println(f(i));
    }
}
