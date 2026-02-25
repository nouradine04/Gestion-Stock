package com.nouradine.springgestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
//@EnableJpaAuditing
public class SpringGestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGestionApplication.class, args);
    }

}
