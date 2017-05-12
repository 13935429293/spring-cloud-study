package org.ywb.study.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ywb.study.config.MyFeignConfiguration2;

/**
 * User: yangwenbiao
 * Date: 2017/2/14
 * Time: 10:35
 * see: https://github.com/OpenFeign/feign
 * 自定义 feignClient 的配置信息，和 ribbon 一样，不能将配置文件暴露在 @SpringBootApplication 扫描的包中。
 */
@FeignClient(name = "xxx", url = "http://localhost:8761/", configuration = MyFeignConfiguration2.class, fallback = UserFeignFallBackClient2.class)
public interface UserFeignClient2 {

    @RequestMapping(value = "/eureka/apps/{serviceName}")
    String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
