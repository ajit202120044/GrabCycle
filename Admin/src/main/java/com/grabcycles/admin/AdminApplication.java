package com.grabcycles.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.grabcycles.library.*", "com.grabcycles.admin.*"})
@EnableJpaRepositories(value = "com.grabcycles.library.repository")
@EntityScan(value = "com.grabcycles.library.model")
public class AdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdminApplication.class, args);


    }

}
