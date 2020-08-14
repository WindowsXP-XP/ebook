package com.xp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
@MapperScan("com.xp.mapper")
public class EbooknetApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbooknetApplication.class, args);
    }

}
