package thinkinjava.chapter21.concurrency;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/07        wubin            0.0.1
 */
public class CriticalSection {

    static void testApproaches(PairManager pm1, PairManager pm2) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PairManipulator
                pmp1 = new PairManipulator(pm1),
                pmp2 = new PairManipulator(pm2);
        PairChecker
                pc1 = new PairChecker(pm1),
                pc2 = new PairChecker(pm2);
        executorService.execute(pmp1);
        executorService.execute(pmp2);
        executorService.execute(pc1);
        executorService.execute(pc2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
        System.out.println("pmp1: " + pmp1 + "\npmp2: " + pmp2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager
                pm1 = new PairManager1(),
                pm2 = new PairManager2();
        testApproaches(pm1, pm2);
    }
}

class Pair {
    private int x, y;

    public Pair() {
        this(0, 0);
    }

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void incrementX() {
        x++;
    }

    public int getY() {
        return y;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public class PairValueNotEqualException extends RuntimeException {
        public PairValueNotEqualException() {
            super("Pair value not equal: " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairValueNotEqualException();
        }
    }
}

abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

    public synchronized Pair getPair() {
        //通过构造新的pair对象来保护原来对象的值
        return new Pair(p.getX(), p.getY());
    }

    protected void storage(Pair pair) {
        storage.add(pair);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increment();

}

/**
 * 同步整个方法
 */
class PairManager1 extends PairManager {
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        storage(getPair());
    }
}

/**
 * 使用同步代码块进行同步
 */
class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementY();
            p.incrementX();
            temp = getPair();
        }
        storage(temp);
    }
}

class PairManipulator implements Runnable {

    private PairManager pairManager;

    public PairManipulator(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair; " + pairManager.getPair() +
                " checkCounter: " + pairManager.checkCounter.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pairManager;

    public PairChecker(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.checkCounter.incrementAndGet();
            pairManager.getPair().checkState();
        }
    }
}
