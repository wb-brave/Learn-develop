package thinkinjava.chapter10.innerclass;

import sun.text.normalizer.UBiDiProps;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter10.innerclass
 * @email wubin326@qq.com
 * @date 2018/11/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/23        wubin            0.0.1
 */
public class Parcel11 {
    private String name;
    private static String name1;

    private static class ParcelContents implements Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination
            implements Destination {
        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
        }

        public String readLable() {
            return label;
        }

        // Nested classes can contain other static elements:
        public static void f() {
        }

        static int x = 10;

        static class AnotherLevel {
            public static void f() {
            }

            static int x = 10;
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {

        Contents c = contents();
        ParcelDestination wubin = new ParcelDestination("wubin");
        Destination d = destination("Tasmania");
    }
} ///:~
