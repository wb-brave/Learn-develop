package thinkinjava.chapter17.containers;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/27
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/27        wubin            0.0.1
 */
public class Utilities {

    static List<String> list = Arrays.asList(
            "one Two three Four five six one".split(" ")
    );

    public static void main(String[] args) {
        System.out.println(list);
        System.out.println("'list' disjoint (Four)?: " +
                Collections.disjoint(list,
                        Collections.singletonList("Four")));
        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));
        System.out.println("max w/ comparator: " + Collections.max(list,
                String.CASE_INSENSITIVE_ORDER));
        System.out.println("min w/ comparator: " + Collections.min(list,
                String.CASE_INSENSITIVE_ORDER));
        List<String> sublist =
                Arrays.asList("Four five six".split(" "));
        System.out.println("indexOfSubList: " +
                Collections.indexOfSubList(list, sublist));
        System.out.println("lastIndexOfSubList: " +
                Collections.lastIndexOfSubList(list, sublist));
        Collections.replaceAll(list, "one", "Yo");
        System.out.println("replaceAll: " + list);
        Collections.reverse(list);
        System.out.println("reverse: " + list);
        Collections.rotate(list, 3);
        System.out.println("rotate: " + list);
        List<String> source =
                Arrays.asList("in the matrix".split(" "));
        Collections.copy(list, source);
        System.out.println("copy: " + list);
        Collections.swap(list, 0, list.size() - 1);
        System.out.println("swap: " + list);
        Collections.shuffle(list, new Random(47));
        System.out.println("shuffled: " + list);
        Collections.fill(list, "pop");
        System.out.println("fill: " + list);
        System.out.println("frequency of 'pop': " +
                Collections.frequency(list, "pop"));
        List<String> dups = Collections.nCopies(3, "snap");
        System.out.println("dups: " + dups);
        System.out.println("'list' disjoint 'dups'?: " +
                Collections.disjoint(list, dups));
        // Getting an old-style Enumeration:
        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<String>();
        while(e.hasMoreElements())
            v.addElement(e.nextElement());
        // Converting an old-style Vector
        // to a List via an Enumeration:
        ArrayList<String> arrayList =
                Collections.list(v.elements());
        System.out.println("arrayList: " + arrayList);
    }
}
