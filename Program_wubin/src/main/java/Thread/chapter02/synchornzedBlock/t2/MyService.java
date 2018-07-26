package Thread.chapter02.synchornzedBlock.t2;

public class MyService {
    public MyList addServiceMethod(MyList list,String element){
        try {
            synchronized (list){
                if (list.getSize()<1) {
                    Thread.sleep(3000);
                    list.add(element);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
