package org.ywb.study;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CustomerMovieFeignWithHystrixFactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerMovieFeignWithHystrixFactoryApplication.class, args);
    }

    //@Bean
    //Logger.Level feignLoggerLevel() {
    //    return Logger.Level.FULL;
    //}
}
