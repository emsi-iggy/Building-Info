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

    public static Budynek stworzBudynek2() {
        Okno okno[] = new Okno[14];
        ArrayList <Okno> listaOkien;
        ArrayList <Pomieszczenie> listaPomieszczen;
        ArrayList <Poziom> listaPoziomow;
        Budynek budynek;


        okno[0] = new Okno(0.75, 1.25, 549.99, TRADYCYJNE, OBROTOWE);
        okno[1] = new Okno(0.75, 1.3, 599.99, TRADYCYJNE, OBROTOWE);
        okno[2] = new Okno(0.85, 1.25, 619.99, TRADYCYJNE, OBROTOWE);
        okno[3] = new Okno(0.75, 2, 699.99, BALKONOWE, OBROTOWE);
        okno[4] = new Okno(0.9, 2, 799.99, TRADYCYJNE, OBROTOWE);
        okno[5] = new Okno(0.4, 1.3, 349.99, TRADYCYJNE, OBROTOWE);
        okno[6] = new Okno(0.65, 1.3, 399.99, TRADYCYJNE, OBROTOWE);
        okno[7] = new Okno(0.75, 1.25, 549.99, TRADYCYJNE, UCHYLNOOBROTOWE);
        okno[8] = new Okno(0.75, 1.3, 599.99, TRADYCYJNE, UCHYLNOOBROTOWE);
        okno[9] = new Okno(0.85, 1.25, 619.99, TRADYCYJNE, UCHYLNOOBROTOWE);
        okno[10] = new Okno(0.75, 2, 699.99, BALKONOWE, UCHYLNOOBROTOWE);
        okno[11] = new Okno(0.9, 2, 799.99, TRADYCYJNE, UCHYLNOOBROTOWE);
        okno[12] = new Okno(0.4, 1.3, 349.99, TRADYCYJNE, UCHYLNOOBROTOWE);
        okno[13] = new Okno(0.65, 1.3, 449.99, TRADYCYJNE, UCHYLNOOBROTOWE);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[1]);
        listaOkien.add(okno[8]);
        listaOkien.add(okno[6]);
        listaOkien.add(okno[13]);
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(new Pomieszczenie(0, "Kuchnia", new Date(113, 3, 20), listaOkien, 22.14, 55.35, 29968, 68));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[1]);
        listaOkien.add(okno[1]);
        listaOkien.add(okno[8]);
        listaPomieszczen.add(new Pomieszczenie(1, "Salon", new Date(104, 6, 6), listaOkien, 18.9, 47.25, 16346, 180));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[1]);
        listaOkien.add(okno[8]);
        listaPomieszczen.add(new Pomieszczenie(2, "Sypialnia", new Date(104, 6, 6), listaOkien, 13.5, 33.75, 10897, 90));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[5]);
        listaPomieszczen.add(new Pomieszczenie(3, "Łazienka", new Date(113, 3, 20), listaOkien, 3.38, 8.45, 21794, 20));

        listaOkien = new ArrayList<>();
        listaPomieszczen.add(new Pomieszczenie(4, "Korytarz", new Date(113, 3, 20), listaOkien, 4.81, 12.025, 8173, 60));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[8]);
        listaPomieszczen.add(new Pomieszczenie(5, "Garderoba", new Date(106, 8, 17), listaOkien, 5.85, 14.625, 2724, 60));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[2]);
        listaOkien.add(okno[9]);
        listaPomieszczen.add(new Pomieszczenie(6, "Altana", new Date(113, 3, 20), listaOkien, 8.5, 21.25, 19070, 75));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[11]);
        listaPomieszczen.add(new Pomieszczenie(7, "Klatka schodowa", new Date(105, 8, 10), listaOkien, 2.7, 9.45, 0, 20));

        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(new Poziom(0, "Parter", listaPomieszczen));


        listaOkien = new ArrayList<>();
        listaOkien.add(okno[2]);
        listaOkien.add(okno[9]);
        listaOkien.add(okno[10]);
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(new Pomieszczenie(0, "Pokój", new Date(110, 9, 23), listaOkien, 8.5, 21.25, 13621, 120));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[1]);
        listaOkien.add(okno[1]);
        listaOkien.add(okno[8]);
        listaOkien.add(okno[1]);
        listaOkien.add(okno[1]);
        listaOkien.add(okno[8]);
        listaPomieszczen.add(new Pomieszczenie(1, "Salon", new Date(110, 9, 23), listaOkien, 18.9, 47.25, 14166, 26));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[1]);
        listaOkien.add(okno[1]);
        listaOkien.add(okno[8]);
        listaPomieszczen.add(new Pomieszczenie(2, "Sypialnia", new Date(110, 9, 23), listaOkien, 19.35, 48.375, 13076, 135));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[0]);
        listaOkien.add(okno[7]);
        listaPomieszczen.add(new Pomieszczenie(3, "Pokój", new Date(110, 9, 23), listaOkien, 10, 25, 7628, 7));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[0]);
        listaOkien.add(okno[7]);
        listaPomieszczen.add(new Pomieszczenie(4, "Pokój", new Date(106, 8, 17), listaOkien, 7.28, 18.2, 5448, 10));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[8]);
        listaPomieszczen.add(new Pomieszczenie(5, "Łazienka", new Date(105, 8, 10), listaOkien, 3.24, 8.1, 2724, 70));

        listaOkien = new ArrayList<>();
        listaPomieszczen.add(new Pomieszczenie(6, "Korytarz", new Date(105, 8, 10), listaOkien, 8.58, 21.45, 5448, 180));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[11]);
        listaPomieszczen.add(new Pomieszczenie(7, "Klatka schodowa", new Date(105, 8, 10), listaOkien, 2.7, 8.1, 0, 20));

        listaPoziomow.add(new Poziom(1, "1. Pietro", listaPomieszczen));

        budynek = new Budynek(1, "Moj dom.", listaPoziomow);

        return budynek;
    }

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
        listaBudynkow.add(stworzBudynek2());

        SpringApplication.run(buildingInfoApplication.class, args);
        System.out.println("<SUKCES> Rozpoczynam działanie aplikacji.");
    }
}
