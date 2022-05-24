package com.atguigu.springcloud.service.imp;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import java.util.UUID;

/**
 * @author thezjh
 * @create 2022/4/11 上午11:32
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class IMessageProviderImpl implements com.atguigu.springcloud.service.IMessageProvider {
    @Resource
    @Output()
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial:" + serial);
        return null;
    }
}