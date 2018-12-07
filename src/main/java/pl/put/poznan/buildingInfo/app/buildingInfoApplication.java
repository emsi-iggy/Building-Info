package pl.put.poznan.buildingInfo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.buildingInfo.logic.*;

import java.util.*;

import static pl.put.poznan.buildingInfo.logic.Okno.RodzajOknaPCV.*;
import static pl.put.poznan.buildingInfo.logic.Okno.SposobOtwarciaOkna.*;

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildingInfo.rest"})

public class buildingInfoApplication {
    public static List <Budynek> listaBudynkow;

    public static void main(String[] args) {
        listaBudynkow = new ArrayList<>();
        JSONCreator kreator = new JSONCreator();

        ArrayList <Pomieszczenie> listaPomieszczenParter = new ArrayList<>();
        Pomieszczenie kuchnia = new Pomieszczenie(0,"Kuchnia",14,43,420, 42);
        Pomieszczenie lazienka = new Pomieszczenie(1,"Łazienka",16,40,640,80);
        Pomieszczenie salon = new Pomieszczenie(2,"Salon",25,70,1325,75);
        Okno oknoKuchnia1 = new Okno(1.17, 1.14, 540, TRADYCYJNE, UCHYLNOROZWIERNE);
        Okno oknoKuchnia2 = new Okno(1.17, 1.14, 540, TRADYCYJNE, UCHYLNOROZWIERNE);
        Okno oknoLazienka1 = new Okno(1.0,0.5,350, TRADYCYJNE, UCHYLNOROZWIERNE);
        ArrayList <Okno> listaOkienWKuchni = new ArrayList<>();
        ArrayList <Okno> listaOkienWLazience = new ArrayList<>();
        ArrayList <Okno> listaOkienWSalonie = new ArrayList<>();

        listaOkienWKuchni.add(oknoKuchnia1);
        listaOkienWKuchni.add(oknoKuchnia2);
        listaOkienWLazience.add(oknoLazienka1);
        listaOkienWSalonie.add(oknoKuchnia1);
        listaOkienWSalonie.add(oknoKuchnia2);

        kuchnia.setListaOkien(listaOkienWKuchni);
        lazienka.setListaOkien(listaOkienWLazience);
        salon.setListaOkien(listaOkienWSalonie);

        listaPomieszczenParter.add(kuchnia);
        listaPomieszczenParter.add(lazienka);
        listaPomieszczenParter.add(salon);

        ArrayList <Pomieszczenie> listaPomieszczenPierwszePietro = new ArrayList<>();
        Pomieszczenie sypialnia = new Pomieszczenie(0,"Sypialnia",20,50,800,80);
        Pomieszczenie toaleta = new Pomieszczenie(1,"Toaleta",9,18,270,27);

        Okno oknoSypialnia1 = new Okno(2.3,1.4,780,BALKONOWE, PRZESUWNE);
        Okno oknoToaleta1 = new Okno(1.0,0.5,339.99,TRADYCYJNE,UCHYLNE);
        ArrayList <Okno>  listaOkienWSypialni = new ArrayList<>();
        ArrayList <Okno> listaOkienWToalecie = new ArrayList<>();
        listaOkienWSypialni.add(oknoSypialnia1);
        listaOkienWToalecie.add(oknoToaleta1);

        sypialnia.setListaOkien(listaOkienWSypialni);
        toaleta.setListaOkien(listaOkienWToalecie);

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
