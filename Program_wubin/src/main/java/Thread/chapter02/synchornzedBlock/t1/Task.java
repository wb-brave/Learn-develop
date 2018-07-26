package Thread.chapter02.synchornzedBlock.t1;

public class Task {
    private String getData;
    private String getData1;
    public void doLongTask(){
        try{

            System.out.println("begin task: ");
            Thread.sleep(3000);
            String data1 = "长时间处理任务后从远程返回的值1 threadname "+Thread.currentThread().getName();
            String data2 = "长时间处理任务后从远程返回的值2 threadname "+Thread.currentThread().getName();

            synchronized (this) {
                getData = data1;
                getData1 = data2;
            }
            System.out.println(getData);
            System.out.println(getData1);
            System.out.println("end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
