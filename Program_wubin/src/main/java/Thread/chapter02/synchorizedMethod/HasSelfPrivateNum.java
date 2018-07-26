package Thread.chapter02.synchorizedMethod;

public class HasSelfPrivateNum {
    private int num = 0;

   synchronized public void add(String name){
//    public void add(String name){
        try {

            if (name.equals("a")) {
                num = 100;
                System.out.println("A set over");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("B set over");
            }
            System.out.println("name" + " " + num);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
