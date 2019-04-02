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
public class FillByCountriesList {

    public static void main(String[] args) {

        // testList();
        testMapSet();

    }

    public static void testMapSet(){
        HashMap<String, String> map = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < Countries.DATA.length; i++) {
            if (Countries.DATA[i][0].startsWith("A")){
                map.put(Countries.DATA[i][0],Countries.DATA[i][0]);
                hashSet.add(Countries.DATA[i][0]);
            }
        }

        System.out.println(map);
        System.out.println(hashSet);
    }

    public static void testList(){
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(Countries.DATA[i][0]);
            linkedList.add(Countries.DATA[i][1]);
        }
        System.out.println(arrayList);
        System.out.println(linkedList);

        for (int i = 0; i < 10; i++) {
            System.out.println("===============================");
            Collections.shuffle(arrayList);
            Collections.shuffle(linkedList);
            System.out.println(arrayList);
            System.out.println(linkedList);
        }
    }
}
