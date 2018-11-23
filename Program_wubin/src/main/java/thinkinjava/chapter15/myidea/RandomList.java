package thinkinjava.chapter15.myidea;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author wubin
 * @Description 类型信息（也就是泛型）不用使用于静态属性
 * 以为static域是静态的域，泛型却是动态的
 * @project Learn-develop
 * @package thinkinjava.chapter15.myidea
 * @email wubin326@qq.com
 * @date 2018/11/06
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/06        wubin            0.0.1
 */
public class RandomList<T> {

    private static final Random rand = new Random(47);
    private ArrayList<T> storage = new ArrayList<>();

    public void add(T t) {
        storage.add(t);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public int size() {
        return storage.size();
    }

    public static void main(String[] args) {
        RandomList<String> stringRandomList = new RandomList<>();
        for (String s :
                "wu bin bu xinag shi zui ping yong de".split(" ")) {
            stringRandomList.add(s);
        }
        for (int i = 0; i < stringRandomList.size(); i++) {

            System.out.print(stringRandomList.select() + " ");
        }
    }
}
