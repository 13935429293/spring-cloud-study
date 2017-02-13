package org.ywb.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
// @EnableDiscoveryClient 支持其他的服务发现组件 zk, consol
public class ProviderUserI2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProviderUserI2Application.class, args);
	}
}
