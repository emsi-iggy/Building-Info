package pl.put.poznan.buildingInfo.logic;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This is the test class for class Budynek, which mainly tests the boundary conditions of the class.
 */

public class BudynekTest {
    private ArrayList<Poziom> listaPoziomow;
    private Budynek budynek;

    /**
     * Clean up after the test execution.
     */
    @After
    public void tearDown() {
        listaPoziomow = null;
        budynek = null;
    }

    /**
     * Check if the value returned by the method getArea in class Budynek
     * is correct when the various list of the class Poziom is set.
     */
    @Test
    public void testGetArea() {
        Poziom mockPoziom[] = new Poziom[2];
        for(int i = 0; i < 2; i++) {
            mockPoziom[i] = mock(Poziom.class);
            when(mockPoziom[i].getArea()).thenReturn(60.0 + (i + 1) * 20);
        }

        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Budynek testujący metode getArea()", listaPoziomow);
        assertEquals(0, budynek.getArea(), 0);   //test bez poziomow

        listaPoziomow.add(mockPoziom[0]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(80, budynek.getArea(), 0);  //test z jednym poziomem
        verify(mockPoziom[0]).getArea();

        listaPoziomow.add(mockPoziom[1]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(180, budynek.getArea(), 0);  //test z wieloma poziomami
        verify(mockPoziom[0], times(2)).getArea();
        verify(mockPoziom[1]).getArea();
    }

    /**
     * Check if the value returned by the method getCube in class Budynek
     * is correct when the various list of the class Poziom is set.
     */
    @Test
    public void testGetCube() {
        Poziom mockPoziom[] = new Poziom[2];
        for(int i = 0; i < 2; i++) {
            mockPoziom[i] = mock(Poziom.class);
            when(mockPoziom[i].getCube()).thenReturn(180.0 + (i + 1) * 20);
        }

        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Budynek testujący metode getCube()", listaPoziomow);
        assertEquals(0, budynek.getCube(), 0);   //test bez poziomow

        listaPoziomow.add(mockPoziom[0]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(200, budynek.getCube(), 0);  //test z jednym poziomem
        verify(mockPoziom[0]).getCube();

        listaPoziomow.add(mockPoziom[1]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(420, budynek.getCube(), 0);  //test z wieloma poziomami
        verify(mockPoziom[0], times(2)).getCube();
        verify(mockPoziom[1]).getCube();
    }

    /**
     * Check if the value returned by the method getLight in class Budynek
     * is correct when the various list of the class Poziom is set.
     */
    @Test
    public void testGetLight() {
        Poziom mockPoziom[] = new Poziom[2];
        for(int i = 0; i < 2; i++) {
            mockPoziom[i] = mock(Poziom.class);
            when(mockPoziom[i].getLight()).thenReturn(180.0 + (i + 1) * 20);
        }

        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Budynek testujący metode getLight()", listaPoziomow);
        assertEquals(0, budynek.getLight(), 0);   //test bez poziomow

        listaPoziomow.add(mockPoziom[0]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(200, budynek.getLight(), 0);  //test z jednym poziomem
        verify(mockPoziom[0]).getLight();

        listaPoziomow.add(mockPoziom[1]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(420, budynek.getLight(), 0);  //test z wieloma poziomami
        verify(mockPoziom[0], times(2)).getLight();
        verify(mockPoziom[1]).getLight();
    }

    /**
     * Check if the value returned by the method getHeating in class Budynek
     * is correct when the various list of the class Poziom is set.
     */
    @Test
    public void testGetHeating() {
        Poziom mockPoziom[] = new Poziom[2];
        for(int i = 0; i < 2; i++) {
            mockPoziom[i] = mock(Poziom.class);
            when(mockPoziom[i].getHeating()).thenReturn(1800.0 + (100 * (i + 1)));
        }

        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Budynek testujący metode getHeating()", listaPoziomow);
        assertEquals(0, budynek.getHeating(), 0);   //test bez poziomow

        listaPoziomow.add(mockPoziom[0]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(1900, budynek.getHeating(), 0);  //test z jednym poziomem
        verify(mockPoziom[0]).getHeating();

        listaPoziomow.add(mockPoziom[1]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(3900, budynek.getHeating(), 0);  //test z wieloma poziomami
        verify(mockPoziom[0], times(2)).getHeating();
        verify(mockPoziom[1]).getHeating();
    }

    /**
     * Check if the value returned by the method getDataRemontu in class Budynek
     * is correct when the various list of the class Poziom is set.
     */
    @Test
    public void testGetDataRemontu() {
        Poziom mockPoziom[] = new Poziom[3];
        for(int i = 0; i < 3; i++) {
            mockPoziom[i] = mock(Poziom.class);
        }
        when(mockPoziom[0].getDataRemontu()).thenReturn(new Date(115, 8, 25));
        when(mockPoziom[1].getDataRemontu()).thenReturn(new Date(101, 7, 30));
        when(mockPoziom[2].getDataRemontu()).thenReturn(new Date(112, 8, 3));

        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Budynek testujący metode getDataRemontu", listaPoziomow);
        assertNull(budynek.getDataRemontu());    //test bez poziomow

        listaPoziomow.add(mockPoziom[0]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(new Date(115, 8, 25), budynek.getDataRemontu());  //test z jednym poziomem
        verify(mockPoziom[0], atLeastOnce()).getDataRemontu();

        listaPoziomow.add(mockPoziom[1]);
        listaPoziomow.add(mockPoziom[2]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(new Date(101, 7, 30), budynek.getDataRemontu());  //test z wieloma pomieszczeniami
        verify(mockPoziom[0], atLeastOnce()).getDataRemontu();
        verify(mockPoziom[1], atLeastOnce()).getDataRemontu();
        verify(mockPoziom[2], atLeastOnce()).getDataRemontu();
    }

    /**
     * Check if the value returned by the method getPowierzchniaOkien in class Budynek
     * is correct when the various list of the class Poziom is set.
     */
    @Test
    public void testGetPowierzchniaOkien() {
        Poziom mockPoziom[] = new Poziom[2];
        for(int i = 0; i < 2; i++) {
            mockPoziom[i] = mock(Poziom.class);
            when(mockPoziom[i].getPowierzchniaOkien()).thenReturn(120.0 + (20 * (i + 1)));
        }

        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Budynek testujący metode getPowierzchniaOkien()", listaPoziomow);
        assertEquals(0, budynek.getPowierzchniaOkien(), 0);   //test bez poziomow

        listaPoziomow.add(mockPoziom[0]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(140, budynek.getPowierzchniaOkien(), 0);  //test z jednym poziomem
        verify(mockPoziom[0]).getPowierzchniaOkien();

        listaPoziomow.add(mockPoziom[1]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(300, budynek.getPowierzchniaOkien(), 0);  //test z wieloma poziomami
        verify(mockPoziom[0], times(2)).getPowierzchniaOkien();
        verify(mockPoziom[1]).getPowierzchniaOkien();
    }

    /**
     * Check if the value returned by the method getLiczbaOkien in class Budynek
     * is correct when the various list of the class Poziom is set.
     */
    @Test
    public void testGetLiczbaOkien() {
        Poziom mockPoziom[] = new Poziom[2];
        for(int i = 0; i < 2; i++) {
            mockPoziom[i] = mock(Poziom.class);
            when(mockPoziom[i].getLiczbaOkien()).thenReturn(4 + (4 * (i + 1)));
        }

        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Budynek testujący metode getLiczbaOkien()", listaPoziomow);
        assertEquals(0, budynek.getLiczbaOkien(), 0);   //test bez poziomow

        listaPoziomow.add(mockPoziom[0]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(8, budynek.getLiczbaOkien(), 0);  //test z jednym poziomem
        verify(mockPoziom[0]).getLiczbaOkien();

        listaPoziomow.add(mockPoziom[1]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(20, budynek.getLiczbaOkien(), 0);  //test z wieloma poziomami
        verify(mockPoziom[0], times(2)).getLiczbaOkien();
        verify(mockPoziom[1]).getLiczbaOkien();
    }

    /**
     * Check if the value returned by the method getLightPerSquareMeter in class Budynek
     * is correct when the various list of the class Poziom is set.
     */
    @Test
    public void testGetLightPerSquareMeter() {
        Poziom mockPoziom[] = new Poziom[2];
        for(int i = 0; i < 2; i++) {
            mockPoziom[i] = mock(Poziom.class);
            when(mockPoziom[i].getArea()).thenReturn(10.0 * (i + 1));
            when(mockPoziom[i].getLight()).thenReturn(60.0 + 10 * i * i);
        }

        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Budynek testujący metode getLightPerSquareMeter()", listaPoziomow);
        assertEquals(0, budynek.getLightPerSquareMeter(), 0);   //test bez poziomow

        listaPoziomow.add(mockPoziom[0]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(6, budynek.getLightPerSquareMeter(), 0);  //test z jednym pomieszczeniem
        verify(mockPoziom[0], atLeastOnce()).getArea();
        verify(mockPoziom[0], atLeastOnce()).getLight();

        listaPoziomow.add(mockPoziom[1]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(4.333, budynek.getLightPerSquareMeter(), 0.1);  //test z wieloma poziomami
        for(int i = 0; i < 2; i++) {
            verify(mockPoziom[i], atLeastOnce()).getArea();
            verify(mockPoziom[i], atLeastOnce()).getLight();
        }
    }

    /**
     * Check if the value returned by the method getHeatingPerCubicMeter in class Budynek
     * is correct when the various list of the class Poziom is set.
     */
    @Test
    public void testGetHeatingPerCubicMeter() {
        Poziom mockPoziom[] = new Poziom[2];
        for(int i = 0; i < 2; i++) {
            mockPoziom[i] = mock(Poziom.class);
            when(mockPoziom[i].getCube()).thenReturn(15.0 + 5 * i);
            when(mockPoziom[i].getHeating()).thenReturn(1500.0 + 500 * i);
        }

        listaPoziomow = new ArrayList<>();
        budynek = new Budynek(0, "Budynek testujący metode getHeatingPerCubicMeter()", listaPoziomow);
        assertEquals(0, budynek.getHeatingPerCubicMeter(), 0);   //test bez poziomow

        listaPoziomow.add(mockPoziom[0]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(100, budynek.getHeatingPerCubicMeter(), 0);  //test z jednym pomieszczeniem
        verify(mockPoziom[0], atLeastOnce()).getCube();
        verify(mockPoziom[0], atLeastOnce()).getHeating();

        listaPoziomow.add(mockPoziom[1]);
        budynek.setListaPoziomow(listaPoziomow);
        assertEquals(100, budynek.getHeatingPerCubicMeter(), 0);  //test z wieloma poziomami
        for(int i = 0; i < 2; i++) {
            verify(mockPoziom[i], atLeastOnce()).getCube();
            verify(mockPoziom[i], atLeastOnce()).getHeating();
        }
    }
}
