package Thread.safeThread;

public class LoginServlet {
    private static String name;
    private static String password;
    synchronized public static void doPost(String name1, String password1){

        try{
            name = name1;
            if (name.equals("a")) {
                Thread.sleep(5000);
            }
            password = password1;
            System.out.println(name + " : " + password);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
