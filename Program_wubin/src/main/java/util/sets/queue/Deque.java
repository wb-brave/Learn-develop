package util.sets.queue;

import java.util.LinkedList;

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
public class Deque<T> {
    private LinkedList<T> deque = new LinkedList<>();

    public void addFirst(T t) {
        deque.addFirst(t);
    }

    public void addLast(T t) {
        deque.addLast(t);
    }

    public T getFirst() {
        return deque.getFirst();
    }

    public T getLast() {
        return deque.getLast();
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public int size() {
        return deque.size();
    }

    public String toString() {
        return deque.toString();
    }
}
