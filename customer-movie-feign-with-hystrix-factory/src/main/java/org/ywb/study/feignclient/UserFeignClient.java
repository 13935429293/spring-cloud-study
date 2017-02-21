package org.ywb.study.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ywb.study.entity.User;
import org.ywb.study.feignclient.fallbackImpl.UserFeignFallBackFactory;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/2/14
 * Time: 10:35
 */
@FeignClient(name = "provider-user", fallbackFactory = UserFeignFallBackFactory.class)
public interface UserFeignClient {

    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

}
