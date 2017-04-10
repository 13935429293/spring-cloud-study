package org.ywb.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.ywb.study.annotation.ExcludeFromComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(excludeFilters = {@ComponentScan.Filter (type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class)})
public class CustomerMovieFeignCustomizingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerMovieFeignCustomizingApplication.class, args);
    }
}
