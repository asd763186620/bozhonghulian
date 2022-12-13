package org.example.bzhl.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Classname UserApplication
 * @Date 2022/12/12 16:36
 * @Author 花非
 * @Version 1.0
 * @Description
 */
@EnableSwagger2
@MapperScan("org.example.bzhl.user.mapper")
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
