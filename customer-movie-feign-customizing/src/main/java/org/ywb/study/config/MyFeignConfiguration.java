package org.ywb.study.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.ywb.study.annotation.ExcludeFromComponentScan;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/2/14
 * Time: 11:10
 */
@ComponentScan
@ExcludeFromComponentScan
public class MyFeignConfiguration {

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}
