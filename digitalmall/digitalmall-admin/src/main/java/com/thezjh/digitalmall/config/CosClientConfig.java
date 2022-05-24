package com.thezjh.digitalmall.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.thezjh.digitalmall.config.CosConfig.*;

/**
 * @author thezjh
 * @create 2022/5/21 下午9:14
 */
@Configuration
public class CosClientConfig {

    @Bean
    public COSClient cosClient() {
        //1、初始化用户id和key
        COSCredentials credentials = new BasicCOSCredentials(SECRET_ID, SECRET_KEY);
        //2、设置区域
        Region region = new Region(REGION);
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(credentials, clientConfig);

        return cosClient;
    }
}
