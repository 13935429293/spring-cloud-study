package org.ywb.study.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.ywb.study.controller.entity.User;

/**
 * Created by Administrator on 2017/2/11.
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient discoveryClient;

    @GetMapping("serviceUrl")
    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable("id") Long id){
        return this.restTemplate.getForObject("http://provider-user/simple/" + id, User.class);
    }
}
