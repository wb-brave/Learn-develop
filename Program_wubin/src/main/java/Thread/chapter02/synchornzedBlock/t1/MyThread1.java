package Thread.chapter02.synchornzedBlock.t1;

public class MyThread1 extends Thread {

    private Task task;

    public MyThread1(Task task){
        super();
        this.task = task;
    }

    @Override
    public void run() {

        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}
