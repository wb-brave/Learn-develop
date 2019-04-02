package thinkinjava.chapter21.concurrency;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/02        wubin            0.0.1
 */
public class LiftOff implements Runnable {

    protected int count = 10;
    private static int taskcount = 0;
    private final int id = taskcount++;

    public void status() {
        System.out.print("#" + id + "(" + (count <= 0 ? "liftoff" : count) + ")");
    }

    @Override
    public void run() {
        while (count-- > 0) {
            status();
        }
        System.out.println();
    }
}
