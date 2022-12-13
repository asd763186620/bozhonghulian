package org.example.bzhl.drug;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Classname DrugApplication
 * @Date 2022/12/12 16:28
 * @Author 花非
 * @Version 1.0
 * @Description
 */
@EnableSwagger2
@MapperScan("org.example.bzhl.drug.mapper")
@SpringBootApplication
public class DrugApplication {
    public static void main(String[] args) {
        SpringApplication.run(DrugApplication.class, args);
    }
}
