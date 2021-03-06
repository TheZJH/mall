package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.DiscoveredEndpoint;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author TheZJH
 * @create 2022/1/20 20:56
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private EurekaDiscoveryClient eurekaDiscoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")

    public CommonResult create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        log.info("*****插入结果" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("-------查询结果" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功：好耶，serverPort：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询 Id：" + id, null);
        }
    }

    @GetMapping(value ="/payment/lb")
    public String getServerPort() {
        return serverPort;
    }
}



