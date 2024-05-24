package ua.lysenko.quartzservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class QuartzServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuartzServiceApplication.class, args);
    }
}
