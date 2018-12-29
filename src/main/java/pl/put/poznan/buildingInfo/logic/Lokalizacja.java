package pl.put.poznan.buildingInfo.logic;

import java.util.Date;

/**
 * Abstract class {@link Lokalizacja} represents building ({@link Budynek}), floor ({@link Poziom}) or room ({@link Pomieszczenie})
 */
public abstract class Lokalizacja {
    private int id;
    private String nazwa;

    /**
     * This is an empty constructor of the {@link Lokalizacja} which allows to set the basic properties of the object
     * to the default null values.
     */
    public Lokalizacja() {
        this.id = 0;
        this.nazwa = "";
    }

    /**
     * This is a constructor of the {@link Lokalizacja} which allows to set the basic properties of the object
     * with given parameters values.
     *
     * @param id is an identifier which is unique for each instance of the class {@link Lokalizacja} (location),
     *           here is passed to the constructor method of the class {@link Lokalizacja}
     * @param nazwa is the user-friendly variable which contains the name of the location,
     *              here is passed to the constructor method of the class {@link Lokalizacja}
     */
    public Lokalizacja(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    /**
     * This is an overridden method toString. It allows to print on the screen basic info about an object of the {@link Lokalizacja}
     *
     * @return the String containing names of variables and their values
     */
    @Override
    public String toString() {
        return "Lokalizacja{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }

    /**
     * Gets the value of the private field {@code id}. It is an identifier which is unique for each instance of the class {@link Lokalizacja} (location).
     *
     * @return the variable id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the private field {@code id}. It is an identifier which is unique for each instance of the class {@link Lokalizacja} (location).
     *
     * @param id the same as described above, but here is passed to the setId method so we can change to the other id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the value of the private field {@code nazwa}. It is the user-friendly variable which contains the name of the location.
     *
     * @return the variable nazwa
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * Sets the value of the private field {@code nazwa}. It is the user-friendly variable which contains the name of the location.
     *
     * @param nazwa the same as described above, but here is passed to the setNazwa method which enables to change the
     *              value nazwa
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * Abstract method, which provide in extended classes to get the area of localization.
     *
     * @return the area of localization
     */
    public abstract double getArea();

    /**
     * Abstract method, which provide in extended classes to get the volume of localization.
     *
     * @return the volume of localization
     */
    public abstract double getCube();

    /**
     * Abstract method, which provide in extended classes to get the lighting power of localization.
     *
     * @return the lighting power of localization
     */
    public abstract double getLight();

    /**
     * Abstract method, which provide in extended classes to get the energy consumption for heating of localization.
     *
     * @return the energy consumption for heating of localization
     */
    public abstract double getHeating();

    /**
     * Abstract method, which provide in extended classes to get the date, when the last renovation of the localization was made.
     *
     * @return the date, when the last renovation of the localization was made
     */
    public abstract Date getDataRemontu();

    /**
     * Abstract method, which provide in extended classes to get the sum of localization's windows areas.
     *
     * @return the sum of localization's windows areas
     */
    public abstract double getPowierzchniaOkien();

    /**
     * Abstract method, which provide in extended classes to get the number of windows in the localization.
     *
     * @return the number of windows in the localization
     */
    public abstract int getLiczbaOkien();

    /**
     * Abstract method, which provide in extended classes to get the number representing proportion of the lighting power to the area of the localization.
     *
     * @return the number representing proportion of the lighting power to the area of the localization
     */
    public abstract double getLightPerSquareMeter();

    /**
     * Abstract method, which provide in extended classes to get the number representing proportion of the energy consumption for heating to the volume of the localization.
     *
     * @return the number representing proportion of the energy consumption for heating to the volume of the localization
     */
    public abstract double getHeatingPerCubicMeter();

    /**
     * Abstract method, which provide in extended classes to get the number representing proportion of the area of windows to the volume of the localization.
     *
     * @return the number representing proportion of the area of windows to the volume of the localization
     */
    public abstract double getNaturalLight();
}
