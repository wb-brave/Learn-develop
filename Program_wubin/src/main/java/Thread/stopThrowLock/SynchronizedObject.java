package Thread.stopThrowLock;

public class SynchronizedObject {
    private String username = "a";
    private String password = "aa";

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    synchronized public void print(String name, String pass){

        try {

            this.username = name;
            Thread.sleep(100000);
            this.password = pass;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
