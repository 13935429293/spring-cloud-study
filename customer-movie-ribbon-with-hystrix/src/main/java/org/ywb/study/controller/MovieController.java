package org.ywb.study.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.ywb.study.entity.User;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/2/11.
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * The default, and the recommended setting, is to run commands using thread isolation (THREAD).
     * 默认值和推荐设置是使用线程隔离（THREAD）运行命令。
     *
     * Commands executed in threads have an extra layer of protection against latencies beyond what network timeouts can offer.
     * 在线程中执行的命令具有超出网络超时可提供的延迟的额外保护层。
     *
     * Generally the only time you should use semaphore isolation (SEMAPHORE) is when the call is so high volume
     * (hundreds per second, per instance) that the overhead of separate threads is too high; this typically only applies to non-network calls.
     * 一般来说，你应该使用信号量隔离（SEMAPHORE）的唯一时间是当调用是如此高的量（每秒百万次，每个实例），单独的线程的开销太高; 这通常仅适用于非网络呼叫。
     *
     * THREAD - 它在单独的线程上执行，并发请求受线程池中的线程数量的限制
     * SEMAPHORE - 它在调用线程上执行，并发请求受到信号量计数的限制
     */
    @GetMapping("/movie/{id}")
    @HystrixCommand(fallbackMethod = "getDefaultUser", commandProperties = {@HystrixProperty(name = "execution.isolation.strategy", value = "THREAD")})
    public User findById(@PathVariable("id") Long id){
        return this.restTemplate.getForObject("http://provider-user/simple/" + id, User.class);
    }

    // 参数和返回值必须与原方法是一致的
    public User getDefaultUser(Long id){
        return new User(id, "默认用户", "张三", (short) 18, BigDecimal.TEN);
    }
}
