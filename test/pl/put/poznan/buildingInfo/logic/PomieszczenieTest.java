package pl.put.poznan.buildingInfo.logic;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static pl.put.poznan.buildingInfo.logic.Okno.RodzajOknaPCV.TRADYCYJNE;
import static pl.put.poznan.buildingInfo.logic.Okno.SposobOtwarciaOkna.UCHYLNOROZWIERNE;

public class PomieszczenieTest {
    Pomieszczenie pomieszczenie;
    ArrayList <Okno> listaOkien;

    @Before
    public void setUp() {
        pomieszczenie = new Pomieszczenie();
        listaOkien = new ArrayList<>();
    }

    @After
    public void tearDown() {
        pomieszczenie = null;
        listaOkien = null;
    }

    @Test
    public void testGetPowierzchniaOkien_brakOkien() {
        pomieszczenie.setListaOkien(listaOkien);
        assertEquals(0,pomieszczenie.getPowierzchniaOkien(),0);
    }

    @Test
    public void testGetPowierzchniaOkienLiczbyCalkowite() {
        listaOkien.add(new Okno(3, 5, 940, TRADYCYJNE, UCHYLNOROZWIERNE));
        pomieszczenie.setListaOkien(listaOkien);
        assertEquals(3*5,pomieszczenie.getPowierzchniaOkien(),0);
    }

    @Test
    public void testGetPowierzchniaOkienLiczbyRzeczywiste() {
        listaOkien.add(new Okno(1.2,0.7,430,TRADYCYJNE,UCHYLNOROZWIERNE));
        pomieszczenie.setListaOkien(listaOkien);
        assertEquals(1.2*0.7,pomieszczenie.getPowierzchniaOkien(),0.01);
    }

    @Test
    public void testGetLightPerSquareMeter() {
        assertEquals(0, pomieszczenie.getLightPerSquareMeter(), 0);
    }

    @Test
    public void testGetLightPerSquareMeter_bezArea() {
        pomieszczenie.setLight(42);
        assertEquals(0, pomieszczenie.getLightPerSquareMeter(), 0);
    }

    @Test
    public void testGetLightPerSquareMeter_bezLight() {
        pomieszczenie.setArea(22);
        assertEquals(0, pomieszczenie.getLightPerSquareMeter(), 0);
    }

    @Test
    public void testGetLightPerSquareMeter_LightIArea() {
        pomieszczenie.setLight(84);
        pomieszczenie.setArea(22);

        assertEquals(3.81, pomieszczenie.getLightPerSquareMeter(), 0.01);
    }

    @Test
    public void testGetHeatingPerCubicMeter() {
        assertEquals(0, pomieszczenie.getHeatingPerCubicMeter(), 0);
    }

    @Test
    public void testGetHeatingPerCubicMeter_bezHeating() {
        pomieszczenie.setHeating(3456);
        assertEquals(0, pomieszczenie.getHeatingPerCubicMeter(), 0);
    }

    @Test
    public void testGetHeatingPerCubicMeter_bezCube() {
        pomieszczenie.setCube(66);
        assertEquals(0, pomieszczenie.getHeatingPerCubicMeter(), 0);
    }

    @Test
    public void testGetHeatingPerCubicMeter_HeatingICube() {
        pomieszczenie.setHeating(4158);
        pomieszczenie.setCube(66);
        assertEquals(63, pomieszczenie.getHeatingPerCubicMeter(), 0);
    }
}
