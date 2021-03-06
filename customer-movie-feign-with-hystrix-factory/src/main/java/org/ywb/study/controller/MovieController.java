package org.ywb.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.ywb.study.entity.User;
import org.ywb.study.feignclient.UserFeignClient;

/**
 * Created by Administrator on 2017/2/11.
 */
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable("id") Long id){
        return this.userFeignClient.findById(id);
    }

}
