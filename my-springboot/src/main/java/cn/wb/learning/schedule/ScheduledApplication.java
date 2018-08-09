package cn.wb.learning.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduledApplication {
    public static void main(String[] wb){
        SpringApplication.run(ScheduledApplication.class,wb);
    }
}
