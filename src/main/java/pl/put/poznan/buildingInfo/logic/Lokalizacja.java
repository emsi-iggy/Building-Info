package pl.put.poznan.buildingInfo.logic;

import java.util.Date;

/**
 * Class Lokalizacja represents building (Budynek), floor (Poziom) or room (Pomieszczenie)
 */
public class Lokalizacja {
    private int id;
    private String nazwa;
    private Date dataRemontu;


    public Lokalizacja() {
        this.id = 0;
        this.nazwa = "";
        this.dataRemontu = new Date();
    }

    /**
     *
     * @param id is an identifier which is unique for each instance of the class Lokalizacja (location),
     *           here is passed to the Costructor method of the class Lokalizacja
     * @param nazwa is the user-friendly variable which contains the name of the location,
     *              here is passed to the Constructor method of the class Lokalizacja
     */
    public Lokalizacja(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
        this.dataRemontu = new Date();
    }

    /**
     *
     * @param id is an identifier which is unique for each instance of the class Lokalizacja (location),
     *           here is passed to the Costructor method of the class Lokalizacja
     * @param nazwa is the user-friendly variable which contains the name of the location,
     *              here is passed to the Constructor method of the class Lokalizacja
     * @param dataRemontu is the date when the last renovation of the location was made,
     *                    here is passed to the Constructor method of the class Lokalizacja
     */

    public Lokalizacja(int id, String nazwa, Date dataRemontu) {
        this.id = id;
        this.nazwa = nazwa;
        this.dataRemontu = dataRemontu;
    }

    /**
     *
     * @return the String containing names of variables and their values
     */
    @Override
    public String toString() {
        return "Lokalizacja{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", dataRemontu=" + dataRemontu +
                '}';
    }

    /**
     *
     * @return the variable id
     */

    public int getId() {
        return id;
    }

    /**
     *
     * @param id the same as described above, but here is passed to the setId method so we can change to the other id
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the variable nazwa
     */

    public String getNazwa() {
        return nazwa;
    }

    /**
     *
     * @param nazwa the same as described above, but here is passed to the setNazwa method which enables to change the
     *              value nazwa
     */

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     *
     * @return the variable dataRemontu
     */
    public Date getDataRemontu() {
        return dataRemontu;
    }

    /**
     *
     * @param dataRemontu the same as descibed above, but here is passed to the setDataRemontu method which enables to
     *                    change th value dataRemontu
     */
    public void setDataRemontu(Date dataRemontu) {
        this.dataRemontu = dataRemontu;
    }
}
