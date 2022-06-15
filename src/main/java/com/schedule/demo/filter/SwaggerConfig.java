

package com.schedule.demo.filter;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************
 * @ClassName SwaggerConfig
 * @Description swagger配置文件
 * @Author maojianyun
 * @Date 2019/11/30 23:25
 * @Version V1.0
 * ****************************************************
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable:true}")
    private boolean swaggerEnable;

    @Bean
    public Docket api() {
        ParameterBuilder Authorization = new ParameterBuilder();
        ParameterBuilder sign = new ParameterBuilder();
        ParameterBuilder timestamp = new ParameterBuilder();
        ParameterBuilder nonce = new ParameterBuilder();
        ParameterBuilder AccessKey = new ParameterBuilder();
        List<Parameter> pars = new ArrayList();
        Authorization.name("Authorization").description("用户token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        sign.name("X-SIGN").description("签名").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        timestamp.name("X-SIGN-TIMESTAMP").description("时间戳").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        nonce.name("X-SIGN-NONCE").description("流水号").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        AccessKey.name("X-SIGN-ACCESSKEY").description("用户验证唯一标识").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(Authorization.build());
        pars.add(sign.build());
        pars.add(timestamp.build());
        pars.add(nonce.build());
        pars.add(AccessKey.build());
        return (new Docket(DocumentationType.SWAGGER_2)).enable(this.swaggerEnable).globalOperationParameters(pars).apiInfo(this.apiInfo()).select().apis(RequestHandlerSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error.*"))).paths(PathSelectors.any()).build();
    }

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //标题
                .title("Schedule接口文档")
                //描述
                .description("Schedule监控服务相关接口文档")
                //版本
                .version("1.0")
                .build();
    }
}