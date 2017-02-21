package org.ywb.study.config;

import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.ywb.study.annotation.ExcludeFromComponentScan;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/2/14
 * Time: 11:10
 */
@ComponentScan
@ExcludeFromComponentScan
public class MyFeignConfiguration2 {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }



}
