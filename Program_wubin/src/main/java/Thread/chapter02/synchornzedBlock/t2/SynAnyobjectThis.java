package Thread.chapter02.synchornzedBlock.t2;

public class SynAnyobjectThis {
    private String anyObject = new String();
    public void a(){
//        String anyObject = new String();
        synchronized (anyObject){

            System.out.println("a begin ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("a end ");
        }
    }
    synchronized public void b(){
//        String anyObject = new String();

            System.out.println("b begin ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b end ");
    }
}
