package org.ywb.study.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * User: yangwenbiao
 * Date: 2017/2/13
 * Time: 18:04
 */
@ComponentScan
@ExcludeFromComponentScan
public class TestConfiguration {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
