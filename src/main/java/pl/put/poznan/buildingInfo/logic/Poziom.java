package pl.put.poznan.buildingInfo.logic;

import java.util.ArrayList;
import java.util.Date;

/**
 * Class Poziom represents class Lokalizacja with additional attributes such as ArrayList type Pomieszczenie - listaPomieszczen
 */
public class Poziom extends Lokalizacja {

    private ArrayList <Pomieszczenie> listaPomieszczen;

    public Poziom(){
        super();
        this.listaPomieszczen = new ArrayList<>();
    }

    /**
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
     *
     * @return ArrayList listaPomieszczen
     */
    public ArrayList<Pomieszczenie> getListaPomieszczen() {
        return listaPomieszczen;
    }

    /**
     *
     * @param listaPomieszczen the same as described above, but here is passed to the setListaPomieszczen method
     *                         so we can change to the other list of the same type
     */

    public void setListaPomieszczen(ArrayList <Pomieszczenie> listaPomieszczen) {
        this.listaPomieszczen = listaPomieszczen;
    }

    /**
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
     *
     * @return the date when the last renovation of the floor was made.
     * It is the date of last renovation of any room at this floor.
     */
    public Date getDataRemontu() {
        Date dataRemontu = new Date();

        for(Pomieszczenie pomieszczenie : listaPomieszczen) {
            if(dataRemontu.after( pomieszczenie.getDataRemontu() )) {
                dataRemontu = pomieszczenie.getDataRemontu();
            }
        }

        return dataRemontu;
    }

    /**
     *
     * @return the number representing proportion of the lighting power to the area of the floor
     */
    public double getLightPerSquareMeter() {
        return getLight() / getArea();
    }

    /**
     *
     * @return the number representing proportion of the energy consumption for heating to the volume of the floor
     */
    public double getHeatingPerCubicMeter() {
        return getHeating() / getCube();
    }
}