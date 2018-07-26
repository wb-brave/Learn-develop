package Thread.chapter02.volatile3;

import static org.junit.Assert.*;

public class PrintStringTest {

    public static void main(String[] wubin){
        PrintString printString = new PrintString();
        new Thread(printString,"a").start();
        System.out.println("stop");
        printString.setFlag(false);
    }

}