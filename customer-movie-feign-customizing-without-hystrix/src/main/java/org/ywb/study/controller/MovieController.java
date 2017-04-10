package org.ywb.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.ywb.study.entity.User;
import org.ywb.study.feignclient.UserFeignClient;
import org.ywb.study.feignclient.UserFeignClient2;

/**
 * Created by Administrator on 2017/2/11.
 */
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private UserFeignClient2 userFeignClient2;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable("id") Long id){
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName){
        return this.userFeignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
    }

}
