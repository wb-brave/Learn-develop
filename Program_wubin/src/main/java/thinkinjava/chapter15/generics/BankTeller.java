package thinkinjava.chapter15.generics;

import util.generator.Generator;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/19        wubin            0.0.1
 */
public class BankTeller {

    private static void serve(Teller teller,Customer customer){
        System.out.println(teller + " serves " + customer);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        LinkedList<Customer> customers = new LinkedList<>();
        Generators.fill(customers,Customer.generator(),15);
        LinkedList<Teller> tellers = new LinkedList<>();
        Generators.fill(tellers,Teller.generator(),4);
        for (Customer customer : customers) {
            serve(tellers.get(random.nextInt(tellers.size())),customer);
        }

    }
}

class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }

    public static Generator<Customer> generator(){
        return () -> new Customer();
    }
}

class Teller{
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    @Override
    public String toString() {
        return "Teller{" +
                "id=" + id +
                '}';
    }

    public static Generator<Teller> generator(){
        return ()-> new Teller();
    }
}