package cn.com.zhshzh.daily.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * knife4j配置类
 * 开启knife4j后，前端访问地址为: ip + port + 项目根路径 + /doc.html
 * 如: http://localhost:8989/daily/doc.html
 *
 * @author wangbt
 * @since 2022-01-01
 */
@Configuration
@EnableSwagger2
public class Knife4jConfiguration {

    @Value("${swagger.name}")
    private String name;
    @Value("${swagger.url}")
    private String url;
    @Value("${swagger.email}")
    private String email;
    @Value("${swagger.title}")
    private String title;
    @Value("${swagger.description}")
    private String description;
    @Value("${swagger.version}")
    private String version;

    /**
     * 配置示例-API
     *
     * @return
     */
    @Bean
    public Docket exampleApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("示例API")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(input -> input.contains("example"))
                .build()
                .securityContexts(securityContexts());
    }

    /**
     * 配置车辆管理模块-API
     *
     * @return
     */
    @Bean
    public Docket vehicleApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("车辆管理")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(vehiclePaths())
                .build()
                .securityContexts(securityContexts());
    }

    /**
     * 车辆管理模块的请求路径
     *
     * @return
     */
    private Predicate<String> vehiclePaths() {
        return regex(".*/vehicle.*");
    }

    /**
     * 配置API信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact(name, url, email))
                .version(version)
                .build();
    }

    /**
     * 配置swagger的全局参数
     *
     * @return
     */
    private List<RequestParameter> getGlobalRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("Authorization")
                .description("令牌")
                .required(true)
                .in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build());
        return parameters;
    }

    /**
     * 配置swagger的认证功能
     *
     * @return
     */
    private List<SecurityScheme> securitySchemes() {
        return new ArrayList<>(
                Collections.singleton(new ApiKey("Authorization", "Authorization", "header")));
    }

    /**
     * 配置哪些接口需要认证
     *
     * @return
     */
    private List<SecurityContext> securityContexts() {
        return new ArrayList<>(
                Collections.singleton(SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .build())
        );
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return new ArrayList<>(
                Collections.singleton(new SecurityReference("Authorization", authorizationScopes)));
    }
}
