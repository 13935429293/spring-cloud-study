package org.ywb.study.config;

import feign.Contract;
import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.ywb.study.annotation.ExcludeFromComponentScan;

/**
 * User: yangwenbiao
 * Date: 2017/2/14
 * Time: 11:10
 */
@ComponentScan
@ExcludeFromComponentScan
public class MyFeignConfiguration {

    // 使用feign原生的规则
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 配置单个feign禁用hystrix
     * @return
     */
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
