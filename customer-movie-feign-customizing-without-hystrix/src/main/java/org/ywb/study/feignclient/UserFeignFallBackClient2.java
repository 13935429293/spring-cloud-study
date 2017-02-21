package org.ywb.study.feignclient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.ywb.study.entity.User;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/2/18
 * Time: 16:34
 */
@Component
public class UserFeignFallBackClient2 implements UserFeignClient2 {

    @Override
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName) {
        return "hystrix fallback default";
    }
}
