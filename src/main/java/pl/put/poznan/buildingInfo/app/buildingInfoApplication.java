package pl.put.poznan.buildingInfo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.buildingInfo.logic.Budynek;
import pl.put.poznan.buildingInfo.logic.Pomieszczenie;
import pl.put.poznan.buildingInfo.logic.Poziom;

import java.util.*;

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildingInfo.rest"})

public class buildingInfoApplication {
    public static List <Budynek> listaBudynkow;

    public static void main(String[] args) {
        listaBudynkow = new ArrayList<>();

        ArrayList <Pomieszczenie> listaPomieszczenParter = new ArrayList<>();
        Pomieszczenie kuchnia = new Pomieszczenie(0,"Kuchnia",14,43,30, 3);
        Pomieszczenie lazienka = new Pomieszczenie(1,"Łazienka",16,40,40,5);
        Pomieszczenie salon = new Pomieszczenie(2,"Salon",25,70,53,3);

        listaPomieszczenParter.add(kuchnia);
        listaPomieszczenParter.add(lazienka);
        listaPomieszczenParter.add(salon);

        ArrayList <Pomieszczenie> listaPomieszczenPierwszePietro = new ArrayList<>();
        Pomieszczenie sypialnia = new Pomieszczenie(0,"Sypialnia",20,50,40,4);
        Pomieszczenie toaleta = new Pomieszczenie(1,"Toaleta",9,18,30,3);

        listaPomieszczenPierwszePietro.add(sypialnia);
        listaPomieszczenPierwszePietro.add(toaleta);

        ArrayList <Poziom> listaPoziomowDomu = new ArrayList<>();
        Poziom parter = new Poziom(0,"Parter",listaPomieszczenParter);
        Poziom pierwszePietro = new Poziom(1,"Pierwsze piętro", listaPomieszczenPierwszePietro);
        listaPoziomowDomu.add(parter);
        listaPoziomowDomu.add(pierwszePietro);

        Budynek dom = new Budynek(0,"Mój dom",listaPoziomowDomu);

        listaBudynkow.add(dom);

        SpringApplication.run(buildingInfoApplication.class, args);
        System.out.println("<SUKCES> Rozpoczynam działanie aplikacji.");
    }
}
