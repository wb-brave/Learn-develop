package util.sets.queue;

import org.junit.Test;

import java.util.Queue;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.sets.queue
 * @email wubin326@qq.com
 * @date 2018/12/13
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/13        wubin            0.0.1
 */
public class DequeTest {

    @Test
    public void test() {
        Deque<Integer> deque = new Deque<>();
        fillTest(deque);
        System.out.println(deque);
        while (deque.size() != 0) {
            System.out.print(deque.removeFirst() + " ");
        }
        System.out.println();
        fillTest(deque);
        while (deque.size() != 0) {
            System.out.print(deque.removeLast() + " ");
        }
    }

    void fillTest(Deque<Integer> deque) {
        for (int i = 20; i < 27; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i < 55; i++) {
            deque.addLast(i);
        }
    }
}