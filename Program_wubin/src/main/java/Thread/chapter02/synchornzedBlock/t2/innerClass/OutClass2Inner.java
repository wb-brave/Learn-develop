package Thread.chapter02.synchornzedBlock.t2.innerClass;

public class OutClass2Inner {
    static class Inner1{
        public void method1(Inner2 inner2){
            String name = Thread.currentThread().getName();
            synchronized (inner2){
                System.out.println(name+" 进入1的 1方法 ");
                int i = 0;
                while (i<10){
                    System.out.println(name+" i = " + i);
                    i++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name+" 退出1的 1方法 ");
            }
        }

        synchronized public void method2(){
            String name = Thread.currentThread().getName();
            int k = 11;
            System.out.println(name+" 进入1的 2方法 ");
            while (k<20){
                System.out.println(name+" k = " + k);
                k++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name+" 退出1的 2方法 ");
        }
    }
    static class Inner2{
        synchronized public void method1(){
            String name = Thread.currentThread().getName();
            System.out.println(name+" 进入2的 1方法 ");
            for (int j=0; j<10;j++) {
                System.out.println(name + " j " + j);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name+" 退出2的 1方法 ");
        }
    }
}
