package thinkinjava.chapter17.containers.ref;

import java.lang.ref.*;
import java.util.LinkedList;

/**
 * @author wubin
 * @Description 关于java的三种引用类型
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers.ref
 * @email wubin326@qq.com
 * @date 2018/12/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/28        wubin            0.0.1
 */
public class References {

    /**
     * 用做回收前清理工作的工具
     */
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();

    public static void chernQueue() {
        Reference<? extends VeryBig> poll = rq.poll();
        if (poll != null) {
            System.out.println("in queue: " + poll.get());
        }
    }

    public static void main(String[] args) {
        int size = 10;
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            sa.add(new SoftReference<>(new VeryBig("Soft " + i), rq));
            System.out.println("Just created " + sa.getLast());
            chernQueue();
        }
        System.out.println();
        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            wa.add(new WeakReference<>(new VeryBig("weak " + i), rq));
            System.out.println("Just created " + wa.getLast());
            chernQueue();
        }
        System.out.println();
        SoftReference<VeryBig> s = new SoftReference<>(new VeryBig("Soft"));
        WeakReference<VeryBig> w = new WeakReference<>(new VeryBig("weak"));
        /**
         * 当发生gc时，weak会被回收到rq中
         */
        System.gc();
        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            pa.add(new PhantomReference<>(new VeryBig("phantom " + i), rq));
            System.out.println("Just created " + pa.getLast());
            chernQueue();
        }
        System.gc();
        System.out.println();
    }
}

class VeryBig {
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;

    public VeryBig(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + ident);
    }
}
