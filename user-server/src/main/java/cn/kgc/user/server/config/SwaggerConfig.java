package cn.kgc.user.server.config;

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
 * Created by Tiler on 2020/4/15
 */
//swagger:说明文档+调试工具
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    //basePackage:需要扫描swagger注解的包
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.kgc.cinema.server.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("电影院门店管理API")
                .description("提供电影门店的增删改查等服务。")
                .termsOfServiceUrl("http://www.jwkt.net")
                .version("1.0")
                .build();
    }
}
