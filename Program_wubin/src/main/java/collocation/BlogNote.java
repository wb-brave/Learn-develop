package collocation;

import java.util.*;

public class BlogNote{
    public static void main(String[] args){
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1,"wubin");
        map1.put(1,"wubin1");
        map1.put(1,"wubin2");
        for (Integer integer: map1.keySet()
             ) {
            System.out.println(integer + " " + map1.get(integer));
        }
        System.out.println(map1.size());
        List l1 = new ArrayList();
        int i = 0;
        do {
            i++;
            l1.add(i);
        }while (i<5);
        List l2 = new ArrayList();
        int i5 = 1;
        do {
            i5++;
            l2.add(i5);
        }while (i<3);
        int m = (int)l1.get(4)&3;
        int m1 = (int)l1.get(4)>>1;
        System.out.println(m + " " + m1 + " " +l1.size());
        l1.add(4,12);
        int[] i2 = {1,2,3,4,5,6,7};
        System.arraycopy(i2,2,i2,3,4);
        for (int tmp: i2
             ) {
            System.out.print(tmp + " ");
        }
    }
}
