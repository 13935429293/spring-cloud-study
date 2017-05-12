package org.ywb.study.feignclient.fallbackImpl;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.ywb.study.entity.User;
import org.ywb.study.feignclient.UserFeignClient;
import org.ywb.study.feignclient.UserFeignClientEx;

/**
 * User: yangwenbiao
 * Date: 2017/2/20
 * Time: 15:56
 */
@Component
public class UserFeignFallBackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFeignFallBackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        LOGGER.info("call UserFeignClient error, error msg is : {}");
        return new UserFeignClientEx() {
            @Override
            public User findById(@PathVariable("id") Long id) {
                return new User(-1L, null, null, (short) 20);
            }
        };
    }
}
