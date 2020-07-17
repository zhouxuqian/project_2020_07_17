package cn.kgc.comment.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CommentServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentServerApplication.class, args);
    }

}
