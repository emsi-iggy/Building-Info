package pl.put.poznan.buildingInfo.logic;


import java.util.*;

/**
 * Class {@link Budynek} represents class {@link Lokalizacja} with additional attributes such as {@code ArrayList} type {@link Poziom} - {@code listaPoziomow}
 */
public class Budynek extends Lokalizacja{

    private ArrayList <Poziom> listaPoziomow ;

    /**
     * This is an empty constructor of the {@link Budynek} which allows to set the basic properties of the object
     * to the default null values.
     */
    public Budynek() {
        super();
        this.listaPoziomow = new ArrayList<>();
    }

    /**
     * This is a constructor of the {@link Budynek} which allows to set the basic properties of the object
     * with given parameters values.
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
     * This is an overridden method toString. It allows to print on the screen basic info about an object of the {@link Budynek}
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
     * Gets the value of the private field {@code listaPoziomow}. It is a list containing elements type {@link Poziom}.
     * All that floors from this list {code @listaPoziomow} are parts of the current building.
     *
     * @return ArrayList listaPoziomow
     */
    public ArrayList<Poziom> getListaPoziomow() {
        return listaPoziomow;
    }

    /**
     * Sets the value of the private field {@code listaPoziomow}. It is a list containing elements type {@link Poziom}.
     * All that floors from this list {code @listaPoziomow} are parts of the current building.
     *
     * @param listaPoziomow the same as described above, but here is passed to the setListaPoziomow method
     *                      so we can change to the other list of the same type
     */
    public void setListaPoziomow(ArrayList <Poziom> listaPoziomow) {
        this.listaPoziomow = listaPoziomow;
    }

    /**
     * <p>Gets the value of the total area of the building. That area is based on summary area of all floors of the current building.</p>
     * <p>The method iterates over the {@code listaPoziomow} and accumulates the area of every floor.
     * It is made by calling {@link Poziom#getArea()} method for each floor.</p>
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
     * <p>Gets the value of the total volume of the building. That volume is based on summary volume of all floors of the current building.</p>
     * <p>The method iterates over the {@code listaPoziomow} and accumulates the volume of every floor.
     * It is made by calling {@link Poziom#getCube()} method for each floor.</p>
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
     * <p>Gets the value of the total lighting power of the building. That power is based on summary power of all floors of the current building.</p>
     * <p>The method iterates over the {@code listaPoziomow} and accumulates the lighting power of every floor.
     * It is made by calling {@link Poziom#getLight()} method for each room.</p>
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
     * <p>Gets the value of the total energy consumption for heating of the building. That energy is based on summary energy of all floors of the current building.</p>
     * <p>The method iterates over the {@code listaPoziomow} and accumulates the energy consumption for heating of every floor.
     * It is made by calling {@link Poziom#getHeating()} method for each floor.</p>
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
     * <p>Gets the date when the last renovation of the building was made. That date is based on the oldest date of last renovation of the floors of the current building.</p>
     * <p>The method iterates over the {@code listaPoziomow} and catches the oldest date.
     * In case of the empty list {@code listaPoziomow}, the value {@code null} is returned.</p>
     *
     * @return the date when the last renovation of the building was made.
     * It is the date of last renovation of any floor in this building.
     */
    public Date getDataRemontu() {
        Date dataRemontu;

        if((listaPoziomow == null) || (listaPoziomow.size() == 0)) {
            return null;
        }

        dataRemontu = listaPoziomow.get(0).getDataRemontu();
        for(Poziom poziom : listaPoziomow) {
            if(dataRemontu.after( poziom.getDataRemontu() )) {
                dataRemontu = poziom.getDataRemontu();
            }
        }

        return dataRemontu;
    }

    /**
     * <p>Gets the value of the total area of all the windows at the building. That area is based on summary windows area of all floors of the current building.</p>
     * <p>The method iterates over the {@code listaPoziomow} and accumulates the area of all the windows of every floor.
     * It is made by calling {@link Poziom#getPowierzchniaOkien()} method for each floor.</p>
     *
     * @return the sum of Building's windows areas from all floors (describes the total windows area of the building)
     */
    public double getPowierzchniaOkien() {
        double powierzchnia = 0;

        for(Poziom poziom : listaPoziomow) {
            powierzchnia += poziom.getPowierzchniaOkien();
        }

        return powierzchnia;
    }

    /**
     * <p>Gets the value of the total number of all the windows at the building. That number is based on summary windows number of all floors of the current building.</p>
     * <p>The method iterates over the {@code listaPoziomow} and accumulates the number of all the windows of every floor.
     * It is made by calling {@link Poziom#getLiczbaOkien()} method for each floor.</p>
     *
     * @return the number of windows in the building (describes the total number of windows in all floors)
     */
    public int getLiczbaOkien() {
        int liczbaOkien = 0;

        for(Poziom poziom : listaPoziomow) {
            liczbaOkien += poziom.getLiczbaOkien();
        }

        return liczbaOkien;
    }

    /**
     * <p>Gets the value of the coefficient of lighting power to the area of the building.</p>
     * <p>The method calculate ratio of the value {@link Budynek#getLight()} to the value {@link Budynek#getArea()}.
     * In case of {@link Budynek#getArea()} equals {@code 0}, the method returns {@code 0}.</p>
     *
     * @return the number representing proportion of the lighting power to the area of the building
     */
    public double getLightPerSquareMeter() {
        double powierzchnia;

        powierzchnia = getArea();
        if(powierzchnia == 0) {
            return 0;
        }

        return getLight() / powierzchnia;
    }

    /**
     * <p>Gets the value of the coefficient of the energy consumption for heating to the volume of the building.</p>
     * <p>The method calculate ratio of the value {@link Budynek#getLight()} to the value {@link Budynek#getCube()}.
     * In case of {@link Budynek#getCube()} equals {@code 0}, the method returns {@code 0}.</p>
     *
     * @return the number representing proportion of the energy consumption for heating to the volume of the building
     */
    public double getHeatingPerCubicMeter() {
        double kubatura;

        kubatura = getCube();
        if(kubatura == 0) {
            return 0;
        }

        return getHeating() / kubatura;
    }

    /**
     * <p>Gets the list of rooms, which exceeding given limit of the energy consumption for heating in current building.</p>
     * <p>The method iterates over the list of floors, to iterates over the list of rooms, to check if the
     * energy consumption for heating exceeds the limit.
     * It is made for each room with help of {@link Pomieszczenie#getHeatingPerCubicMeter()} method.</p>
     *
     * @param limit represents the limit of the energy consumption [kWh] for heating the room per year, which shouldn't be exceeded
     *
     * @return the list of objects of the type {@link Pomieszczenie}, which is the list of the rooms exceeding the heating limit
     */
    public ArrayList <Pomieszczenie> getHeatingLimit(double limit) {
        ArrayList<Pomieszczenie> listaHeatingLimit;
        listaHeatingLimit = new ArrayList<>();

        for (Poziom poziom : listaPoziomow) {
            for (Pomieszczenie pomieszczenie : poziom.getListaPomieszczen()) {
                if (pomieszczenie.getHeatingPerCubicMeter() > limit)
                    listaHeatingLimit.add(pomieszczenie);
            }
        }
        return listaHeatingLimit;
    }

    /**
     * <p>Gets the list of rooms, which exceeding given limit of the lighting power in current building.</p>
     * <p>The method iterates over the list of floors, to iterates over the list of rooms, to check if the
     * lighting power exceeds the limit.
     * It is made for each room with help of {@link Pomieszczenie#getLightPerSquareMeter()} method.</p>
     *
     * @param limit represents the limit of the lighting power [W] in the room, which shouldn't be exceeded
     *
     * @return the list of objects of the type {@link Pomieszczenie}, which is the list of the rooms exceeding the lighting power limit
     */
    public ArrayList <Pomieszczenie> getLightLimit(double limit) {
        ArrayList<Pomieszczenie> listaLightLimit;
        listaLightLimit = new ArrayList<>();

        for (Poziom poziom : listaPoziomow) {
            for (Pomieszczenie pomieszczenie : poziom.getListaPomieszczen()) {
                if (pomieszczenie.getLightPerSquareMeter() > limit)
                    listaLightLimit.add(pomieszczenie);
            }
        }
        return listaLightLimit;
    }

    /**
     * <p>Gets the list of rooms, which don't fulfill given limit of the natural light in current building.</p>
     * <p>The method iterates over the list of floors, to iterates over the list of rooms, to check if the
     * natural light fulfill the limit.
     * It is made for each room with help of {@link Pomieszczenie#getNaturalLight()} method.</p>
     *
     * @param limit represents the limit of the natural light in the room, which should be fulfill
     *
     * @return the list of objects of the type {@link Pomieszczenie}, which is the list of the rooms not fulfilling the natural light limit
     */
    public ArrayList <Pomieszczenie> getNaturalLightLimit(double limit) {
        ArrayList<Pomieszczenie> listaNaturalLightLimit;
        listaNaturalLightLimit = new ArrayList<>();

        for (Poziom poziom : listaPoziomow) {
            for (Pomieszczenie pomieszczenie : poziom.getListaPomieszczen()) {
                if (pomieszczenie.getNaturalLight() < limit)
                    listaNaturalLightLimit.add(pomieszczenie);
            }
        }
        return listaNaturalLightLimit;
    }

    /**
     * <p>Gets the list of rooms, which exceeding given limit of the renovation's date in current building.</p>
     * <p>The method iterates over the list of floors, to iterates over the list of rooms, to check if the
     * renovation's date is older than the renovation's date limit.
     * It is made for each room with help of {@link Pomieszczenie#getDataRemontu()} method.</p>
     *
     * @param limit represents the limit of the date when the last renovation of the room should be made
     *
     * @return the list of objects of the type {@link Pomieszczenie}, which is the list of the rooms exceeding the renovation's date limit
     */
    public ArrayList <Pomieszczenie> getDataRemontuLimit(Date limit) {
        ArrayList<Pomieszczenie> listaDataRemontuLimit;
        listaDataRemontuLimit = new ArrayList<>();

        for (Poziom poziom : listaPoziomow) {
            for (Pomieszczenie pomieszczenie : poziom.getListaPomieszczen()) {
                if (pomieszczenie.getDataRemontu().before(limit))
                    listaDataRemontuLimit.add(pomieszczenie);
            }
        }
        return listaDataRemontuLimit;
    }
}
