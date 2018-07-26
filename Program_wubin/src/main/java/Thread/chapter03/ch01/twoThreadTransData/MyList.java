package Thread.chapter03.ch01.twoThreadTransData;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    volatile private List list = new ArrayList();

    public void setData(){
        list.add("wubin");
    }

    public int getSize(){
       return list.size();
    }
}
