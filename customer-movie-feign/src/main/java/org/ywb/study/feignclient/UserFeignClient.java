package org.ywb.study.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ywb.study.entity.User;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/2/14
 * Time: 10:35
 */
@FeignClient(name = "provider-user")
public interface UserFeignClient {

    /**
     * feignclient中存在的坑，
     * 1、@GetMapping 注解在@FeignClient中不支持，必须指定请求的method
     * 2、@PathVariable 必须有value值
     */
    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    User postUser(@RequestBody User user);

    /**
     * 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。可能是我没找到相应的注解或使用方法错误。
     * Exception :
     * feign.FeignException: status 405 reading UserFeignClient#getUser(User); content:
     * {"timestamp":1487040547736,"status":405,"error":"Method Not Allowed",
     * "exception":"org.springframework.web.HttpRequestMethodNotSupportedException",
     * "message":"Request method 'POST' not supported","path":"/get-user"}
     */
    @RequestMapping(value = "/get-user", method = RequestMethod.GET)
    User getUser(User user);
}
