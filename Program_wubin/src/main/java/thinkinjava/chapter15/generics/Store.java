package thinkinjava.chapter15.generics;

import util.generator.Generator;

import java.util.ArrayList;
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
public class Store extends ArrayList<Aisle> {

    private ArrayList<CheckoutStand> checkout = new ArrayList<>();
    private Office office = new Office();

    public Store(int na, int ns, int np) {

        add(new Aisle(ns,np));
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Aisle a : this)
            for(Shelf s : a)
                for(Product p : s) {
                    result.append(p);
                    result.append("\n");
                }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Store(14, 5, 10));
    }
}

class CheckoutStand {

}

class Office {

}

class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void pricesChange(double change) {
        price += change;
    }

    public static Generator<Product> generator() {
        return new Generator<Product>() {
            private Random rand = new Random(47);

            @Override
            public Product next() {
                return new Product(rand.nextInt(1000), "Test",
                        Math.round(rand.nextDouble() * 1000.0) + 0.99);
            }
        };
    }
}

class Shelf extends ArrayList<Product> {
    public Shelf(int np) {
        Generators.fill(this, Product.generator(), np);
    }
}

class Aisle extends ArrayList<Shelf> {
    public Aisle(int ns, int np) {

        for (int i = 0; i < ns; i++) {
            add(new Shelf(np));
        }
    }
}