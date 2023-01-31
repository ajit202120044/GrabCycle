package com.grabcycles.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.grabcycles.customer", "com.grabcycles.library"})
@EnableJpaRepositories(value = "com.grabcycles.library.repository")
@EntityScan(value = "com.grabcycles.library.model")
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);


    }

}
