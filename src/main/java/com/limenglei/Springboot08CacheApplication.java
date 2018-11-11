package com.limenglei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.limenglei.mapper")
@SpringBootApplication
@EnableCaching   //开启注解缓存
public class Springboot08CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot08CacheApplication.class, args);
    }
}
