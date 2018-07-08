package Thread.safeThread;

public class run {
    public static void main(String[] args){
        ALogin aLogin = new ALogin();
        aLogin.start();
        BLogin bLogin = new BLogin();
        bLogin.start();
    }

}
