package thinkinjava.chapter17.containers;

import java.util.*;

/**
 * @author wubin
 * @Description 生成好的hashcode函数
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/21        wubin            0.0.1
 */
public class CountedString {

    private static List<String> created = new ArrayList<>();

    private String s;
    private int id = 0;
    private char c = 'A';

    public CountedString(String s) {
        this.s = s;
        created.add(s);
        for (String s1 : created) {
            if (s1.equals(this.s)){
                id++;
                c++;
            }
        }
    }

    @Override
    public String toString() {
        return "CountedString{" +
                "s='" + s + '\'' +
                ", id=" + id + ", c=" + c +", hashCode(): "+ hashCode() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CountedString that = (CountedString) o;
        return id == that.id &&
                Objects.equals(s, that.s) && Objects.equals(c,c);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        result = 37 * result + c;
        return result;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] countedStrings = new CountedString[5];
        for (int i = 0; i < countedStrings.length; i++) {
            countedStrings[i] = new CountedString("hi");
            map.put(countedStrings[i],i);
        }

        System.out.println(map);

        for (CountedString string : countedStrings) {
            System.out.println("look up: " + string);
            System.out.println(map.get(string));
        }

    }
}
