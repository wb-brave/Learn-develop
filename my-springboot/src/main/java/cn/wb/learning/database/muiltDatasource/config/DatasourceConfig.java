package cn.wb.learning.database.muiltDatasource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.muiltDatasource
 * @email wubin326@qq.com
 * @date 2018/08/15
 */
@Configuration
public class DatasourceConfig {
    @Bean(name = "testDB")
    @Qualifier("testDB")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource primaryDatasource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test1DB")
    @Qualifier(value = "test1DB")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource secondaryDatasource(){
        return DataSourceBuilder.create().build();
    }
}
