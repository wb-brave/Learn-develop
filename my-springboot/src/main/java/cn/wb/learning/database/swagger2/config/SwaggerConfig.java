package cn.wb.learning.database.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.database.swagger2
 * @email wubin326@qq.com
 * @date 2018/08/16
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.wb.learning.database.swagger2"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){

       return new ApiInfoBuilder().title("使用swagger,展示restful")
                .description("编写者--吴彬")
                .termsOfServiceUrl("https://www.cnblogs.com/wu-bin/p/9378550.html")
                .contact("wubin")
                .version("1.0")
                .build();
    }
}
