package pl.put.poznan.buildingInfo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.buildingInfo.logic.*;

import java.util.*;

import static pl.put.poznan.buildingInfo.logic.Okno.RodzajOknaPCV.*;
import static pl.put.poznan.buildingInfo.logic.Okno.SposobOtwarciaOkna.*;

/**
 * Class buildingInfoApplication is used to run our buildingInfo service.
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildingInfo.rest"})
public class buildingInfoApplication {
    /**
     * The list of buildings with all collected data about them.
     * That list is used to find any information required by the user.
     */
    public static List <Budynek> listaBudynkow;

    private static Budynek stworzBudynek1() {
        Okno okno[] = new Okno[5];
        ArrayList <Okno> listaOkien;
        ArrayList <Pomieszczenie> listaPomieszczen;
        ArrayList <Poziom> listaPoziomow;
        Budynek budynek;


        okno[0] = new Okno(1.17, 1.14, 540, TRADYCYJNE, UCHYLNOROZWIERNE);
        okno[1] = new Okno(1.17, 1.14, 540, TRADYCYJNE, UCHYLNOROZWIERNE);
        okno[2] = new Okno(1.0,0.5,350, TRADYCYJNE, UCHYLNOROZWIERNE);
        okno[3] = new Okno(2.3,1.4,780,BALKONOWE, PRZESUWNE);
        okno[4] = new Okno(1.0,0.5,339.99,TRADYCYJNE,UCHYLNE);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[0]);
        listaOkien.add(okno[1]);
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(new Pomieszczenie(0,"Kuchnia", new Date(105, 10, 20), listaOkien, 14,43,420, 42));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[2]);
        listaPomieszczen.add(new Pomieszczenie(1,"Łazienka", new Date(110, 7, 24), listaOkien,16,40,640,80));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[0]);
        listaOkien.add(okno[1]);
        listaPomieszczen.add(new Pomieszczenie(2,"Salon", new Date(102, 5, 29), listaOkien,25,70,1325,75));

        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(new Poziom(0, "Parter", listaPomieszczen));


        listaOkien = new ArrayList<>();
        listaOkien.add(okno[3]);
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(new Pomieszczenie(0,"Sypialnia", new Date(109, 9, 13), listaOkien,20,50,800,80));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[4]);
        listaPomieszczen.add(new Pomieszczenie(1,"Toaleta", new Date(102, 5, 29), listaOkien,9,18,270,27));

        listaPoziomow.add(new Poziom(1, "Pierwsze piętro", listaPomieszczen));

        budynek = new Budynek(0, "Moj dom", listaPoziomow);

        return budynek;
    }

    private static Budynek stworzBudynek2() {
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
        listaPomieszczen.add(new Pomieszczenie(0, "Kuchnia", new Date(113, 3, 20), listaOkien, 22.14, 55.35, 2996, 68));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[1]);
        listaOkien.add(okno[1]);
        listaOkien.add(okno[8]);
        listaPomieszczen.add(new Pomieszczenie(1, "Salon", new Date(104, 6, 6), listaOkien, 18.9, 47.25, 1634, 180));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[1]);
        listaOkien.add(okno[8]);
        listaPomieszczen.add(new Pomieszczenie(2, "Sypialnia", new Date(104, 6, 6), listaOkien, 13.5, 33.75, 1089, 90));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[5]);
        listaPomieszczen.add(new Pomieszczenie(3, "Łazienka", new Date(113, 3, 20), listaOkien, 3.38, 8.45, 2179, 20));

        listaOkien = new ArrayList<>();
        listaPomieszczen.add(new Pomieszczenie(4, "Korytarz", new Date(113, 3, 20), listaOkien, 4.81, 12.025, 817, 60));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[8]);
        listaPomieszczen.add(new Pomieszczenie(5, "Garderoba", new Date(106, 8, 17), listaOkien, 5.85, 14.625, 272, 60));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[2]);
        listaOkien.add(okno[9]);
        listaPomieszczen.add(new Pomieszczenie(6, "Altana", new Date(113, 3, 20), listaOkien, 8.5, 21.25, 1907, 75));

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
        listaPomieszczen.add(new Pomieszczenie(0, "Pokój", new Date(110, 9, 23), listaOkien, 8.5, 21.25, 1362, 120));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[1]);
        listaOkien.add(okno[1]);
        listaOkien.add(okno[8]);
        listaOkien.add(okno[1]);
        listaOkien.add(okno[1]);
        listaOkien.add(okno[8]);
        listaPomieszczen.add(new Pomieszczenie(1, "Salon", new Date(110, 9, 23), listaOkien, 18.9, 47.25, 1416, 26));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[1]);
        listaOkien.add(okno[1]);
        listaOkien.add(okno[8]);
        listaPomieszczen.add(new Pomieszczenie(2, "Sypialnia", new Date(110, 9, 23), listaOkien, 19.35, 48.375, 1307, 135));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[0]);
        listaOkien.add(okno[7]);
        listaPomieszczen.add(new Pomieszczenie(3, "Pokój", new Date(110, 9, 23), listaOkien, 10, 25, 762, 7));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[0]);
        listaOkien.add(okno[7]);
        listaPomieszczen.add(new Pomieszczenie(4, "Pokój", new Date(106, 8, 17), listaOkien, 7.28, 18.2, 544, 10));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[8]);
        listaPomieszczen.add(new Pomieszczenie(5, "Łazienka", new Date(105, 8, 10), listaOkien, 3.24, 8.1, 272, 70));

        listaOkien = new ArrayList<>();
        listaPomieszczen.add(new Pomieszczenie(6, "Korytarz", new Date(105, 8, 10), listaOkien, 8.58, 21.45, 544, 180));

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[11]);
        listaPomieszczen.add(new Pomieszczenie(7, "Klatka schodowa", new Date(105, 8, 10), listaOkien, 2.7, 8.1, 0, 20));

        listaPoziomow.add(new Poziom(1, "1. Pietro", listaPomieszczen));

        budynek = new Budynek(1, "Moj dom.", listaPoziomow);

        return budynek;
    }

    /**
     * The main method, which is responsible for application working.
     * There is prepared necessary information about buildings used while running application.
     * After that, the SpringApplication is started.
     *
     * @param args is the typical array of arguments. Actually, it is only passed to the method run() of the class SpringApplication.
     */
    public static void main(String[] args) {
        listaBudynkow = new ArrayList<>();
        JSONCreator kreator = new JSONCreator();

        listaBudynkow.add(stworzBudynek1());
        listaBudynkow.add(stworzBudynek2());

        SpringApplication.run(buildingInfoApplication.class, args);
        System.out.println("<SUKCES> Rozpoczynam działanie aplikacji.");
    }
}
