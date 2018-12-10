package thinkinjava.chapter16.arrays;

import util.generator.Generated;
import util.generator.Generator;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter16.arrays
 * @email wubin326@qq.com
 * @date 2018/12/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/07        wubin            0.0.1
 */
public class CompType implements Comparable<CompType> {

    int i, j;
    private static int count = 1;

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int compareTo(CompType rv) {
        return (i < rv.i ? -1 : (i == rv.i ? 0 : 1));
    }

    private static Random rand = new Random(47);
    public static Generator<CompType> generator(){
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(rand.nextInt(100),rand.nextInt(100));
            }
        };
    }

    @Override
    public String toString() {
        String result = "CompType{" +
                "i=" + i +
                ", j=" + j +
                '}';
        if (count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        CompType[] a =
                Generated.array(new CompType[12], generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        /**
         * a必须要实现Comparable接口
         */
        Arrays.sort(a);
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
    }
} 
