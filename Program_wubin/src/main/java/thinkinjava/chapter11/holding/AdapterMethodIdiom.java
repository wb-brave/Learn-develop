package thinkinjava.chapter11.holding;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter11.holding
 * @email wubin326@qq.com
 * @date 2018/12/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/28        wubin            0.0.1
 */
public class AdapterMethodIdiom {

    public static void main(String[] args) {
        ReverseIteratorList<String> strings = new ReverseIteratorList<>(Arrays.asList("to be or not to be".split(" ")));
        for (String s : strings.reverse()) {
            System.out.print(s + " ");
        }

    }
}

class ReverseIteratorList<T> extends ArrayList<T> {
    public ReverseIteratorList(Collection<? extends T> c) {
        super(c);
    }

    public Iterable<T> reverse() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size();

                    @Override
                    public boolean hasNext() {
                        return current > 0;
                    }

                    @Override
                    public T next() {
                        return get(--current);
                    }
                };
            }
        };
    }
}
