package pl.put.poznan.buildingInfo.logic;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static pl.put.poznan.buildingInfo.logic.Okno.RodzajOknaPCV.TRADYCYJNE;
import static pl.put.poznan.buildingInfo.logic.Okno.SposobOtwarciaOkna.UCHYLNOROZWIERNE;

/**
 * This is the test class for class Pomieszczenie, which mainly tests
 * the boundary conditions of the class.
 */
public class PomieszczenieTest {
    Pomieszczenie pomieszczenie;
    ArrayList <Okno> listaOkien;

    /**
     * Set values before the test execution.
     */
    @Before
    public void setUp() {
        pomieszczenie = new Pomieszczenie();
        listaOkien = new ArrayList<>();
    }

    /**
     * Clean up after the test execution.
     */
    @After
    public void tearDown() {
        pomieszczenie = null;
        listaOkien = null;
    }

    /**
     * Check if the value returned by the method getPowierzchniaOkien in class Pomieszczenie
     * is correct when the empty list of the class Okno is set.
     */
    @Test
    public void testGetPowierzchniaOkien_brakOkien() {
        pomieszczenie.setListaOkien(listaOkien);
        assertEquals(0,pomieszczenie.getPowierzchniaOkien(),0);
    }

    /**
     * Check if the value returned by the method getPowierzchniaOkien in class Pomieszczenie
     * is correct when the list of the class Okno is set and values of width and height are
     * integer numbers.
     */
    @Test
    public void testGetPowierzchniaOkienLiczbyCalkowite() {
        Okno mockOkna[] = new Okno[1];
        for(int i = 0; i < 1; i++) {
            mockOkna[i] = mock(Okno.class);
            when(mockOkna[i].getPowierzchnia()).thenReturn(10.0 * (i+1));
        }
        listaOkien.add(mockOkna[0]);
        pomieszczenie.setListaOkien(listaOkien);
        assertEquals(10, pomieszczenie.getPowierzchniaOkien(), 0);  //test z jednym pomieszczeniem
        verify(mockOkna[0]).getPowierzchnia(); // sprawdz czy funkcja zostala wywolana
    }

    /**
     * Check if the value returned by the method getPowierzchniaOkien in class Pomieszczenie
     * is correct when the list of the class Okno is set and values of width and height are
     * real numbers.
     */
    @Test
    public void testGetPowierzchniaOkienLiczbyRzeczywiste() {
        Okno mockOkna[] = new Okno[3];
        for(int i = 0; i < 3; i++) {
            mockOkna[i] = mock(Okno.class);
            when(mockOkna[i].getPowierzchnia()).thenReturn(10.1 * (i+1));
        }
        listaOkien.add(mockOkna[0]);
        listaOkien.add(mockOkna[1]);
        listaOkien.add(mockOkna[2]);
        pomieszczenie.setListaOkien(listaOkien);
        assertEquals(60.6, pomieszczenie.getPowierzchniaOkien(), 0.1);  //test z jednym pomieszczeniem
        verify(mockOkna[0]).getPowierzchnia(); // sprawdz czy funkcja zostala wywolana dla okna1
        verify(mockOkna[1]).getPowierzchnia(); // sprawdz czy funkcja zostala wywolana dla okna2
        verify(mockOkna[2]).getPowierzchnia(); // sprawdz czy funkcja zostala wywolana dla okna3
    }

    /**
     * Check if the value returned by the method getLightPerSquareMeter in class Pomieszczenie
     * is correct when there are no parameters set.
     */
    @Test
    public void testGetLightPerSquareMeter() {
        assertEquals(0, pomieszczenie.getLightPerSquareMeter(), 0);
    }

    /**
     * Check if the value returned by the method getLightPerSquareMeter in class Pomieszczenie
     * is correct when there is only one parameter set (here is the numerator).
     */
    @Test
    public void testGetLightPerSquareMeter_bezArea() {
        pomieszczenie.setLight(42);
        assertEquals(0, pomieszczenie.getLightPerSquareMeter(), 0);
    }

    /**
     * Check if the value returned by the method getLightPerSquareMeter in class Pomieszczenie
     * is correct when there is only one parameter set (here is the denominator).
     */
    @Test
    public void testGetLightPerSquareMeter_bezLight() {
        pomieszczenie.setArea(22);
        assertEquals(0, pomieszczenie.getLightPerSquareMeter(), 0);
    }

    /**
     * Check if the value returned by the method getLightPerSquareMeter in class Pomieszczenie
     * is correct when there are both parameters set.
     */
    @Test
    public void testGetLightPerSquareMeter_LightIArea() {
        pomieszczenie.setLight(84);
        pomieszczenie.setArea(22);

        assertEquals(3.81, pomieszczenie.getLightPerSquareMeter(), 0.01);
    }

    /**
     * Check if the value returned by the method getHeatingPerCubicMeter in class Pomieszczenie
     * is correct when there are no parameters set.
     */
    @Test
    public void testGetHeatingPerCubicMeter() {
        assertEquals(0, pomieszczenie.getHeatingPerCubicMeter(), 0);
    }

    /**
     * Check if the value returned by the method getHeatingPerCubicMeter in class Pomieszczenie
     * is correct when there is only one parameter set (here is the numerator).
     */
    @Test
    public void testGetHeatingPerCubicMeter_bezHeating() {
        pomieszczenie.setHeating(3456);
        assertEquals(0, pomieszczenie.getHeatingPerCubicMeter(), 0);
    }

    /**
     * Check if the value returned by the method getHeatingPerCubicMeter in class Pomieszczenie
     * is correct when there is only one parameter set (here is the denominator).
     */
    @Test
    public void testGetHeatingPerCubicMeter_bezCube() {
        pomieszczenie.setCube(66);
        assertEquals(0, pomieszczenie.getHeatingPerCubicMeter(), 0);
    }

    /**
     * Check if the value returned by the method getHeatingPerCubicMeter in class Pomieszczenie
     * is correct when there are both parameters set.
     */
    @Test
    public void testGetHeatingPerCubicMeter_HeatingICube() {
        pomieszczenie.setHeating(4158);
        pomieszczenie.setCube(66);
        assertEquals(63, pomieszczenie.getHeatingPerCubicMeter(), 0);
    }
}
