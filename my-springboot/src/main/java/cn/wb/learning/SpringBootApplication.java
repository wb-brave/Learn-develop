package cn.wb.learning;


import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;

@org.springframework.boot.autoconfigure.SpringBootApplication(scanBasePackages = "cn.wb.learning.cache")
//druid相关配置
//@ServletComponentScan
//@MapperScan(basePackages = "cn.wb.learning.database.pagehelper.dao")
@EnableCaching
public class SpringBootApplication {
    public static void main(String[] wb){
        SpringApplication.run(SpringBootApplication.class,wb);
    }
}
