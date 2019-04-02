package thinkinjava.chapter17.containers;

import util.sets.Countries;

import java.util.*;

/**
 * @author wubin
 * @Description 演示list的一些常规操作，
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/11
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/11        wubin            0.0.1
 */
public class Lists {

    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a) {
        a.add(1, "x");//在下标1下插入
        a.add("x");//在最后插入
        a.addAll(Countries.names(10));
        a.addAll(3, Countries.names(10));
        b = a.contains("1");
        b = a.containsAll(Countries.names(10));
        s = a.get(1);
        i = a.indexOf("1");
        b = a.isEmpty();
        it = a.iterator();
        lit = a.listIterator();
        lit = a.listIterator(3);
        i = a.lastIndexOf("1");
        a.remove(1);
        a.remove("3");
        a.set(1, "y");
        a.retainAll(Countries.names(10));
        a.removeAll(Countries.names(10));
        i = a.size();
        a.clear();
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    /**
     * 使用iterator来修改元素
     *
     * @param a
     */
    public static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        // Must move to an element after add():
        it.next();
        // Remove the element after the newly produced one:
        it.remove();
        // Must move to an element after remove():
        it.next();
        // Change the element after the deleted one:
        it.set("47");
    }

    public static void testVisual(List<String> a) {
        System.out.println(a);
        List<String> b = Countries.names(10);
        System.out.println("b = " + b);
        a.addAll(b);
        a.addAll(b);
        System.out.println(a);
        // Insert, remove, and replace elements
        // using a ListIterator:
        ListIterator<String> x = a.listIterator(a.size() / 2);
        x.add("one");
        System.out.println(a);
        System.out.println(x.next());
        x.remove();
        System.out.println(x.next());
        x.set("47");
        System.out.println(a);
        // Traverse the list backwards:
        x = a.listIterator(a.size());
        while (x.hasPrevious())
            System.out.print(x.previous() + ", ");
        System.out.println();
        System.out.println("testVisual finished");
    }

    // There are some things that only LinkedLists can do:
    public static void testLinkedList() {
        LinkedList<String> ll = new LinkedList<String>();
        ll.addAll(Countries.names(10));
        System.out.println(ll);
        // Treat it like a stack, pushing:
        ll.addFirst("one");
        ll.addFirst("two");
        System.out.println(ll);
        // Like "peeking" at the top of a stack:
        System.out.println(ll.getFirst());
        // Like popping a stack:
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        // Treat it like a queue, pulling elements
        // off the tail end:
        System.out.println(ll.removeLast());
        System.out.println(ll);
    }

    public static void main(String[] args) {
        // Make and fill a new list each time:
        basicTest(
                new LinkedList<String>(Countries.names(10)));
        System.out.println("=============================================");
        basicTest(
                new ArrayList<String>(Countries.names(10)));
        System.out.println("=============================================");
        iterMotion(
                new LinkedList<String>(Countries.names(10)));
        System.out.println("=============================================");
        iterMotion(
                new ArrayList<String>(Countries.names(10)));
        System.out.println("=============================================");
        iterManipulation(
                new LinkedList<String>(Countries.names(10)));
        System.out.println("=============================================");
        iterManipulation(
                new ArrayList<String>(Countries.names(10)));
        System.out.println("=============================================");
        testVisual(
                new LinkedList<String>(Countries.names(10)));
        System.out.println("=============================================");
        testLinkedList();

    }

}
