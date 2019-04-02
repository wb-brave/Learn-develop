package thinkinjava.chapter21.concurrency.concurrent;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.concurrent
 * @email wubin326@qq.com
 * @date 2019/01/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/23        wubin            0.0.1
 */
public class Fat {

    private volatile double d;
    private static int counter = 0;
    private final int id = counter++;

    public Fat() {
        for (int i = 0; i < 10000; i++) {
            d += (Math.PI + Math.E) / i;
        }
    }
    public void operation(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Fat{" +
                "id=" + id +
                '}';
    }
}
