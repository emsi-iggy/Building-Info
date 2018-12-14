package pl.put.poznan.buildingInfo.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static pl.put.poznan.buildingInfo.logic.Okno.RodzajOknaPCV;
import static pl.put.poznan.buildingInfo.logic.Okno.SposobOtwarciaOkna;

public class BudynekTest {
    private Okno okno[];
    private ArrayList<Okno> listaOkien;
    private Pomieszczenie pomieszczenie[];
    private ArrayList<Pomieszczenie> listaPomieszczen;
    private Poziom poziom[];
    private ArrayList<Poziom> listaPoziomow;
    private Budynek budynek;

    @Before
    public void setUp() {
        okno = new Okno[6];
        pomieszczenie = new Pomieszczenie[10];
        poziom = new Poziom[10];

        okno[0] = new Okno(0.5, 1, 500, RodzajOknaPCV.TRADYCYJNE, SposobOtwarciaOkna.OBROTOWE);
        okno[1] = new Okno(0.5, 1, 500, RodzajOknaPCV.TRADYCYJNE, SposobOtwarciaOkna.UCHYLNOOBROTOWE);
        okno[2] = new Okno(1, 1.3, 700, RodzajOknaPCV.TRADYCYJNE, SposobOtwarciaOkna.OBROTOWE);
        okno[3] = new Okno(1, 1.3, 700, RodzajOknaPCV.TRADYCYJNE, SposobOtwarciaOkna.UCHYLNOOBROTOWE);
        okno[4] = new Okno(0.75, 1.3, 620, RodzajOknaPCV.TRADYCYJNE, SposobOtwarciaOkna.OBROTOWE);
        okno[5] = new Okno(0.75, 1.3, 620, RodzajOknaPCV.TRADYCYJNE, SposobOtwarciaOkna.UCHYLNOOBROTOWE);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[0]);
        listaOkien.add(okno[1]);
        pomieszczenie[0] = new Pomieszczenie(0, "Pokój 0", new Date(101, 1, 3), listaOkien, 10, 25, 10000, 80);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[2]);
        listaOkien.add(okno[3]);
        pomieszczenie[1] = new Pomieszczenie(1, "Pokój 1", new Date(105, 7, 31), listaOkien, 20, 50, 22000, 30);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[4]);
        listaOkien.add(okno[5]);
        pomieszczenie[2] = new Pomieszczenie(2, "Pokój 2", new Date(15, 7, 31), listaOkien, 10, 25, 10000, 5);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[0]);
        listaOkien.add(okno[1]);
        listaOkien.add(okno[4]);
        listaOkien.add(okno[5]);
        pomieszczenie[3] = new Pomieszczenie(3, "Pokój 3", new Date(109, 11, 10), listaOkien, 12, 30, 7000, 80);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[0]);
        listaOkien.add(okno[1]);
        listaOkien.add(okno[2]);
        listaOkien.add(okno[3]);
        pomieszczenie[4] = new Pomieszczenie(4, "Pokój 4", new Date(108, 9, 15), listaOkien, 10, 25, 8000, 40);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[2]);
        listaOkien.add(okno[3]);
        listaOkien.add(okno[4]);
        listaOkien.add(okno[5]);
        pomieszczenie[5] = new Pomieszczenie(5, "Pokój 5", new Date(110, 1, 21), listaOkien, 12, 30, 15000, 70);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[2]);
        pomieszczenie[6] = new Pomieszczenie(6, "Pokój 6", new Date(115, 8, 25), listaOkien, 6, 15, 15000, 135);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[3]);
        pomieszczenie[7] = new Pomieszczenie(7, "Pokój 7", new Date(101, 7, 30), listaOkien, 10, 25, 20000, 15);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno[5]);
        listaOkien.add(okno[5]);
        listaOkien.add(okno[5]);
        pomieszczenie[8] = new Pomieszczenie(8, "Pokój 8", new Date(112, 8, 3), listaOkien, 6, 15, 6000, 80);

        listaOkien = new ArrayList<>();
        pomieszczenie[9] = new Pomieszczenie(9, "Pokój 9", new Date(112, 5, 29), listaOkien, 20, 50, 5000, 75);


        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[0]);
        listaPomieszczen.add(pomieszczenie[1]);
        listaPomieszczen.add(pomieszczenie[4]);
        listaPomieszczen.add(pomieszczenie[6]);
        listaPomieszczen.add(pomieszczenie[8]);
        poziom[0] = new Poziom(0, "Poziom 0",  listaPomieszczen);


        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[0]);
        listaPomieszczen.add(pomieszczenie[2]);
        listaPomieszczen.add(pomieszczenie[8]);
        listaPomieszczen.add(pomieszczenie[9]);
        poziom[1] = new Poziom(1, "Poziom 1",  listaPomieszczen);


        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[0]);
        poziom[2] = new Poziom(2, "Poziom 2",  listaPomieszczen);


        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[5]);
        poziom[3] = new Poziom(3, "Poziom 3",  listaPomieszczen);


        listaPomieszczen = new ArrayList<>();
        poziom[4] = new Poziom(4, "Poziom 4",  listaPomieszczen);


        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[0]);
        listaPomieszczen.add(pomieszczenie[8]);
        poziom[5] = new Poziom(5, "Poziom 5",  listaPomieszczen);


        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[6]);
        poziom[6] = new Poziom(6, "Poziom 6",  listaPomieszczen);


        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[0]);
        listaPomieszczen.add(pomieszczenie[1]);
        listaPomieszczen.add(pomieszczenie[2]);
        listaPomieszczen.add(pomieszczenie[3]);
        listaPomieszczen.add(pomieszczenie[4]);
        listaPomieszczen.add(pomieszczenie[5]);
        listaPomieszczen.add(pomieszczenie[6]);
        listaPomieszczen.add(pomieszczenie[7]);
        listaPomieszczen.add(pomieszczenie[8]);
        listaPomieszczen.add(pomieszczenie[9]);
        poziom[7] = new Poziom(7, "Poziom 7",  listaPomieszczen);


        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[0]);
        listaPomieszczen.add(pomieszczenie[1]);
        listaPomieszczen.add(pomieszczenie[1]);
        poziom[8] = new Poziom(8, "Poziom 8",  listaPomieszczen);


        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[9]);
        poziom[9] = new Poziom(9, "Poziom 9",  listaPomieszczen);


    }

    @After
    public void tearDown() {
        listaOkien = null;
        okno = null;
        pomieszczenie = null;
        listaPomieszczen = null;
        poziom = null;
        listaPoziomow = null;
    }




    @Test
    public void testGetArea_brakPoziomow() {
        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Pusty budynek", listaPoziomow);

        assertEquals(0, budynek.getArea(), 0);
    }

    @Test
    public void testGetArea_jedenPoziom() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[0]);
        budynek = new Budynek(0, "Budynek z jednym poziomem", listaPoziomow);

        assertEquals(52, budynek.getArea(), 0);
    }

    @Test
    public void testGetArea_wielePoziomow() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[0]);
        listaPoziomow.add(poziom[1]);
        listaPoziomow.add(poziom[2]);
        budynek = new Budynek(0, "Budynek z wieloma poziomami", listaPoziomow);

        assertEquals(108, budynek.getArea(), 0);
    }

    @Test
    public void testGetCube_brakPoziomow() {
        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Pusty budynek", listaPoziomow);

        assertEquals(0, budynek.getCube(), 0);
    }

    @Test
    public void testGetCube_jedenPoziom() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[7]);
        budynek = new Budynek(0, "Budynek z jednym poziomem", listaPoziomow);

        assertEquals(290, budynek.getCube(), 0);
    }

    @Test
    public void testGetCube_wielePoziomow() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[2]);
        listaPoziomow.add(poziom[5]);
        listaPoziomow.add(poziom[8]);
        budynek = new Budynek(0, "Budynek z wieloma poziomami", listaPoziomow);

        assertEquals(190, budynek.getCube(), 0);
    }

    @Test
    public void testGetLight_brakPoziomow() {
        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Pusty budynek", listaPoziomow);

        assertEquals(0, budynek.getLight(), 0);
    }

    @Test
    public void testGetLight_jedenPoziom() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[1]);
        budynek = new Budynek(0, "Budynek z jednym poziomem", listaPoziomow);

        assertEquals(240.0, budynek.getLight(), 0);
    }

    @Test
    public void testGetLight_wielePoziomow() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[4]);
        listaPoziomow.add(poziom[7]);
        listaPoziomow.add(poziom[8]);
        budynek = new Budynek(0, "Budynek z wieloma poziomami", listaPoziomow);

        assertEquals(750, budynek.getLight(), 0);
    }

    @Test
    public void testGetHeating_brakPoziomow() {
        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Pusty budynek", listaPoziomow);

        assertEquals(0, budynek.getHeating(), 0);
    }

    @Test
    public void testGetHeating_jedenPoziom() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[2]);
        budynek = new Budynek(0, "Budynek z jednym poziomem", listaPoziomow);

        assertEquals(10000, budynek.getHeating(), 0);
    }

    @Test
    public void testGetHeating_wielePoziomow() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[0]);
        listaPoziomow.add(poziom[1]);
        listaPoziomow.add(poziom[9]);
        budynek = new Budynek(0, "Budynek z wieloma poziomami", listaPoziomow);

        assertEquals(97000, budynek.getHeating(), 0);
    }

    @Test
    public void testGetDataRemontu_brakPoziomow() {
        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Pusty budynek", listaPoziomow);

        assertEquals( null, budynek.getDataRemontu());
    }

    @Test
    public void testGetDataRemontu_jedenPoziom() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[3]);
        budynek = new Budynek(0, "Budynek z jednym poziomem", listaPoziomow);

        assertEquals(new Date(110, 1, 21), budynek.getDataRemontu());
    }

    @Test
    public void testGetDataRemontu_wielePoziomow() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[1]);
        listaPoziomow.add(poziom[5]);
        listaPoziomow.add(poziom[7]);
        budynek = new Budynek(0, "Budynek z wieloma poziomami", listaPoziomow);

        assertEquals(new Date(15, 7, 31), budynek.getDataRemontu());
    }

    @Test
    public void testGetPowierzchniaOkien_brakPoziomow() {
        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Pusty budynek", listaPoziomow);

        assertEquals(0, budynek.getPowierzchniaOkien(), 0);
    }

    @Test
    public void testGetPowierzchniaOkien_jedenPoziom_BrakOkien() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[9]);
        budynek = new Budynek(0, "Budynek z jednym poziomem bez okien", listaPoziomow);

        assertEquals(0, budynek.getPowierzchniaOkien(), 0);
    }

    @Test
    public void testGetPowierzchniaOkien_jedenPoziom_JednoOkno() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[6]);
        budynek = new Budynek(0, "Budyne z jednym poziomem z jednym okniem", listaPoziomow);

        assertEquals(1.3, budynek.getPowierzchniaOkien(), 0);
    }

    @Test
    public void testGetPowierzchniaOkien_jedenPoziom_WieleOkien() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[8]);
        budynek = new Budynek(1, "Budyne z jednym poziomem z wieloma oknami", listaPoziomow);

        assertEquals(6.2, budynek.getPowierzchniaOkien(), 0.1);
    }

    @Test
    public void testGetPowierzchniaOkien_wielePoziomow() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[4]);
        listaPoziomow.add(poziom[6]);
        listaPoziomow.add(poziom[9]);
        budynek = new Budynek(0, "Budynek z wieloma poziomami", listaPoziomow);

        assertEquals(1.3, budynek.getPowierzchniaOkien(), 0.001);
    }

    @Test
    public void testGetLiczbaOkien_brakPoziomow() {
        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Pusty budynek", listaPoziomow);

        assertEquals(0, budynek.getLiczbaOkien());
    }

    @Test
    public void testGetLiczbaOkien_jedenPoziom_BrakOkien() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[9]);
        budynek = new Budynek(0, "Budynek z jednym poziomem bez okien", listaPoziomow);

        assertEquals(0, budynek.getLiczbaOkien());
    }

    @Test
    public void testGetLiczbaOkien_jedenPoziom_JednoOkno() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[6]);
        budynek = new Budynek(0, "Budyne z jednym poziomem z jednym okniem", listaPoziomow);

        assertEquals(1, budynek.getLiczbaOkien());
    }

    @Test
    public void testGetLiczbaOkien_jedenPoziom_WieleOkien() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[7]);
        budynek = new Budynek(0, "Budyne z jednym poziomem z wieloma oknami", listaPoziomow);

        assertEquals(23, budynek.getLiczbaOkien());
    }

    @Test
    public void testGetLiczbaOkien_wielePoziomow() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[5]);
        listaPoziomow.add(poziom[7]);
        listaPoziomow.add(poziom[8]);
        budynek = new Budynek(0, "Budynek z wieloma poziomami", listaPoziomow);

        assertEquals(34, budynek.getLiczbaOkien());
    }

    @Test
    public void testGetLightPerSquareMeter_brakPoziomow() {
        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Pusty poziom", listaPoziomow);

        assertEquals(0, budynek.getLightPerSquareMeter(), 0);
    }

    @Test
    public void testGetLightPerSquareMeter_jedenPoziom() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[9]);
        budynek = new Budynek(0, "Poziom z jednym pomieszczeniem", listaPoziomow);

        assertEquals(3.75, budynek.getLightPerSquareMeter(), 0);
    }

    @Test
    public void testGetLightPerSquareMeter_wielePoziomow() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[0]);
        listaPoziomow.add(poziom[1]);
        listaPoziomow.add(poziom[3]);
        budynek = new Budynek(0, "Budynek z wieloma poziomami", listaPoziomow);

        assertEquals(6.136363636363637, budynek.getLightPerSquareMeter(), 0.01);
    }

    @Test
    public void testGetHeatingPerCubicMeter_brakPoziomow() {
        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Pusty poziom", listaPoziomow);

        assertEquals(0, budynek.getHeatingPerCubicMeter(), 0);
    }

    @Test
    public void testGetHeatingPerCubicMeter_jedenPoziom() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[9]);
        budynek = new Budynek(0, "Poziom z jednym pomieszczeniem", listaPoziomow);

        assertEquals(100, budynek.getHeatingPerCubicMeter(), 0);
    }

    @Test
    public void testGetHeatingPerCubicMeter_wielePoziomow() {
        listaPoziomow = new ArrayList<>();
        listaPoziomow.add(poziom[0]);
        listaPoziomow.add(poziom[1]);
        listaPoziomow.add(poziom[2]);
        budynek = new Budynek(0, "Budynek z wieloma poziomami", listaPoziomow);

        assertEquals(377.77777777777777, budynek.getHeatingPerCubicMeter(), 0);
    }
}