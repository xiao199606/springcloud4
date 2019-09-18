package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //表明自己是一个eurekaclient.
@MapperScan("com.jk.dao")
public class SpringcloudProviderzhfApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderzhfApplication.class, args);
    }

}
