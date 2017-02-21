package org.ywb.study.feignclient;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.ywb.study.config.MyFeignConfiguration;
import org.ywb.study.entity.User;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/2/14
 * Time: 10:35
 * see: https://github.com/OpenFeign/feign
 * 自定义 feignClient 的配置信息，和 ribbon 一样，不能将配置文件暴露在 @SpringBootApplication 扫描的包中。
 */
@FeignClient(name = "provider-user", configuration = MyFeignConfiguration.class, fallback = UserFeignFallBackClient.class)
public interface UserFeignClient {

    @RequestLine("GET /simple/{id}")
    User findById(@Param("id") Long id);
}
