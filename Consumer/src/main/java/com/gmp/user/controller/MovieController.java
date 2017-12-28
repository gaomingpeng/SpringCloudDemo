package com.gmp.user.controller;

import com.gmp.user.entity.User;

import com.gmp.user.feigninterface.FeignInterface;
import com.gmp.user.feigninterface.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
public class MovieController {

    private  static  final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

   /* @Autowired
    private RestTemplate restTemplate;*/


    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private UserFeignClient userFeignClient;

   @Autowired
    private FeignInterface feignInterface;

    @Value("${Url}")
     private  String Url;

    @Value("${applicationName}")
    private  String  applicationName;

   // @GetMapping( value = "/user/{id}", produces = { "application/json;charset=UTF-8" })
    @GetMapping("/user/{id}")
    public User findById(@PathVariable int  id){
       // return this.restTemplate.getForObject(Url+id,User.class);
       return this.userFeignClient.findByID(id);//这里不仅实现了声明式的调用还实现了负载均衡
    }

   @GetMapping("/user2/{id}")
    public User findById2(@PathVariable int  id){
      //在此加上了feign日志
        return this.feignInterface.findById(id);
    }
    @GetMapping("/loginstance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose(applicationName);
        //打印当前选择哪个节点
       LOGGER.info("服务名:"+serviceInstance.getServiceId());
        LOGGER.info("IP:"+serviceInstance.getHost());
        LOGGER.info("端口号:"+serviceInstance.getPort());
    }
    @GetMapping("/provider")
    public List<ServiceInstance>  showInfo(){
        return  this.discoveryClient.getInstances("provider");
    }
}
