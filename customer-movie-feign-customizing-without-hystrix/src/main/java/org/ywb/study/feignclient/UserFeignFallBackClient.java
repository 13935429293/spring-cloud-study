package org.ywb.study.feignclient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.ywb.study.entity.User;

/**
 * User: yangwenbiao
 * Date: 2017/2/18
 * Time: 16:34
 */
@Component
public class UserFeignFallBackClient implements UserFeignClient {

    @Override
    public User findById(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
