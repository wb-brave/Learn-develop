package thinkinjava.chapter11.holding;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter11.holding
 * @email wubin326@qq.com
 * @date 2018/12/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/28        wubin            0.0.1
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        Random random = new Random();
        PriorityQueue<Double> doubles = new PriorityQueue<>();
        int i = 0;
        while (true) {
            double v = random.nextDouble();
            doubles.offer(v);
            System.out.print(v + " ");
            i++;
            if (i > 10) {
                break;
            }
        }
        System.out.println();
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            System.out.print(doubles.poll() + " ");
        }
    }
}

class testpq {
    private int i;

    public testpq(int i) {
        this.i = i;
    }
}