package thinkinjava.chapter17.exercise;

import thinkinjava.chapter17.containers.ToDoList;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.exercise
 * @email wubin326@qq.com
 * @date 2018/12/13
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/13        wubin            0.0.1
 */
public class Exer11 extends PriorityQueue<Exer11.Compara> {
    static class Compara implements Comparable<Exer11.Compara> {
        private Random rand = new Random(47);
        /**
         * 初始化为1-100之间的数
         */
        private Integer i = rand.nextInt() * 100;

        public Compara(Integer i) {
            this.i = i;
        }

        @Override
        public int compareTo(Compara o) {
            if (i > o.i) {
                return +1;
            } else if (i == o.i) {
                return 0;
            }else
                return -1;
        }

        @Override
        public String toString() {
            return "Compara{" +
                    "i=" + i +
                    '}';
        }

    }
    public void add(Integer integer){
        super.add(new Compara(integer));
    }

    public static void main(String[] args) {
        Exer11 exer11 = new Exer11();
        exer11.add(4);
        exer11.add(2);
        exer11.add(7);
        exer11.add(3);
        exer11.add(1);
        exer11.add(1);
        while (!exer11.isEmpty()){
            System.out.println(exer11.poll());
        }
    }
}
