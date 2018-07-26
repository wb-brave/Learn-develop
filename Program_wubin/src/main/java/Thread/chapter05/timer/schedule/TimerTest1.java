package Thread.chapter05.timer.schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest1 {
    private static Timer timer = new Timer();
//    private static Timer timer = new Timer(true);//设置为守护进程

    static public class myTask extends TimerTask {
        @Override
        public void run() {

            System.out.println("start run time id " + new Date());
        }
    }

    public static void main(String[] wb) {
        myTask myTask = new myTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2018-07-18 12:25:30";
        try {
            Date date = sdf.parse(dateString);
            System.out.println("dateString is " + date + " current tinem is " + new Date().toLocaleString());
            timer.schedule(myTask, date,2000);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
