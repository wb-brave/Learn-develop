package Thread.chapter05.timer.schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test2 {
//    private static Timer timer = new Timer();
    private static Timer timer = new Timer();//设置为守护进程

    static public class myTask1 extends TimerTask {
        @Override
        public void run() {

            System.out.println("1 start run time id " + new Date());
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1 end run time id " + new Date());
        }
    }
    static public class myTask2 extends TimerTask {
        @Override
        public void run() {

            System.out.println("2 start run time id " + new Date());
            System.out.println("2 run time id " + new Date());
            System.out.println("2 end run time id " + new Date());
        }
    }

    public static void main(String[] wb) {
        myTask1 myTask1 = new myTask1();
        myTask2 myTask2 = new myTask2();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString1 = "2018-06-01 12:12:12";
        String dateString2 = "2018-06-01 12:12:22";
        try {
            Date date1 = sdf.parse(dateString1);
            Date date2 = sdf.parse(dateString2);
            System.out.println("dateString1 is " + date1 + " current tinem is " + new Date().toLocaleString());
            System.out.println("dateString2 is " + date2 + " current tinem is " + new Date().toLocaleString());
            timer.schedule(myTask1, date1);
            timer.schedule(myTask2, date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
