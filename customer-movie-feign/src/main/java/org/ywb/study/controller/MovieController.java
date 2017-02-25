package org.ywb.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ywb.study.client.UserFeignClient;
import org.ywb.study.entity.User;

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

    @GetMapping("/user")
    public User user(User user){
        return this.userFeignClient.postUser(user);
    }

    @GetMapping("/get-user")
    public User getUser(User user){
        return this.userFeignClient.getUser(user);
    }
}
