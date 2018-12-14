package pl.put.poznan.buildingInfo.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static pl.put.poznan.buildingInfo.logic.Okno.RodzajOknaPCV;
import static pl.put.poznan.buildingInfo.logic.Okno.SposobOtwarciaOkna;

public class PoziomTest {
    private Okno okno[];
    private ArrayList<Okno> listaOkien;
    private Pomieszczenie pomieszczenie[];
    private ArrayList<Pomieszczenie> listaPomieszczen;
    private Poziom poziom;

    @Before
    public void setUp() {
        okno = new Okno[6];
        pomieszczenie = new Pomieszczenie[10];


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
    }

    @After
    public void tearDown() {
        listaOkien = null;
        okno = null;
        pomieszczenie = null;
        listaPomieszczen = null;
        poziom = null;
    }

    @Test
    public void testGetArea_brakPomieszczen() {
        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Pusty poziom", listaPomieszczen);

        assertEquals(0, poziom.getArea(), 0);
    }

    @Test
    public void testGetArea_jednoPomieszczenie() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[0]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem", listaPomieszczen);

        assertEquals(10, poziom.getArea(), 0);
    }

    @Test
    public void testGetArea_wielePomieszczen() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[0]);
        listaPomieszczen.add(pomieszczenie[1]);
        listaPomieszczen.add(pomieszczenie[2]);
        poziom = new Poziom(0, "Poziom z wieloma pomieszczeniami", listaPomieszczen);

        assertEquals(40, poziom.getArea(), 0);
    }

    @Test
    public void testGetCube_brakPomieszczen() {
        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Pusty poziom", listaPomieszczen);

        assertEquals(0, poziom.getCube(), 0);
    }

    @Test
    public void testGetCube_jednoPomieszczenie() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[0]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem", listaPomieszczen);

        assertEquals(25, poziom.getCube(), 0);
    }

    @Test
    public void testGetCube_wielePomieszczen() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[0]);
        listaPomieszczen.add(pomieszczenie[1]);
        listaPomieszczen.add(pomieszczenie[2]);
        poziom = new Poziom(0, "Poziom z wieloma pomieszczeniami", listaPomieszczen);

        assertEquals(100, poziom.getCube(), 0);
    }

    @Test
    public void testGetLight_brakPomieszczen() {
        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Pusty poziom", listaPomieszczen);

        assertEquals(0, poziom.getLight(), 0);
    }

    @Test
    public void testGetLight_jednoPomieszczenie() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[3]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem", listaPomieszczen);

        assertEquals(80, poziom.getLight(), 0);
    }

    @Test
    public void testGetLight_wielePomieszczen() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[3]);
        listaPomieszczen.add(pomieszczenie[4]);
        listaPomieszczen.add(pomieszczenie[5]);
        poziom = new Poziom(0, "Poziom z wieloma pomieszczeniami", listaPomieszczen);

        assertEquals(190, poziom.getLight(), 0);
    }

    @Test
    public void testGetHeating_brakPomieszczen() {
        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Pusty poziom", listaPomieszczen);

        assertEquals(0, poziom.getHeating(), 0);
    }

    @Test
    public void testGetHeating_jednoPomieszczenie() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[3]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem", listaPomieszczen);

        assertEquals(7000, poziom.getHeating(), 0);
    }

    @Test
    public void testGetHeating_wielePomieszczen() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[3]);
        listaPomieszczen.add(pomieszczenie[4]);
        listaPomieszczen.add(pomieszczenie[5]);
        poziom = new Poziom(0, "Poziom z wieloma pomieszczeniami", listaPomieszczen);

        assertEquals(30000, poziom.getHeating(), 0);
    }

    @Test
    public void testGetDataRemontu_brakPomieszczen() {
        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Pusty poziom", listaPomieszczen);

        assertEquals(null, poziom.getDataRemontu());
    }

    @Test
    public void testGetDataRemontu_jednoPomieszczenie() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[6]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem", listaPomieszczen);

        assertEquals(new Date(115, 8, 25), poziom.getDataRemontu());
    }

    @Test
    public void testGetDataRemontu_wielePomieszczen() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[6]);
        listaPomieszczen.add(pomieszczenie[7]);
        listaPomieszczen.add(pomieszczenie[8]);
        poziom = new Poziom(0, "Poziom z wieloma pomieszczeniami", listaPomieszczen);

        assertEquals(new Date(101, 7, 30), poziom.getDataRemontu());
    }

    @Test
    public void testGetPowierzchniaOkien_brakPomieszczen() {
        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Pusty poziom", listaPomieszczen);

        assertEquals(0, poziom.getPowierzchniaOkien(), 0);
    }

    @Test
    public void testGetPowierzchniaOkien_jednoPomieszczenie_BrakOkien() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[9]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem bez okien", listaPomieszczen);

        assertEquals(0, poziom.getPowierzchniaOkien(), 0);
    }

    @Test
    public void testGetPowierzchniaOkien_jednoPomieszczenie_JednoOkno() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[6]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem z jednym okniem", listaPomieszczen);

        assertEquals(1.3, poziom.getPowierzchniaOkien(), 0);
    }

    @Test
    public void testGetPowierzchniaOkien_jednoPomieszczenie_WieleOkien() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[4]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem z wieloma oknami", listaPomieszczen);

        assertEquals(3.6, poziom.getPowierzchniaOkien(), 0.1);
    }

    @Test
    public void testGetPowierzchniaOkien_wielePomieszczen() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[7]);
        listaPomieszczen.add(pomieszczenie[8]);
        listaPomieszczen.add(pomieszczenie[9]);
        poziom = new Poziom(0, "Poziom z wieloma pomieszczeniami", listaPomieszczen);

        assertEquals(4.225, poziom.getPowierzchniaOkien(), 0.001);
    }

    @Test
    public void testGetLiczbaOkien_brakPomieszczen() {
        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Pusty poziom", listaPomieszczen);

        assertEquals(0, poziom.getLiczbaOkien());
    }

    @Test
    public void testGetLiczbaOkien_jednoPomieszczenie_BrakOkien() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[9]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem bez okien", listaPomieszczen);

        assertEquals(0, poziom.getLiczbaOkien());
    }

    @Test
    public void testGetLiczbaOkien_jednoPomieszczenie_JednoOkno() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[6]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem z jednym okniem", listaPomieszczen);

        assertEquals(1, poziom.getLiczbaOkien());
    }

    @Test
    public void testGetLiczbaOkien_jednoPomieszczenie_WieleOkien() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[4]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem z wieloma oknami", listaPomieszczen);

        assertEquals(4, poziom.getLiczbaOkien());
    }

    @Test
    public void testGetLiczbaOkien_wielePomieszczen() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[7]);
        listaPomieszczen.add(pomieszczenie[8]);
        listaPomieszczen.add(pomieszczenie[9]);
        poziom = new Poziom(0, "Poziom z wieloma pomieszczeniami", listaPomieszczen);

        assertEquals(4, poziom.getLiczbaOkien());
    }

    @Test
    public void testGetLightPerSquareMeter_brakPomieszczen() {
        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Pusty poziom", listaPomieszczen);

        assertEquals(0, poziom.getLightPerSquareMeter(), 0);
    }

    @Test
    public void testGetLightPerSquareMeter_jednoPomieszczenie() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[4]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem", listaPomieszczen);

        assertEquals(4, poziom.getLightPerSquareMeter(), 0);
    }

    @Test
    public void testGetLightPerSquareMeter_wielePomieszczen() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[4]);
        listaPomieszczen.add(pomieszczenie[7]);
        listaPomieszczen.add(pomieszczenie[9]);
        poziom = new Poziom(0, "Poziom z wieloma pomieszczeniami", listaPomieszczen);

        assertEquals(3.25, poziom.getLightPerSquareMeter(), 0.01);
    }

    @Test
    public void testGetHeatingPerCubicMeter_brakPomieszczen() {
        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Pusty poziom", listaPomieszczen);

        assertEquals(0, poziom.getHeatingPerCubicMeter(), 0);
    }

    @Test
    public void testGetHeatingPerCubicMeter_jednoPomieszczenie() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[1]);
        poziom = new Poziom(0, "Poziom z jednym pomieszczeniem", listaPomieszczen);

        assertEquals(440, poziom.getHeatingPerCubicMeter(), 0);
    }

    @Test
    public void testGetHeatingPerCubicMeter_wielePomieszczen() {
        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pomieszczenie[1]);
        listaPomieszczen.add(pomieszczenie[2]);
        listaPomieszczen.add(pomieszczenie[4]);
        poziom = new Poziom(0, "Poziom z wieloma pomieszczeniami", listaPomieszczen);

        assertEquals(400, poziom.getHeatingPerCubicMeter(), 0);
    }
}
