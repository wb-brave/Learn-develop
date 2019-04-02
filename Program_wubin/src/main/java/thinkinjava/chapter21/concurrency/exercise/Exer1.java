package thinkinjava.chapter21.concurrency.exercise;

/**
 * @author wubin
 * @Description 练习一
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.exercise
 * @email wubin326@qq.com
 * @date 2019/01/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/02        wubin            0.0.1
 */
public class Exer1 implements Runnable {

    private int count = 3;
    private static int taskSerial = 0;
    private final int id = taskSerial++;

    public Exer1() {
        System.out.println("#" + id + "starting...");
        // if (count <= 0) {
        //     System.out.println("#" + id + "ending...");
        // }
    }

    @Override
    public void run() {
        while (count-- > 0) {
            System.out.print("#" + id + "执行了:" + count + " ");
            Thread.yield();
        }
        System.out.println("#" + id + "ending...");
    }
}
