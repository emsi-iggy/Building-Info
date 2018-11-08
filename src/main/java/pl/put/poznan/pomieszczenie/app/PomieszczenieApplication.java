package pl.put.poznan.pomieszczenie.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.pomieszczenie.rest"})

public class PomieszczenieApplication {
    public static void main(String[] args) {
        SpringApplication.run(PomieszczenieApplication.class, args);
    }
}