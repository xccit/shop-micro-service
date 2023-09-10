package io.xccit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "io.xccit.mapper")
@SpringBootApplication
public class CarouselServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarouselServiceApplication.class, args);
    }

}
