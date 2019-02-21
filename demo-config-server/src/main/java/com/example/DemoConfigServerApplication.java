package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class DemoConfigServerApplication {

    /**
     * http请求地址和资源文件映射如下:
     *
     *      /{application}/{profile}[/{label}]
     *      /{application}-{profile}.yml
     *      /{label}/{application}-{profile}.yml
     *      /{application}-{profile}.properties
     *      /{label}/{application}-{profile}.properties
     *
     * **/

    public static void main(String[] args) {
        SpringApplication.run(DemoConfigServerApplication.class, args);
    }

}
