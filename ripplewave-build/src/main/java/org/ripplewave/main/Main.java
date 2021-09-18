package org.ripplewave.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.ripplewave.common.constants.CommonConstants.BASE_PACKAGE;

@SpringBootApplication
@EnableJpaRepositories(basePackages = BASE_PACKAGE)
@EntityScan(basePackages = BASE_PACKAGE)
@ComponentScan(basePackages = BASE_PACKAGE)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
