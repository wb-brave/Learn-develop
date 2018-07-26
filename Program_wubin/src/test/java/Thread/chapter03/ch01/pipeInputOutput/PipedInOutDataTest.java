package Thread.chapter03.ch01.pipeInputOutput;

import Thread.chapter03.ch01.p_r_test.ThreadA;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import static org.junit.Assert.*;

public class PipedInOutDataTest {
    public static void main(String[] wn){
        ReadData readData = new ReadData();
        WriteData writeData = new WriteData();
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        try {
            pipedOutputStream.connect(pipedInputStream);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    readData.writeMethod(pipedInputStream);
                }
            });
            thread.start();
            Thread.sleep(5000);
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    writeData.writeMethod(pipedOutputStream);
                }
            });
            thread1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}