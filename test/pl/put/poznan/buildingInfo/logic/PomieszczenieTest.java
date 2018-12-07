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

    //Trzeba jeszcze wypelnic
    @Test
    public void testGetPowierzchniaOkienLiczbyCalkowite() {
        listaOkien.add(new Okno(3, 5, 940, TRADYCYJNE, UCHYLNOROZWIERNE));
        assertEquals(3*5,pomieszczenie.getPowierzchniaOkien(),0.001);
    }

    @Test
    public void testGetPowierzchniaOkienLiczbyRzeczywiste() {
        listaOkien.add(new Okno(1.2,0.7,430,TRADYCYJNE,UCHYLNOROZWIERNE));
        assertEquals(3*5+1.2*0.7,pomieszczenie.getPowierzchniaOkien(),0.001);
    }

    @Test
    public void getPowierzchniaOkien() {
    }
}
