package util;

import java.util.LinkedList;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util
 * @email wubin326@qq.com
 * @date 2018/11/06
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/06        wubin            0.0.1
 */
public class Stack<T> {

    private LinkedList<T> storage = new LinkedList<>();

    public void push(T v) {
        storage.addFirst(v);
    }

    public T pop() {
        return storage.removeFirst();
    }

    public T peek() {
        return storage.getFirst();
    }

    public boolean empty(){
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack{" +
                "storage=" + storage.toString() +
                '}';
    }
}
