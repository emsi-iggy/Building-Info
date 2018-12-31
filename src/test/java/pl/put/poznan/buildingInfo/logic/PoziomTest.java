package pl.put.poznan.buildingInfo.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.*;

/**
 * This is the test class for class Poziom, which mainly tests the boundary conditions of the class.
 */
public class PoziomTest {
    private ArrayList<Pomieszczenie> listaPomieszczen;
    private Poziom poziom;

    /**
     * Clean up after the test execution.
     */
    @After
    public void tearDown() {
        listaPomieszczen = null;
        poziom = null;
    }

    /**
     * Check if the value returned by the method getArea in class Poziom
     * is correct when the various list of the class Pomieszczenie is set.
     */
    @Test
    public void testGetArea() {
        Pomieszczenie mockPomieszczenie[] = new Pomieszczenie[3];
        for(int i = 0; i < 3; i++) {
            mockPomieszczenie[i] = mock(Pomieszczenie.class);
            when(mockPomieszczenie[i].getArea()).thenReturn(10.0 * (i + 1));
        }

        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Poziom testujący metode getArea()", listaPomieszczen);
        assertEquals(0, poziom.getArea(), 0);   //test bez pomieszczen

        listaPomieszczen.add(mockPomieszczenie[0]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(10, poziom.getArea(), 0);  //test z jednym pomieszczeniem
        verify(mockPomieszczenie[0]).getArea();

        listaPomieszczen.add(mockPomieszczenie[1]);
        listaPomieszczen.add(mockPomieszczenie[2]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(60, poziom.getArea(), 0);  //test z wieloma pomieszczeniami
        verify(mockPomieszczenie[0], times(2)).getArea();
        verify(mockPomieszczenie[1]).getArea();
        verify(mockPomieszczenie[2]).getArea();
    }

    /**
     * Check if the value returned by the method getCube in class Poziom
     * is correct when the various list of the class Pomieszczenie is set.
     */
    @Test
    public void testGetCube() {
        Pomieszczenie mockPomieszczenie[] = new Pomieszczenie[3];
        for(int i = 0; i < 3; i++) {
            mockPomieszczenie[i] = mock(Pomieszczenie.class);
            when(mockPomieszczenie[i].getCube()).thenReturn(15.0 + 5 * i);
        }

        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Poziom testujący metode getCube", listaPomieszczen);
        assertEquals(0, poziom.getCube(), 0);   //test bez pomieszczen

        listaPomieszczen.add(mockPomieszczenie[0]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(15, poziom.getCube(), 0);  //test z jednym pomieszczeniem
        verify(mockPomieszczenie[0]).getCube();

        listaPomieszczen.add(mockPomieszczenie[1]);
        listaPomieszczen.add(mockPomieszczenie[2]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(60, poziom.getCube(), 0);  //test z wieloma pomieszczeniami
        verify(mockPomieszczenie[0], times(2)).getCube();
        verify(mockPomieszczenie[1]).getCube();
        verify(mockPomieszczenie[2]).getCube();
    }

    /**
     * Check if the value returned by the method getLight in class Poziom
     * is correct when the various list of the class Pomieszczenie is set.
     */
    @Test
    public void testGetLight() {
        Pomieszczenie mockPomieszczenie[] = new Pomieszczenie[3];
        for(int i = 0; i < 3; i++) {
            mockPomieszczenie[i] = mock(Pomieszczenie.class);
            when(mockPomieszczenie[i].getLight()).thenReturn(60.0 + 10 * i * i);
        }

        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Poziom testujący metode getLight", listaPomieszczen);
        assertEquals(0, poziom.getLight(), 0);   //test bez pomieszczen

        listaPomieszczen.add(mockPomieszczenie[0]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(60, poziom.getLight(), 0);  //test z jednym pomieszczeniem
        verify(mockPomieszczenie[0]).getLight();

        listaPomieszczen.add(mockPomieszczenie[1]);
        listaPomieszczen.add(mockPomieszczenie[2]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(230, poziom.getLight(), 0);  //test z wieloma pomieszczeniami
        verify(mockPomieszczenie[0], times(2)).getLight();
        verify(mockPomieszczenie[1]).getLight();
        verify(mockPomieszczenie[2]).getLight();
    }

    /**
     * Check if the value returned by the method getHeating in class Poziom
     * is correct when the various list of the class Pomieszczenie is set.
     */
    @Test
    public void testGetHeating() {
        Pomieszczenie mockPomieszczenie[] = new Pomieszczenie[3];
        for(int i = 0; i < 3; i++) {
            mockPomieszczenie[i] = mock(Pomieszczenie.class);
            when(mockPomieszczenie[i].getHeating()).thenReturn(1500.0 + 500 * i);
        }

        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Poziom testujący metode getHeating", listaPomieszczen);
        assertEquals(0, poziom.getHeating(), 0);   //test bez pomieszczen

        listaPomieszczen.add(mockPomieszczenie[0]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(1500, poziom.getHeating(), 0);  //test z jednym pomieszczeniem
        verify(mockPomieszczenie[0]).getHeating();

        listaPomieszczen.add(mockPomieszczenie[1]);
        listaPomieszczen.add(mockPomieszczenie[2]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(6000, poziom.getHeating(), 0);  //test z wieloma pomieszczeniami
        verify(mockPomieszczenie[0], times(2)).getHeating();
        verify(mockPomieszczenie[1]).getHeating();
        verify(mockPomieszczenie[2]).getHeating();
    }

    /**
     * Check if the value returned by the method getDataRemontu in class Poziom
     * is correct when the various list of the class Pomieszczenie is set.
     */
    @Test
    public void testGetDataRemontu() {
        Pomieszczenie mockPomieszczenie[] = new Pomieszczenie[3];
        for(int i = 0; i < 3; i++) {
            mockPomieszczenie[i] = mock(Pomieszczenie.class);
        }
        when(mockPomieszczenie[0].getDataRemontu()).thenReturn(new Date(115, 8, 25));
        when(mockPomieszczenie[1].getDataRemontu()).thenReturn(new Date(101, 7, 30));
        when(mockPomieszczenie[2].getDataRemontu()).thenReturn(new Date(112, 8, 3));

        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Poziom testujący metode getDataRemontu", listaPomieszczen);
        assertNull(poziom.getDataRemontu());    //test bez pomieszczen

        listaPomieszczen.add(mockPomieszczenie[0]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(new Date(115, 8, 25), poziom.getDataRemontu());  //test z jednym pomieszczeniem
        verify(mockPomieszczenie[0], atLeastOnce()).getDataRemontu();

        listaPomieszczen.add(mockPomieszczenie[1]);
        listaPomieszczen.add(mockPomieszczenie[2]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(new Date(101, 7, 30), poziom.getDataRemontu());  //test z wieloma pomieszczeniami
        verify(mockPomieszczenie[0], atLeastOnce()).getDataRemontu();
        verify(mockPomieszczenie[1], atLeastOnce()).getDataRemontu();
        verify(mockPomieszczenie[2], atLeastOnce()).getDataRemontu();
    }

    /**
     * Check if the value returned by the method getPowierzchniaOkien in class Poziom
     * is correct when the various list of the class Pomieszczenie is set.
     */
    @Test
    public void testGetPowierzchniaOkien() {
        Pomieszczenie mockPomieszczenie[] = new Pomieszczenie[3];
        for(int i = 0; i < 3; i++) {
            mockPomieszczenie[i] = mock(Pomieszczenie.class);
            when(mockPomieszczenie[i].getPowierzchniaOkien()).thenReturn(1.3 * i);
        }

        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Poziom testujący metode getPowierzchniaOkien", listaPomieszczen);
        assertEquals(0, poziom.getPowierzchniaOkien(), 0);    //test bez pomieszczen

        listaPomieszczen.add(mockPomieszczenie[0]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(0, poziom.getPowierzchniaOkien(), 0);  //test z jednym pomieszczeniem
        verify(mockPomieszczenie[0]).getPowierzchniaOkien();

        listaPomieszczen.add(mockPomieszczenie[1]);
        listaPomieszczen.add(mockPomieszczenie[2]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(3.9, poziom.getPowierzchniaOkien(), 0.1);  //test z wieloma pomieszczeniami
        verify(mockPomieszczenie[0], times(2)).getPowierzchniaOkien();
        verify(mockPomieszczenie[1]).getPowierzchniaOkien();
        verify(mockPomieszczenie[2]).getPowierzchniaOkien();
    }

    /**
     * Check if the value returned by the method getLiczbaOkien in class Poziom
     * is correct when the various list of the class Pomieszczenie is set.
     */
    @Test
    public void testGetLiczbaOkien() {
        Pomieszczenie mockPomieszczenie[] = new Pomieszczenie[3];
        for(int i = 0; i < 3; i++) {
            mockPomieszczenie[i] = mock(Pomieszczenie.class);
            when(mockPomieszczenie[i].getLiczbaOkien()).thenReturn(1 + i * i);
        }

        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Poziom testujący metode getLiczbaOkien", listaPomieszczen);
        assertEquals(0, poziom.getLiczbaOkien());    //test bez pomieszczen

        listaPomieszczen.add(mockPomieszczenie[0]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(1, poziom.getLiczbaOkien());  //test z jednym pomieszczeniem
        verify(mockPomieszczenie[0]).getLiczbaOkien();

        listaPomieszczen.add(mockPomieszczenie[1]);
        listaPomieszczen.add(mockPomieszczenie[2]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(8, poziom.getLiczbaOkien());  //test z wieloma pomieszczeniami
        verify(mockPomieszczenie[0], times(2)).getLiczbaOkien();
        verify(mockPomieszczenie[1]).getLiczbaOkien();
        verify(mockPomieszczenie[2]).getLiczbaOkien();
    }

    /**
     * Check if the value returned by the method getLightPerSquareMeter in class Poziom
     * is correct when the various list of the class Pomieszczenie is set.
     */
    @Test
    public void testGetLightPerSquareMeter() {
        Pomieszczenie mockPomieszczenie[] = new Pomieszczenie[3];
        for(int i = 0; i < 3; i++) {
            mockPomieszczenie[i] = mock(Pomieszczenie.class);
            when(mockPomieszczenie[i].getArea()).thenReturn(10.0 * (i + 1));
            when(mockPomieszczenie[i].getLight()).thenReturn(60.0 + 10 * i * i);
        }

        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Poziom testujący metode getLightPerSquareMeter", listaPomieszczen);
        assertEquals(0, poziom.getLightPerSquareMeter(), 0);   //test bez pomieszczen

        listaPomieszczen.add(mockPomieszczenie[0]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(6, poziom.getLightPerSquareMeter(), 0);  //test z jednym pomieszczeniem
        verify(mockPomieszczenie[0], atLeastOnce()).getArea();
        verify(mockPomieszczenie[0], atLeastOnce()).getLight();

        listaPomieszczen.add(mockPomieszczenie[1]);
        listaPomieszczen.add(mockPomieszczenie[2]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(3.83, poziom.getLightPerSquareMeter(), 0.01);  //test z wieloma pomieszczeniami
        for(int i = 0; i < 3; i++) {
            verify(mockPomieszczenie[i], atLeastOnce()).getArea();
            verify(mockPomieszczenie[i], atLeastOnce()).getLight();
        }
    }

    /**
     * Check if the value returned by the method getHeatingPerCubicMeter in class Poziom
     * is correct when the various list of the class Pomieszczenie is set.
     */
    @Test
    public void testGetHeatingPerCubicMeter() {
        Pomieszczenie mockPomieszczenie[] = new Pomieszczenie[3];
        for(int i = 0; i < 3; i++) {
            mockPomieszczenie[i] = mock(Pomieszczenie.class);
            when(mockPomieszczenie[i].getCube()).thenReturn(15.0 + 5 * i);
            when(mockPomieszczenie[i].getHeating()).thenReturn(1500.0 + 500 * i);
        }

        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Poziom testujący metode getHeatingPerCubicMeter", listaPomieszczen);
        assertEquals(0, poziom.getHeatingPerCubicMeter(), 0);   //test bez pomieszczen

        listaPomieszczen.add(mockPomieszczenie[0]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(100, poziom.getHeatingPerCubicMeter(), 0);  //test z jednym pomieszczeniem
        verify(mockPomieszczenie[0], atLeastOnce()).getCube();
        verify(mockPomieszczenie[0], atLeastOnce()).getHeating();

        listaPomieszczen.add(mockPomieszczenie[1]);
        listaPomieszczen.add(mockPomieszczenie[2]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(100, poziom.getHeatingPerCubicMeter(), 0);  //test z wieloma pomieszczeniami
        for(int i = 0; i < 3; i++) {
            verify(mockPomieszczenie[i], atLeastOnce()).getCube();
            verify(mockPomieszczenie[i], atLeastOnce()).getHeating();
        }
    }

    /**
     * Check if the value returned by the method getNaturalLight in class Poziom
     * is correct when the various list of the class Pomieszczenie is set.
     */
    @Test
    public void testGetNaturalLight() {
        Pomieszczenie mockPomieszczenie[] = new Pomieszczenie[3];
        for(int i = 0; i < 3; i++) {
            mockPomieszczenie[i] = mock(Pomieszczenie.class);
            when(mockPomieszczenie[i].getCube()).thenReturn(15.0 + 5 * i);
            when(mockPomieszczenie[i].getPowierzchniaOkien()).thenReturn(1.3 * i);
        }

        listaPomieszczen = new ArrayList<>();
        poziom = new Poziom(0, "Poziom testujący metode getNaturalLight", listaPomieszczen);
        assertEquals(0, poziom.getNaturalLight(), 0);   //test bez pomieszczen

        listaPomieszczen.add(mockPomieszczenie[0]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(0, poziom.getNaturalLight(), 0);  //test z jednym pomieszczeniem
        verify(mockPomieszczenie[0], atLeastOnce()).getCube();
        verify(mockPomieszczenie[0], atLeastOnce()).getPowierzchniaOkien();

        listaPomieszczen.add(mockPomieszczenie[1]);
        listaPomieszczen.add(mockPomieszczenie[2]);
        poziom.setListaPomieszczen(listaPomieszczen);
        assertEquals(0.065, poziom.getNaturalLight(), 0);  //test z wieloma pomieszczeniami
        for(int i = 0; i < 3; i++) {
            verify(mockPomieszczenie[i], atLeastOnce()).getCube();
            verify(mockPomieszczenie[i], atLeastOnce()).getPowierzchniaOkien();
        }
    }
}
