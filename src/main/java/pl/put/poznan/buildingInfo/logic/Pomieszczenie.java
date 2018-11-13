package pl.put.poznan.buildingInfo.logic;

import pl.put.poznan.buildingInfo.logic.Lokalizacja;

/**
 * Class Pomieszczenie represents class Lokalizacja with additional double typu attributes such as
 * area, cube, heating and light
 */
public class Pomieszczenie extends Lokalizacja{
    private double area;
    private double cube;
    private double heating;
    private double light;

    public Pomieszczenie() {
        super();
        this.area = 0.0;
        this.cube = 0.0;
        this.heating = 0.0;
        this.light = 0.0;
    }

    /**
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
    }

    /**
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
                '}';
    }

    /**
     *
     * @return the variable cube
     */
    public double getCube() {
        return cube;
    }

    /**
     *
     * @param cube the same as described above, but here is passed to the setCube method,
     *             so we can set the value of the volume
     */
    public void setCube(double cube) {
        this.cube = cube;
    }

    /**
     *
     * @return the variable heating
     */

    public double getHeating() {
        return heating;
    }

    /**
     *
     * @param heating the same as described above, but here is passed to the setHeating method,
     *                so we can set the value of the heating consumption
     */
    public void setHeating(double heating) {
        this.heating = heating;
    }

    /**
     *
     * @return the variable light
     */
    public double getLight() {
        return light;
    }

    /**
     *
     * @param light the same as described above, but here is passed to the setLight method,
     *              so we can set the value of the power lighting
     */
    public void setLight(double light) {
        this.light = light;
    }

    /**
     *
     * @return the variable area
     */
    public double getArea() {
        return area;
    }

    /**
     *
     * @param area the same as described above, but here is passed to the setArea method,
     *             so we can set the value of the area
     */
    public void setArea(double area) {
        this.area = area;
    }
}