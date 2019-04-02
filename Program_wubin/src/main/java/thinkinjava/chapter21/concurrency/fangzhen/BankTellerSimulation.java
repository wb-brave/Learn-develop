package thinkinjava.chapter21.concurrency.fangzhen;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description 银行出纳员仿真
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.fangzhen
 * @email wubin326@qq.com
 * @date 2019/01/24
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/24        wubin            0.0.1
 */
public class BankTellerSimulation {

    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
        executorService.execute(new CustomerGenerator(customers));
        executorService.execute(new TellerManager(executorService,customers,ADJUSTMENT_PERIOD));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

class Customer {
    private final int serviceTime;

    public Customer(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }
}

class CustomerLine extends ArrayBlockingQueue<Customer> {
    public CustomerLine(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[empty]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : this) {
            stringBuilder.append(customer);
        }
        return stringBuilder.toString();
    }
}

class CustomerGenerator implements Runnable {
    private CustomerLine customers;
    private Random random = new Random(47);

    public CustomerGenerator(CustomerLine customers) {
        this.customers = customers;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(300));
                customers.put(new Customer(random.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.out.println("CustomerGenerator is interrupted");
        }
    }
}

class Teller implements Runnable, Comparable<Teller> {

    private static int counter = 0;
    private final int id = counter++;
    private int customerServed = 0;
    private CustomerLine customers;
    private boolean servingCustomerline = true;

    public Teller(CustomerLine customers) {
        this.customers = customers;
    }

    @Override
    public int compareTo(Teller o) {
        return Long.compare(customerServed, o.customerServed);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Customer take = customers.take();
                TimeUnit.MILLISECONDS.sleep(take.getServiceTime());
                /**
                 * 这里需要使用同步措施，一个导购员只能同时服务一个顾客
                 * 知道服务完成
                 */
                synchronized (this) {
                    customerServed++;
                    while (!servingCustomerline) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " terminate");
    }

    public synchronized void doSomethingElse() {
        customerServed = 0;
        servingCustomerline = false;
    }

    public synchronized void servingCustomerline() {
        assert !servingCustomerline : "alreday serving: " + this;
        servingCustomerline = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Teller{" +
                "id=" + id +
                '}';
    }

    public String shortString() {
        return "T-" + id;
    }
}

class TellerManager implements Runnable {
    private ExecutorService executorService;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> tellersDoingOtherThings = new LinkedList<>();
    private int adjustmentPeriod;
    private static Random random = new Random(47);

    public TellerManager(ExecutorService executorService, CustomerLine customers, int adjustmentPeriod) {
        this.executorService = executorService;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;
        Teller teller = new Teller(customers);
        executorService.execute(teller);
        workingTellers.add(teller);
    }

    public void adjustTellerNumber() {
        /**
         * 这是一个控制系统
         * 通过调整数量来控制系统的稳定性
         */
        if (customers.size() / workingTellers.size() > 2) {
            //    如果teller正处于不在接待客户的状态下，将他召回
            if (tellersDoingOtherThings.size() > 0) {
                Teller teller = tellersDoingOtherThings.remove();
                teller.servingCustomerline();
                workingTellers.offer(teller);
                return;
            }
            //    否则创建一个新的teller
            Teller teller = new Teller(customers);
            executorService.execute(teller);
            workingTellers.add(teller);
            return;
        }

        //    如果teller过多
        if (workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2) {
            reassingOneTeller();
        }
        if (customers.size() == 0) {
            while (workingTellers.size() > 1) {
                reassingOneTeller();
            }
        }
    }

    private void reassingOneTeller() {
        Teller poll = workingTellers.poll();
        poll.doSomethingElse();
        tellersDoingOtherThings.offer(poll);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();
                System.out.print(customers + " { ");
                for (Teller teller : workingTellers) {
                    System.out.print(teller.shortString() + " ");
                }
                System.out.println("} ");
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + "terminating");
    }

    @Override
    public String toString() {
        return "TellerManager ";
    }
}
