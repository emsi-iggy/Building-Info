package pl.put.poznan.buildingInfo.logic;

import java.util.ArrayList;
import java.util.Date;

/**
 * Class {@link Poziom} represents class {@link Lokalizacja} with additional attributes such as {@code ArrayList} type {@link Pomieszczenie} - listaPomieszczen
 */
public class Poziom extends Lokalizacja {

    private ArrayList <Pomieszczenie> listaPomieszczen;

    /**
     * This is an empty constructor of the {@link Poziom} which allows to set the basic properties of the object
     * to the default null values.
     */
    public Poziom(){
        super();
        this.listaPomieszczen = new ArrayList<>();
    }

    /**
     * This is a constructor of the {@link Poziom} which allows to set the basic properties of the object
     * with given parameters values.
     *
     * @param id variable inherited from the class Lokalizacja
     *           here is passed to the Costructor method of the class Poziom
     * @param nazwa variable inherited from the class Lokalizacja
     *              here is passed to the Constructor method of the class Poziom
     * @param listaPomieszczen is a list containing elements type Pomieszczenie,
     *                         here is passed to the Constructor method of the class Poziom
     */
    public Poziom(int id, String nazwa, ArrayList <Pomieszczenie> listaPomieszczen) {
        super(id,nazwa);
        this.listaPomieszczen = listaPomieszczen;
    }

    /**
     * This is an overridden method toString. It allows to print on the screen basic info about an object of the {@link Poziom}
     *
     * @return the String containing names of variables and their values
     */
    @Override
    public String toString() {
        return "Poziom{" +
                "id=" + getId() +
                ", nazwa='" + getNazwa() + '\'' +
                "listaPomieszczen=" + listaPomieszczen +
                '}';
    }

    /**
     * Gets the value of the private field {@code listaPomieszczen}. It is a list containing elements type {@link Pomieszczenie}.
     * All that rooms from this list {code @listaPomieszczen} are parts of the current floor.
     *
     * @return ArrayList listaPomieszczen
     */
    public ArrayList<Pomieszczenie> getListaPomieszczen() {
        return listaPomieszczen;
    }

    /**
     * Sets the value of the private field {@code listaPomieszczen}. It is a list containing elements type {@link Pomieszczenie}.
     * All that rooms from this list {code @listaPomieszczen} are parts of the current floor.
     *
     * @param listaPomieszczen the same as described above, but here is passed to the setListaPomieszczen method
     *                         so we can change to the other list of the same type
     */
    public void setListaPomieszczen(ArrayList <Pomieszczenie> listaPomieszczen) {
        this.listaPomieszczen = listaPomieszczen;
    }

    /**
     * <p>Gets the value of the total area of the floor. That area is based on summary area of all rooms of the current floor.</p>
     * <p>The method iterates over the {@code listaPomieszczen} and accumulates the area of every room.
     * It is made by calling {@link Pomieszczenie#getArea()} method for each room.</p>
     *
     * @return the sum of Building's areas from all rooms (describes the total area of the floor)
     */
    public double getArea() {
        double area = 0;

        for(Pomieszczenie pomieszczenie : listaPomieszczen) {
            area += pomieszczenie.getArea();
        }

        return area;
    }

    /**
     * <p>Gets the value of the total volume of the floor. That volume is based on summary volume of all rooms of the current floor.</p>
     * <p>The method iterates over the {@code listaPomieszczen} and accumulates the volume of every room.
     * It is made by calling {@link Pomieszczenie#getCube()} method for each room.</p>
     *
     * @return the sum of Building's volumes from all rooms (describes the total volume of the floor)
     */
    public double getCube() {
        double cube = 0;

        for(Pomieszczenie pomieszczenie : listaPomieszczen) {
            cube += pomieszczenie.getCube();
        }

        return cube;
    }

    /**
     * <p>Gets the value of the total lighting power of the floor. That power is based on summary power of all rooms of the current floor.</p>
     * <p>The method iterates over the {@code listaPomieszczen} and accumulates the lighting power of every room.
     * It is made by calling {@link Pomieszczenie#getLight()} method for each room.</p>
     *
     * @return the sum of Building's lighting power from all rooms (describes the total lighting power of the floor)
     */
    public double getLight() {
        double light = 0;

        for(Pomieszczenie pomieszczenie : listaPomieszczen) {
            light += pomieszczenie.getLight();
        }

        return light;
    }

    /**
     * <p>Gets the value of the total energy consumption for heating of the floor. That energy is based on summary energy of all rooms of the current floor.</p>
     * <p>The method iterates over the {@code listaPomieszczen} and accumulates the energy consumption for heating of every room.
     * It is made by calling {@link Pomieszczenie#getHeating()} method for each room.</p>
     *
     * @return the sum of Building's energy consumption for heating from all rooms
     * (describes the total energy consumption for heating of the floor)
     */
    public double getHeating() {
        double heating = 0;

        for(Pomieszczenie pomieszczenie : listaPomieszczen) {
            heating += pomieszczenie.getHeating();
        }

        return heating;
    }

    /**
     * <p>Gets the date when the last renovation of the floor was made. That date is based on the oldest date of last renovation of the rooms of the current floor.</p>
     * <p>The method iterates over the {@code listaPomieszczen} and catches the oldest date.
     * In case of the empty list {@code listaPomieszczen}, the value {@code null} is returned.</p>
     *
     * @return the date when the last renovation of the floor was made.
     * It is the date of last renovation of any room at this floor.
     */
    public Date getDataRemontu() {
        Date dataRemontu;

        if((listaPomieszczen == null) || (listaPomieszczen.size() == 0)) {
            return null;
        }

        dataRemontu = listaPomieszczen.get(0).getDataRemontu();
        for(Pomieszczenie pomieszczenie : listaPomieszczen) {
            if(dataRemontu.after( pomieszczenie.getDataRemontu() )) {
                dataRemontu = pomieszczenie.getDataRemontu();
            }
        }

        return dataRemontu;
    }

    /**
     * <p>Gets the value of the total area of all the windows at the floor. That area is based on summary windows area of all rooms of the current floor.</p>
     * <p>The method iterates over the {@code listaPomieszczen} and accumulates the area of all the windows of every room.
     * It is made by calling {@link Pomieszczenie#getPowierzchniaOkien()} method for each room.</p>
     *
     * @return the sum of Building's windows areas from all rooms (describes the total windows area of the floor)
     */
    public double getPowierzchniaOkien() {
        double powierzchnia = 0;

        for(Pomieszczenie pomieszczenie : listaPomieszczen) {
            powierzchnia += pomieszczenie.getPowierzchniaOkien();
        }

        return powierzchnia;
    }

    /**
     * <p>Gets the value of the total number of all the windows at the floor. That number is based on summary windows number of all rooms of the current floor.</p>
     * <p>The method iterates over the {@code listaPomieszczen} and accumulates the number of all the windows of every room.
     * It is made by calling {@link Pomieszczenie#getLiczbaOkien()} method for each room.</p>
     *
     * @return the number of windows in the floor (describes the total number of windows in all rooms)
     */
    public int getLiczbaOkien() {
        int liczbaOkien = 0;

        for(Pomieszczenie pomieszczenie : listaPomieszczen) {
            liczbaOkien += pomieszczenie.getLiczbaOkien();
        }

        return liczbaOkien;
    }

    /**
     * <p>Gets the value of the coefficient of lighting power to the area of the floor.</p>
     * <p>The method calculate ratio of the value {@link Poziom#getLight()} to the value {@link Poziom#getArea()}.
     * In case of {@link Poziom#getArea()} equals {@code 0}, the method returns {@code 0}.</p>
     *
     * @return the number representing proportion of the lighting power to the area of the floor
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
     * <p>Gets the value of the coefficient of the energy consumption for heating to the volume of the floor.</p>
     * <p>The method calculate ratio of the value {@link Poziom#getLight()} to the value {@link Poziom#getCube()}.
     * In case of {@link Poziom#getCube()} equals {@code 0}, the method returns {@code 0}.</p>
     *
     * @return the number representing proportion of the energy consumption for heating to the volume of the floor
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
     * <p>Gets the value of the coefficient of the area of windows to the volume of the floor.</p>
     * <p>The method calculate ratio of the value {@link Pomieszczenie#getPowierzchniaOkien()} to the value {@link Pomieszczenie#getCube()}.
     * In case of {@code cube} equals {@code 0}, the method returns {@code 0}.</p>
     *
     * @return the number representing proportion of the area of windows to the volume of the floor
     */
    public double getNaturalLight() {
        if(getCube() == 0) {
            return 0;
        }

        return getPowierzchniaOkien() / getCube();
    }
}