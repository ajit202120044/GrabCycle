package com.grabcycles.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.grabcycles.library.*", "com.grabcycles.admin.*"})
@EnableJpaRepositories(value = "com.grabcycles.library.repository")
@EntityScan(value = "com.grabcycles.library.model")
//@EnableSwagger2
public class AdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdminApplication.class, args);


    }

}
