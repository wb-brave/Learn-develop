package Thread.simple_thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrentThreadComplexTest {

    @Test
    public void run() {
        CurrentThreadComplex currentThreadComplex = new CurrentThreadComplex();
        Thread t = new Thread(currentThreadComplex);
        t.setName("wb");
        t.start();
    }
}