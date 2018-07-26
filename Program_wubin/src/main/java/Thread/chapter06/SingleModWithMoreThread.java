package Thread.chapter06;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingleModWithMoreThread implements Serializable{

    private static final long serialVersionUID = 999l;
    private static class innerClass{
        private static SingleModWithMoreThread singleModWithMoreThread = new SingleModWithMoreThread();
    }

    private SingleModWithMoreThread(){

    }

    public static SingleModWithMoreThread getInstance(){
        SingleModWithMoreThread singleModWithMoreThread = innerClass.singleModWithMoreThread;
        return singleModWithMoreThread;
    }

    /*
    加入此方法是序列化保持一致
     */
//    protected Object readResolve() throws ObjectStreamException{
//        System.out.println("asdasda");
//        return innerClass.singleModWithMoreThread;
//    }
}
