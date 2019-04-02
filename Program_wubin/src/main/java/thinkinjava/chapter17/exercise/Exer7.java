package thinkinjava.chapter17.exercise;

import util.sets.Countries;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.exercise
 * @email wubin326@qq.com
 * @date 2018/12/11
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/11        wubin            0.0.1
 */
public class Exer7 {

    private static Iterator<String> it;
    private static java.util.ListIterator<String> lit;

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(Countries.names(6));
        LinkedList<String> linkedList = new LinkedList<>(Countries.names(6));
        itrPrint(arrayList);
        itrPrint(linkedList);
        litrInsert(arrayList, linkedList);
        System.out.println();
        guanfang();
    }

    static void itrPrint(List<String> a) {
        it = a.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println();
    }

    static void litrInsert(List<String> a, List<String> b) {
        int size = a.size();
        it = b.iterator();
        lit = a.listIterator(size);
        while (it.hasNext()) {
            // lit = a.listIterator(size - 1);
            /**
             * 将下标移动到前一位
             */
            lit.previous();
            /**
             * 插入元素
             */
            lit.add("[" + it.next() + "]");
            /**
             * 当前下标在刚插入的那个元素
             * 需要移动到下一次要出入之前的元素
             */
            lit.previous();
        }
        System.out.println(a);
    }

    static void guanfang() {
        List<String> al = new ArrayList<String>(Countries.names(4));
        List<String> ll = new LinkedList<String>(Countries.names(4));
        System.out.println(al);
        System.out.println(ll);
        Iterator alit = al.iterator();
        Iterator llit = ll.iterator();
        while (alit.hasNext()) {
            System.out.print(alit.next() + (alit.hasNext() ? ", " : ""));
        }
        System.out.println();
        while (llit.hasNext()) {
            System.out.print(llit.next() + (llit.hasNext() ? ", " : ""));
        }
        System.out.println();
        System.out.println();
        java.util.ListIterator allit = al.listIterator();
        java.util.ListIterator lllit = ll.listIterator();
        while (lllit.hasNext()) {
            allit.add((String) lllit.next());
            allit.next();
        }
        System.out.println(al);
        System.out.println();
        List<String> al2 = new ArrayList<String>(Countries.names(4));
        java.util.ListIterator<String> allit2 = al2.listIterator();
        /**
         * 将下标移动到第一个的位置
         */
        while (lllit.hasPrevious()){
            lllit.previous();
        }
        /**
         * 将下标移动到最后的位置
         */
        while (allit2.hasNext()) {
            allit2.next();
        }
        while (lllit.hasNext()) {
            allit2.add((String) lllit.next());
            /**
             * 因为插入了一个元素
             * 所以需要将元素向前移动俩位
             */
            allit2.previous();
            allit2.previous();
        }
        System.out.println(al2);
    }
}
