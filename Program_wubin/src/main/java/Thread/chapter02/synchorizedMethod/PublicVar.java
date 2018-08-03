package Thread.chapter02.synchorizedMethod;

public class PublicVar {
    private String username = "A";
    private String password = "AA";

    synchronized public void setValue(String name, String pass) {
        try {

            this.username = name;
            Thread.sleep(5000);
            this.password = pass;
            System.out.println("setValue线程 " + Thread.currentThread().getName() + " username = " + username + " password= " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getValue() {
        System.out.println("getValue线程 " + Thread.currentThread().getName() + " username = " + username + " password= " + password);
    }

}
