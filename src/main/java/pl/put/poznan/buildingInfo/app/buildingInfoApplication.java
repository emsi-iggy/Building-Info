package pl.put.poznan.buildingInfo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.buildingInfo.logic.Pomieszczenie;
import java.util.*;

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildingInfo.rest"})

public class buildingInfoApplication {
    public static List <Pomieszczenie> listaPomieszczen;
    public static void main(String[] args) {
        listaPomieszczen = new ArrayList <>();

        //Dodajmy sobie jakies ze dwa pomieszczenia
        Pomieszczenie a = new Pomieszczenie(listaPomieszczen.size(),"pokoj",9.0,27.0,100.0,100.0);
        listaPomieszczen.add(a);
        Pomieszczenie b = new Pomieszczenie(listaPomieszczen.size(),"kuchnia",16.0,64.0,130.0,140.0);
        listaPomieszczen.add(b);

        SpringApplication.run(buildingInfoApplication.class, args);
        System.out.println("<SUKCES> Rozpoczynam działanie aplikacji.");
    }
}
