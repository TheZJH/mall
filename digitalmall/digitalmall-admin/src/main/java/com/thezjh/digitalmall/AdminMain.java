package com.thezjh.digitalmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author thezjh
 * @create 2022/5/5 下午12:43
 */
@SpringBootApplication
@MapperScan("com.thezjh.digitalmall.dao")
//跳过检查 swagger 配置文件
@ComponentScan(excludeFilters =
        {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.thezjh.digitalmall.config.SwaggerConfig")
        })
public class AdminMain {
    public static void main(String[] args) {
        SpringApplication.run(AdminMain.class, args);
    }
}
