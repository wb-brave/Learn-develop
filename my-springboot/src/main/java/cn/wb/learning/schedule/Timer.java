package cn.wb.learning.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Timer {

    @Scheduled(cron = "0/2 * * * * ?")
    public void test(){
        System.out.println("执行定时时间打印 "+new Date());
    }
}
