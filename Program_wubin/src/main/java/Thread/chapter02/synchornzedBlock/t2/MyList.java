package Thread.chapter02.synchornzedBlock.t2;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List list = new ArrayList();

    synchronized public void add(String element){
        list.add(element);
    }

    synchronized public int getSize(){
        return list.size();
    }
}
