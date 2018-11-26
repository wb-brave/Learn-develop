package thinkinjava.chapter10.innerclass;

/**
 * @author wubin
 * @Description 局部内部类
 * @project Learn-develop
 * @package thinkinjava.chapter10.innerclass
 * @email wubin326@qq.com
 * @date 2018/11/26
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/26        wubin            0.0.1
 */
public class LocalinnerClass {
    private int count = 0;

    Counter getCounter(String name) {
        class LocalCounter implements Counter {
            public LocalCounter() {
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        }
        return new LocalCounter();
    }

    Counter getCounter1(String name) {
        return new Counter() {
            /**
             * 匿名内部类没有构造方法
             * 但是可以代码块来替代
             * @return
             */ {
                System.out.println("anonymous counter");
            }

            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        };
    }

    Counter getCounter2(String name) {
        if (name != null) {
            return new Counter() {
                /**
                 * 匿名内部类没有构造方法
                 * 但是可以代码块来替代
                 * @return
                 */ {
                    System.out.println("anonymous counter");
                }

                @Override
                public int next() {
                    System.out.println(name);
                    return count++;
                }
            };
        }
        return null;
    }


    public static void main(String[] args) {
        LocalinnerClass localinnerClass = new LocalinnerClass();
        localinnerClass.getCounter("local inner");
        localinnerClass.getCounter1("anonymous inner");
    }
}

interface Counter {
    int next();
}


