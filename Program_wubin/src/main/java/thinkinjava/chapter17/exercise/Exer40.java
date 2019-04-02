package thinkinjava.chapter17.exercise;

import org.apache.poi.ss.formula.functions.T;
import util.generator.RandomGenerator;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.exercise
 * @email wubin326@qq.com
 * @date 2018/12/27
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/27        wubin            0.0.1
 */
public class Exer40 implements Comparable<Exer40>, Comparator<Exer40> {

    private String first;
    private String second;

    public Exer40() {
    }

    // public static class Comp implements Comparator<Exer40> {
    //     @Override
    //     public int compare(Exer40 o1, Exer40 o2) {
    //         return o1.second.equals(o2.second) == true ? 0 : -1;
    //     }
    // }
    @Override
    public int compare(Exer40 o1, Exer40 o2) {
        return o1.second.equals(o2.second) == true ? 0 : -1;
    }

    public Exer40(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Exer40 o) {
        return this.first.compareTo(o.first);
    }

    @Override
    public String toString() {
        return
                "first='" + first + '\'' +
                        ", second='" + second + '\'' +
                        '}';
    }

    static Exer40[] generateArray(List list) {
        RandomGenerator.String string = new RandomGenerator.String(5);
        Exer40[] exer40s = new Exer40[5];
        for (int i = 0; i < exer40s.length; i++) {
            String first = string.next();
            String second = string.next();
            exer40s[i] = new Exer40(first, second);
        }
        list.addAll(Arrays.asList(exer40s));
        return exer40s;
    }

    public static void main(String[] args) {
        List<Exer40> exer40s1 = new ArrayList<>();
        HashMap<Exer40, Integer> map = new HashMap<>();
        Exer40[] exer40s = generateArray(exer40s1);
        System.out.println(Arrays.asList(exer40s));
        Arrays.sort(exer40s);
        System.out.println(Arrays.asList(exer40s));
        // System.out.println(Collections.binarySearch(exer40s1, exer40s[2], new Comp()));
        System.out.println(Collections.binarySearch(exer40s1, exer40s[2], new Exer40()));
    }
}
