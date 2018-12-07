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
    Okno okno1, okno2, okno3, okno4, okno5;
    ArrayList<Okno> listaOkien;
    Pomieszczenie pokoj1, pokoj2, sypialnia, lazienka;
    ArrayList<Pomieszczenie> listaPomieszczen;
    Poziom poziom;

    @Before
    public void setUp() {
        okno1 = new Okno(0.8, 1.2, 549.99, RodzajOknaPCV.TRADYCYJNE, SposobOtwarciaOkna.UCHYLNE);
        okno2 = new Okno(0.8, 1.2, 549.99, RodzajOknaPCV.TRADYCYJNE, SposobOtwarciaOkna.UCHYLNOOBROTOWE);
        okno3 = new Okno(0.7, 1.2, 499.99, RodzajOknaPCV.TRADYCYJNE, SposobOtwarciaOkna.UCHYLNE);
        okno4 = new Okno(0.7, 1.2, 499.99, RodzajOknaPCV.TRADYCYJNE, SposobOtwarciaOkna.UCHYLNOOBROTOWE);
        okno5 = new Okno(0.6, 1, 449.99, RodzajOknaPCV.TRADYCYJNE, SposobOtwarciaOkna.UCHYLNE);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno1);
        listaOkien.add(okno2);
        pokoj1 = new Pomieszczenie(1, "pokoj1", new Date(2012, 10, 23), listaOkien, 15, 37.5, 50, 77);

        pokoj2 = new Pomieszczenie(2, "pokoj2", new Date(2008, 5, 13), listaOkien, 12, 30, 40, 15);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno3);
        listaOkien.add(okno4);
        sypialnia = new Pomieszczenie(3, "sypialnia", new Date(2010, 7, 25), listaOkien, 24, 60, 75, 120);

        listaOkien = new ArrayList<>();
        listaOkien.add(okno5);
        lazienka = new Pomieszczenie(4, "lazienka", new Date(2005, 4, 8), listaOkien, 4, 10, 50, 55);

        listaPomieszczen = new ArrayList<>();
        listaPomieszczen.add(pokoj1);
        listaPomieszczen.add(pokoj2);
        listaPomieszczen.add(sypialnia);
        listaPomieszczen.add(lazienka);
        poziom = new Poziom(1, "1. Piętro", listaPomieszczen);
    }

    @After
    public void tearDown() {
        okno1 = null;
        okno2 = null;
        okno3 = null;
        okno4 = null;
        okno5 = null;
        listaOkien = null;

        pokoj1 = null;
        pokoj2 = null;
        sypialnia = null;
        lazienka = null;

        listaPomieszczen = null;
        poziom = null;
    }

    @Test
    public void testGetArea() {
        assertEquals(55, poziom.getArea(), 0);
    }

    @Test
    public void testGetCube() {
        assertEquals(137.5, poziom.getCube(), 0);
    }

    @Test
    public void testGetLight() {
        assertEquals(267, poziom.getLight(), 0);
    }

    @Test
    public void testGetHeating() {
        assertEquals(215, poziom.getHeating(), 0);
    }

    @Test
    public void testGetDataRemontu() {
        assertEquals(new Date(2005, 4, 8), poziom.getDataRemontu());
    }

    @Test
    public void testGetPowierzchniaOkien() {
        assertEquals(6.12, poziom.getPowierzchniaOkien(), 0.001);
    }

    @Test
    public void testGetLiczbaOkien() {
        assertEquals(7, poziom.getLiczbaOkien());
    }

    @Test
    public void testGetLightPerSquareMeter() {
        assertEquals(4.85, poziom.getLightPerSquareMeter(), 0.01);
    }

    @Test
    public void testGetHeatingPerCubicMeter() {
        assertEquals(1.56, poziom.getHeatingPerCubicMeter(), 0.01);
    }
}
