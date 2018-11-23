package thinkinjava.chapter15.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/21        wubin            0.0.1
 */
public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessorRunner<String, Faulure1> processors = new ProcessorRunner<>();
        for (int i = 0; i < 3; i++) {
            processors.add(new Processor1());
        }
        try {
            System.out.println(processors.processAll());
        } catch (Faulure1 faulure1) {
            System.out.println(faulure1);
        }

        ProcessorRunner<Integer, Faulure2> processors1 = new ProcessorRunner<>();
        for (int i = 0; i < 3; i++) {
            processors1.add(new Processor2());
        }
        try {
            System.out.println(processors1.processAll());
        } catch (Faulure2 faulure2) {
            System.out.println("Exception " + faulure2);
        }
    }
}

interface Processor<T, E extends Exception> {
    void process(List<T> resultCollector) throws E;
}

class ProcessorRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E> teProcessor : this) {
            teProcessor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Faulure1 extends Exception {

}

class Processor1 implements Processor<String, Faulure1> {
    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Faulure1 {
        if (count-- > 1) {
            resultCollector.add("help!!!");
        } else {
            resultCollector.add("no!!!");
        }
        if (count < 0) {
            throw new Faulure1();
        }
    }
}

class Faulure2 extends Exception {

}

class Processor2 implements Processor<Integer, Faulure2> {
    static int count = 2;

    @Override
    public void process(List<Integer> resultCollector) throws Faulure2 {
        if (count-- == 0) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }
        if (count < 0) {
            throw new Faulure2();
        }
    }
}