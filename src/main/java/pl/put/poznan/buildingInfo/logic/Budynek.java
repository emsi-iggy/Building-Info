package pl.put.poznan.buildingInfo.logic;


import java.util.*;

public class Budynek extends Lokalizacja{

    private ArrayList <Poziom> listaPoziomow ;


    public Budynek() {
        super();
        this.listaPoziomow = new ArrayList<>();

    }

    public Budynek(int id, String nazwa, ArrayList <Poziom> listaPoziomow) {
        super(id, nazwa);
        this.listaPoziomow = listaPoziomow;

    }

    @Override
    public String toString() {
        return "Budynek{" +
                "id=" + getId() +
                ", nazwa='" + getNazwa() + '\'' +
                "listaPoziomow=" + listaPoziomow +
                '}';
    }

    public ArrayList<Poziom> getListaPoziomow() {
        return listaPoziomow;
    }

    public void setListaPoziomow(ArrayList <Poziom> listaPoziomow) {
        this.listaPoziomow = listaPoziomow;
    }

    public double getArea() {
        double area = 0;

        for(Poziom poziom : listaPoziomow) {
            area += poziom.getArea();
        }

        return area;
    }

    public double getCube() {
        double cube = 0;

        for(Poziom poziom : listaPoziomow) {
            cube += poziom.getCube();
        }

        return cube;
    }

}
