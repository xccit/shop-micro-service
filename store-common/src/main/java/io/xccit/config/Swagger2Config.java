package io.xccit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author CH_ywx
 * @date 2023-09-08
 * @description Swagger配置
 */
@Configuration
@EnableSwagger2WebMvc
public class Swagger2Config {
    /**
     * 用户API配置
     * @return API
     */
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("userApi")
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.xccit"))
                .paths(PathSelectors.regex("/user/.*"))
                .build();
    }

    /**
     * 地址的API配置
     * @return API
     */
    @Bean
    public Docket addressApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("addressApi")
                .apiInfo(adminApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.xccit"))
                .paths(PathSelectors.regex("/user/address/.*"))
                .build();
    }
    /**
     * 静态资源的API配置
     * @return API
     */
    @Bean
    public Docket staticApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("staticApi")
                .apiInfo(adminApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.xccit"))
                .paths(PathSelectors.regex("/public/.*"))
                .build();
    }

    /**
     * 轮播图的API配置
     * @return API
     */
    @Bean
    public Docket carouselApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("carouselApi")
                .apiInfo(adminApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.xccit"))
                .paths(PathSelectors.regex("/carousel/.*"))
                .build();
    }


    /**
     * 用户Api描述
     * @return
     */
    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了优选商城网站用户微服务接口定义")
                .version("1.0")
                .contact(new Contact("xccit", "https://xccit.io", "darkhorse_1209@outlook.com"))
                .build();
    }
    /**
     * admin的Api描述
     * @return
     */
    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("admin-API文档")
                .description("本文档描述了优选商城网站admin微服务接口定义")
                .version("1.0")
                .contact(new Contact("xccit", "https://xccit.io", "darkhorse_1209@outlook.com"))
                .build();
    }
}
