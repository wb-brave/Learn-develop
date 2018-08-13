package cn.wb.learning;


import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication(scanBasePackages = "cn.wb.learning.web.i18n")
public class SpringBootApplication {
    public static void main(String[] wb){
        SpringApplication.run(SpringBootApplication.class,wb);
    }
}
