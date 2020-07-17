package cn.kgc.movie.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MovieServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerApplication.class, args);
    }

}
