package Thread.chapter06;

import java.io.*;


public class SingleModWithMoreThreadTest {

    public static void main(String[] wb) {

        SingleModWithMoreThread singleModWithMoreThread = SingleModWithMoreThread.getInstance();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/wufan/Desktop/myFile.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(singleModWithMoreThread);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println(singleModWithMoreThread.hashCode());

            FileInputStream fileInputStream = new FileInputStream(new File("/Users/wufan/Desktop/myFile.txt"));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SingleModWithMoreThread singleModWithMoreThread1 = (SingleModWithMoreThread) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(singleModWithMoreThread1.hashCode());

        } catch (Exception e) {
            e.printStackTrace();
        }

//        Runnable[] runnables = new Runnable[5];
//        for (int i = 0; i < 5; i++) {
//            runnables[i] = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(SingleModWithMoreThread.getInstance().hashCode());
//                }
//            };
//        }
//        for (int i = 0; i < 5; i++) {
//            new Thread(runnables[i]).start();
//        }
    }

}