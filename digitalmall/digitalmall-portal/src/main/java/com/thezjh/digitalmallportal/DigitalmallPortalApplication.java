package com.thezjh.digitalmallportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author thezjh
 */
@SpringBootApplication
@MapperScan("com.thezjh.digitalmallportal.dao")
public class DigitalmallPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalmallPortalApplication.class, args);
    }

}
