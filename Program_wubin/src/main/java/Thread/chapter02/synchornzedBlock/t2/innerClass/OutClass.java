package Thread.chapter02.synchornzedBlock.t2.innerClass;

public class OutClass {
    static class Inner{
        public void method1(){
            synchronized ("wubin"){
                int i = 0;
                while (i<10){
                    System.out.println(Thread.currentThread().getName()+" i = " + i);
                    i++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        synchronized public void method2(){
            int i = 11;
            while (i<20){
                System.out.println(Thread.currentThread().getName()+" i = " + i);
                i++;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
