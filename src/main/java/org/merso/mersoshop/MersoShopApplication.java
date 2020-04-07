package org.merso.mersoshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("org.merso.mersoshop.mapper")
@SpringBootApplication
public class MersoShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MersoShopApplication.class, args);
    }

}
