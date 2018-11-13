package pl.put.poznan.buildingInfo.logic;


import java.util.*;

/**
 * Class Budynek represents class Lokalizacja with additional attributes such as ArrayList type Poziom - listaPoziomow
 */
public class Budynek extends Lokalizacja{

    private ArrayList <Poziom> listaPoziomow ;


    public Budynek() {
        super();
        this.listaPoziomow = new ArrayList<>();

    }

    /**
     *
     * @param id variable inherited from the class Lokalizacja
     *           here is passed to the Costructor method of the class Budynek
     * @param nazwa variable inherited from the class Lokalizacja
     *              here is passed to the Constructor method of the class Budynek
     * @param listaPoziomow is a list containing elements type Poziom,
     *                      here is passed to the Constructor method of the class Budynek
     */
    public Budynek(int id, String nazwa, ArrayList <Poziom> listaPoziomow) {
        super(id, nazwa);
        this.listaPoziomow = listaPoziomow;

    }

    /**
     *
     * @return the String containing names of variables and their values
     */
    @Override
    public String toString() {
        return "Budynek{" +
                "id=" + getId() +
                ", nazwa='" + getNazwa() + '\'' +
                "listaPoziomow=" + listaPoziomow +
                '}';
    }

    /**
     *
     * @return ArrayList listaPoziomow
     */
    public ArrayList<Poziom> getListaPoziomow() {
        return listaPoziomow;
    }

    /**
     *
     * @param listaPoziomow the same as described above, but here is passed to the setListaPoziomow method
     *                      so we can change to the other list of the same type
     */
    public void setListaPoziomow(ArrayList <Poziom> listaPoziomow) {
        this.listaPoziomow = listaPoziomow;
    }

    /**
     *
     * @return the sum of Building's areas from all floors (describes the total area of the building)
     */
    public double getArea() {
        double area = 0;

        for(Poziom poziom : listaPoziomow) {
            area += poziom.getArea();
        }

        return area;
    }

    /**
     *
     * @return the sum of Building's volumes from all floors (describes the total volume of the building)
     */
    public double getCube() {
        double cube = 0;

        for(Poziom poziom : listaPoziomow) {
            cube += poziom.getCube();
        }

        return cube;
    }

    /**
     *
     * @return the sum of Building's lighting power from all floors (describes the total lighting power of the building)
     */
    public double getLight() {
        double light = 0;

        for(Poziom poziom : listaPoziomow) {
            light += poziom.getLight();
        }

        return light;
    }

    /**
     *
     * @return the sum of Building's energy consumption for heating from all floors
     * (describes the total energy consumption for heating of the building)
     */
    public double getHeating() {
        double heating = 0;

        for (Poziom poziom : listaPoziomow) {
            heating += poziom.getHeating();
        }
        return heating;
    }

    /**
     *
     * @return the number representing proportion of the lighting power to the area of the building
     */
    public double getLightPerSquareMeter() {
        return getLight() / getArea();
    }

    /**
     *
     * @return the number representing proportion of the energy consumption for heating to the volume of the building
     */
    public double getHeatingPerCubicMeter() {
        return getHeating() / getCube();
    }
}
