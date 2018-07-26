package Thread.chapter02.volatile3;

public class RunThread extends Thread {
    volatile private boolean flag = true;
    /*
    若不加volatile 会出现死循环，因为flag变量会存在线程私有的堆栈中
    而这个关键字是使线程强制获取公共的堆栈变量
     */
//    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean flag(){
        return flag;
    }

    @Override
    public void run() {

        System.out.println("in run ");
        while (flag){

        }
        System.out.println("out run ");

    }
}
