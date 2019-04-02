package thinkinjava.chapter17.containers;

import java.util.List;

/**
 * @author wubin
 * @Description 测试容器的驱动类
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/21        wubin            0.0.1
 */
public class Tester<C> {
    public static int fieldWidth = 8;
    public static TestParam[] defaultParams = TestParam.array(
            10, 5000, 100, 5000, 1000, 5000, 10000, 500
    );

    protected C initiallize(int size) {
        return container;
    }

    protected C container;

    private String hesadline = "";
    private List<Test<C>> tests;

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";
    private TestParam[] paramList = defaultParams;

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null) {
            hesadline = container.getClass().getSimpleName();
        }
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }

    public void setHesadline(String hesadline) {
        this.hesadline = hesadline;
    }

    public static <C> void run(C cntnr, List<Test<C>> tests) {
        new Tester(cntnr, tests).timedTest();
    }

    public static <C> void run(C cntnr, List<Test<C>> tests, TestParam[] paramList) {
        new Tester(cntnr, tests, paramList).timedTest();
    }

    private void displayHeader() {
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - hesadline.length() - 1;
        StringBuilder builder = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++) {
            builder.append("-");
        }
        builder.append(' ').append(hesadline).append(' ');
        for (int i = 0; i < dashLength / 2; i++) {
            builder.append("-");
        }
        System.out.println(builder);
        System.out.printf(sizeField, "size");
        for (Test<C> test : tests) {
            System.out.format(stringField(), test.name);
        }
        System.out.println();
    }

    public void timedTest() {
        displayHeader();
        for (TestParam param : paramList) {
            System.out.format(sizeField, param.size);
            for (Test<C> test : tests) {
                C initiallize = initiallize(param.size);
                long start = System.nanoTime();
                int reps = test.test(initiallize, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.format(numberField(), timePerRep);
            }
            System.out.println();
        }
    }
}

