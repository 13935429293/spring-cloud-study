package org.ywb.study.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.ywb.study.entity.User;

/**
 * Created by Administrator on 2017/2/13.
 */
@FeignClient("provider-user")
public interface UserFeignClient {

    @RequestMapping( value = "/simple/{id}", method = RequestMethod.GET )
    User findById(@PathVariable("id") Long id); // 两个坑，@GetMapping注解不起作用，@PathVariable必须给定value值

    @RequestMapping( value = "/user", method = RequestMethod.POST )
    User postUser(@RequestBody User user);

    // 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。
    @RequestMapping(value = "/get-user", method = RequestMethod.GET)
    User getUser(User user);
}
