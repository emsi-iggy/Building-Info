package pl.put.poznan.buildingInfo.logic;

import pl.put.poznan.buildingInfo.logic.Lokalizacja;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class {@link Pomieszczenie} represents class {@link Lokalizacja} with additional double type attributes such as
 * {@code area}, {@code cube}, {@code heating} and {@code light}
 */
public class Pomieszczenie extends Lokalizacja{
    private double area;
    private double cube;
    private double heating;
    private double light;
    private Date dataRemontu;
    private ArrayList <Okno> listaOkien;

    /**
     * This is an empty constructor of the {@link Pomieszczenie} which allows to set the basic properties of the object
     * to the default null values.
     */
    public Pomieszczenie() {
        super();
        this.area = 0.0;
        this.cube = 0.0;
        this.heating = 0.0;
        this.light = 0.0;
        this.dataRemontu = new Date();
        this.listaOkien = new ArrayList<>();
    }

    /**
     * This is a constructor of the {@link Pomieszczenie} which allows to set the basic properties of the object
     * with given parameters values.
     *
     * @param id variable inherited from the class Lokalizacja
     *           here is passed to the Costructor method of the class Pomieszczenie
     * @param nazwa variable inherited from the class Lokalizacja
     *              here is passed to the Constructor method of the class Pomieszczzenie
     * @param area variable represents the area of the room
     * @param cube variable represents the volume of the room
     * @param heating variable represents the energy consumption [kWh] for heating the room per year
     * @param light variable represents the total lighting power [W] in the room
     */
    public Pomieszczenie(int id, String nazwa, double area, double cube, double heating, double light) {
        super(id, nazwa);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
        this.dataRemontu = new Date();
        this.listaOkien = new ArrayList<>();
    }

    /**
     * <p>This is a constructor of the {@link Pomieszczenie} which allows to set the basic properties of the object
     * with given parameters values.</p>
     * <p>Compared with constructor with six arguments, this one has additional argument,
     * which sets the date of the last renovation of the room.</p>
     *
     * @param id variable inherited from the class Lokalizacja
     *           here is passed to the Costructor method of the class Pomieszczenie
     * @param nazwa variable inherited from the class Lokalizacja
     *              here is passed to the Costructor method of the class Pomieszczenie
     * @param dataRemontu is the date when the last renovation of the room was made
     * @param area variable represents the area of the room
     * @param cube variable represents the volume of the room
     * @param heating variable represents the energy consumption [kWh] for heating the room per year
     * @param light variable represents the total lighting power [W] in the room
     */
    public Pomieszczenie(int id, String nazwa, Date dataRemontu, double area, double cube, double heating, double light) {
        super(id, nazwa);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
        this.dataRemontu = dataRemontu;
        this.listaOkien = new ArrayList<>();
    }

    /**
     * <p>This is a constructor of the {@link Pomieszczenie} which allows to set the basic properties of the object
     * with given parameters values.</p>
     * <p>Compared with constructor with seven arguments, this one has additional argument,
     * which sets the list containing all th windows in the room.</p>
     *
     * @param id variable inherited from the class Lokalizacja
     *           here is passed to the Costructor method of the class Pomieszczenie
     * @param nazwa variable inherited from the class Lokalizacja
     *              here is passed to the Costructor method of the class Pomieszczenie
     * @param dataRemontu is the date when the last renovation of the room was made
     * @param listaOkien is the list containing all the windows in the room
     * @param area variable represents the area of the room
     * @param cube variable represents the volume of the room
     * @param heating variable represents the energy consumption [kWh] for heating the room per year
     * @param light variable represents the total lighting power [W] in the room
     */
    public Pomieszczenie(int id, String nazwa, Date dataRemontu, ArrayList<Okno> listaOkien, double area, double cube, double heating, double light) {
        super(id, nazwa);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
        this.dataRemontu = dataRemontu;
        this.listaOkien = listaOkien;
    }

    /**
     * This is an overridden method toString. It allows to print on the screen basic info about an object of the {@link Pomieszczenie}
     *
     * @return the String containing names of variables and their values
     */
    @Override
    public String toString() {
        return "Pomieszczenie{" +
                "id=" + getId() +
                ", nazwa='" + getNazwa() + '\'' +
                ", area=" + area +
                ", cube=" + cube +
                ", heating=" + heating +
                ", light=" + light +
                ", dataRemontu=" + dataRemontu +
                ", listaOkien=" + listaOkien +
                '}';
    }

    /**
     * Gets the value of the private field {@code area}. It is a variable represents the area of the room.
     *
     * @return the variable area
     */
    public double getArea() {
        return area;
    }

    /**
     * Sets the value of the private field {@code area}. It is a variable represents the area of the room.
     *
     * @param area the same as described above, but here is passed to the setArea method,
     *             so we can set the value of the area
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Gets the value of the private field {@code cube}. It is a variable represents the volume of the room.
     *
     * @return the variable cube
     */
    public double getCube() {
        return cube;
    }

    /**
     * Sets the value of the private field {@code cube}. It is a variable represents the volume of the room.
     *
     * @param cube the same as described above, but here is passed to the setCube method,
     *             so we can set the value of the volume
     */
    public void setCube(double cube) {
        this.cube = cube;
    }

    /**
     * Gets the value of the private field {@code heating}. It is a variable represents the energy consumption [kWh] for heating the room per year.
     *
     * @return the variable heating
     */
    public double getHeating() {
        return heating;
    }

    /**
     * Sets the value of the private field {@code heating}. It is a variable represents the energy consumption [kWh] for heating the room per year.
     *
     * @param heating the same as described above, but here is passed to the setHeating method,
     *                so we can set the value of the heating consumption
     */
    public void setHeating(double heating) {
        this.heating = heating;
    }

    /**
     * Gets the value of the private field {@code light}. It is a variable represents the total lighting power [W] in the room.
     *
     * @return the variable light
     */
    public double getLight() {
        return light;
    }

    /**
     * Sets the value of the private field {@code light}. It is a variable represents the total lighting power [W] in the room.
     *
     * @param light the same as described above, but here is passed to the setLight method,
     *              so we can set the value of the power lighting
     */
    public void setLight(double light) {
        this.light = light;
    }

    /**
     * Gets the value of the private field {@code dataRemontu}. It is the date when the last renovation of the room was made.
     *
     * @return the variable dataRemontu
     */
    public Date getDataRemontu() {
        return dataRemontu;
    }

    /**
     * Sets the value of the private field {@code dataRemontu}. It is the date when the last renovation of the room was made.
     *
     * @param dataRemontu the same as described above, but here is passed to the setDataRemontu method,
     *                    so we can set the value of the dataRemontu
     */
    public void setDataRemontu(Date dataRemontu) {
        this.dataRemontu = dataRemontu;
    }

    /**
     * Gets the value of the private field {@code listaOkien}. It is the list containing all the windows in the room.
     *
     * @return the list listaOkien
     */
    public ArrayList<Okno> getListaOkien() {
        return listaOkien;
    }

    /**
     * Sets the value of the private field {@code listaOkien}. It is the list containing all the windows in the room.
     *
     * @param listaOkien the same as described above, but here is passed to the setListaOkien method,
     *                   so we can set values of the list listaOkien
     */
    public void setListaOkien(ArrayList<Okno> listaOkien) {
        this.listaOkien = listaOkien;
    }

    /**
     * <p>Gets the value of the total area of all windows placed in the room.</p>
     * <p>The method iterates over the {@code listaOkien} and accumulates the area of every window.</p>
     *
     * @return the sum of Building's windows areas from the room (describes the total windows area of the room)
     */
    public double getPowierzchniaOkien() {
        double powierzchnia = 0;

        for(Okno okno : listaOkien) {
            powierzchnia += okno.getPowierzchnia();
        }

        return powierzchnia;
    }

    /**
     * <p>Gets the value of the total number of all windows placed in the room.</p>
     * <p>The method takes the size of the {@code listaOkien} list.</p>
     *
     * @return the nubmer of Building's windows from the room (describes the total windows number of the room)
     */
    public int getLiczbaOkien() {
        return listaOkien.size();
    }

    /**
     * <p>Gets the value of the coefficient of lighting power to the area of the room.</p>
     * <p>The method calculate ratio of the value {@link Pomieszczenie#getLight()} to the value {@link Pomieszczenie#getArea()}.
     * In case of {@code area} equals {@code 0}, the method returns {@code 0}.</p>
     *
     * @return the number representing proportion of the lighting power to the area of the room
     */
    public double getLightPerSquareMeter() {
        if(getArea() == 0) {
            return 0;
        }

        return getLight() / getArea();
    }

    /**
     * <p>Gets the value of the coefficient of the energy consumption for heating to the volume of the room.</p>
     * <p>The method calculate ratio of the value {@link Pomieszczenie#getLight()} to the value {@link Pomieszczenie#getCube()}.
     * In case of {@code cube} equals {@code 0}, the method returns {@code 0}.</p>
     *
     * @return the number representing proportion of the energy consumption for heating to the volume of the room
     */
    public double getHeatingPerCubicMeter() {
        if(getCube() == 0) {
            return 0;
        }

        return getHeating() / getCube();
    }

    /**
     * <p>Gets the value of the coefficient of the area of windows to the volume of the room.</p>
     * <p>The method calculate ratio of the value {@link Pomieszczenie#getPowierzchniaOkien()} to the value {@link Pomieszczenie#getCube()}.
     * In case of {@code cube} equals {@code 0}, the method returns {@code 0}.</p>
     *
     * @return the number representing proportion of the area of windows to the volume of the room
     */
    public double getNaturalLight() {
        if(getCube() == 0) {
            return 0;
        }

        return getPowierzchniaOkien() / getCube();
    }
}