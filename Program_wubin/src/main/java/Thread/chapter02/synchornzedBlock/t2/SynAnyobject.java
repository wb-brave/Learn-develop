package Thread.chapter02.synchornzedBlock.t2;

public class SynAnyobject {
    private String username;
    private String password;
    //    private String anyObject = "";
    public void setProporty(String name,String pass){
        String anyObject = new String();
        synchronized (anyObject){
            System.out.println("Thread.currentThread().getName() begin "+Thread.currentThread().getName()+" 进入同步代码块时间 "+System.currentTimeMillis());
            this.username=name;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.password=pass;
            System.out.println("Thread.currentThread().getName() end "+Thread.currentThread().getName()+" 退出同步代码块时间 "+System.currentTimeMillis());
        }
    }
}
