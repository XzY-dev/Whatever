package com.xzy.cloud.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author XZY
 * @version V1.0
 * @Package com.xzy.cloud.authorization
 * @date 2020/10/21 22:05
 */
@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients
public class Oauth2AuthorizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthorizationApplication.class, args);
    }
}
