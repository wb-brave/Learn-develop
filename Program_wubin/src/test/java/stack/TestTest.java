package stack;

import javafx.collections.transformation.SortedList;
import org.junit.Test;

import javax.jws.Oneway;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

public class TestTest {

    @Test
    public void main() {
        String s = "S";
        String str="N1E2S3M";
        String[] strings = str.split(" ");
        ConcurrentHashMap<Object, Object> hashMap = new ConcurrentHashMap<>();
        hashMap.put(1,1);
        hashMap.put(1,2);
        hashMap.put(1,3);
        hashMap.put(null,null);
        for (Object object : hashMap.keySet()){
            System.out.println(hashMap.get(object));
        }
        for (String s1:strings
             ) {
            System.out.print(s1+" ");
        }
        if (str.contains(s)){
            System.out.println(11111);
            System.out.println(str.substring(3,5));
        }
        System.out.println(str.indexOf(s));

        System.out.println(5^2);
        System.out.println(5&2);
        System.out.println(9|2);
        //从左到右，先计算比较运算符，之后再进行表达式计算ß
        System.out.println((5 < 0) ? 1 : (5 >= 10) ? 10 : 5 + 1);
    }
    @Test
    public void testList(){
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(null);
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(null);
        linkedList.add(null);
        linkedList.add(null);
        linkedList.add(null);
        Vector vector = new Vector();
        vector.add(null);
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        hashtable.put(1,null);//不允许value出现null值，会报空指针异常
        hashtable.put(null,null);
    }

    @Test
    public void testSet(){
        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(8);
        for (Object a: treeSet){
            System.out.println(a);
        }
    }

    static final class Node{
        int nun;
        int name;
    }
}