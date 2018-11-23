package thinkinjava.chapter15.generics.exercise;


/**
 * @author wubin
 * @Description 一出node上的类型信息，
 * 证明内部类可以访问其外部类的类型参数
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics.exercise
 * @email wubin326@qq.com
 * @date 2018/11/06
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/06        wubin            0.0.1
 */
public class Exer5<T> {

    // private static class Node { 如果申明为static，不允许使用类型信息 T
    private class Node {
        T item;
        Node next;

        public Node() {
            this.item = null;
            this.next = null;
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node top = new Node();

    public void push(T item) {
        /**
         * 这里放的top里面的item和next
         * 都是null,所以可以使用end方法
         * 来判定是否还有元素
         */
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {

        Exer5<String> lss = new Exer5<>();
        for (String s : "Phasers on stun!".split(" ")) {
            lss.push(s);
        }
        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }

}
