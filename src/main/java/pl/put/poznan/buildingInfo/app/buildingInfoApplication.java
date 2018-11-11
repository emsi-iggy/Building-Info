package pl.put.poznan.buildingInfo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.buildingInfo.logic.Budynek;
import java.util.*;

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildingInfo.rest"})

public class buildingInfoApplication {
    public static List <Budynek> listaBudynkow;

    public static void main(String[] args) {
        //listaBudynkow = new ArrayList<>();

        SpringApplication.run(buildingInfoApplication.class, args);
        System.out.println("<SUKCES> Rozpoczynam działanie aplikacji.");
    }
}
