package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author TheZJH
 * @create 2022/1/20 19:53
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.atguigu.springcloud"}) // 必须配置，不然开启热部署使用 IDEA 的启动器启动，会报错 Whitelabel Error Page
public class PaymentMain8001 {
    public static void main(String[] args) {
        // SpringBoot 主启动类
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
