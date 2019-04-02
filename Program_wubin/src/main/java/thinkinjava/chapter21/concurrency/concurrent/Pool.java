package thinkinjava.chapter21.concurrency.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author wubin
 * @Description semephore技术信号量：可以允许n个任务同时访问一个资源
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.concurrent
 * @email wubin326@qq.com
 * @date 2019/01/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/23        wubin            0.0.1
 */
public class Pool<T> {

    private int size;
    private List<T> items = new ArrayList<>();
    private volatile boolean[] checkedOut;
    private Semaphore avaliable;

    public Pool(Class<T> tClass, int size) {
        this.size = size;
        checkedOut = new boolean[size];
        /**
         * 第二个参数决定是公平锁还是非公平锁
         */
        avaliable = new Semaphore(size, true);
        for (int i = 0; i < size; i++) {
            try {
                items.add(tClass.newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public T checkOut() throws InterruptedException {
        avaliable.acquire();
        return getItem();
    }

    public synchronized T getItem() {
        for (int i = 0; i < size; i++) {
            if (!checkedOut[i]){
                checkedOut[i] = true;
                return items.get(i);
            }
        }
        return null;
    }

    public void checkIn(T x){
        if (releaseItem(x)){
            avaliable.release();
        }
    }

    private synchronized boolean releaseItem(T x) {
        int i = items.indexOf(x);
        if (1 == -1){
            return false;
        }
        if (checkedOut[i]){
            checkedOut[i] = false;
            return true;
        }
        return false;
    }
}
