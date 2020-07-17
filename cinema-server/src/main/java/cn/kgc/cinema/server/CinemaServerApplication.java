package cn.kgc.cinema.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CinemaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaServerApplication.class, args);
    }

}
