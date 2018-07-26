package Thread.chapter02.synchornzedBlock.t1;

public class MyThread2 extends Thread {

    private Task task;

    public MyThread2(Task task){
        super();
        this.task = task;
    }

    @Override
    public void run() {

        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}
