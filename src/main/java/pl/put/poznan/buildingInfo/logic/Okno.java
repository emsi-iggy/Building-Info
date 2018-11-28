package pl.put.poznan.buildingInfo.logic;

enum RodzajOknaPCV {TRADYCYJNE,POLACIOWE,BALKONOWE,NIEZNANY;}
enum SposobOtwarciaOkna {OBROTOWE,UCHYLNE,WYSOKOOSIOWE,UCHYLNOOBROTOWE,NIEZNANY;}

/**
 * Class Okno (window) is the addition to the class Lokalizacja with many double type and enum type attributes
 * such as area, width, height, price, type and type of opening the window
 */
public class Okno {
    private double powierzchnia;
    private double szerokosc;
    private double wysokosc;
    private double cena;
    private RodzajOknaPCV rodzajOknaPCV;
    private SposobOtwarciaOkna sposobOtwarciaOkna;

    public Okno() {
        this.powierzchnia = 0;
        this.szerokosc = 0;
        this.wysokosc = 0;
        this.cena = 0;
        this.rodzajOknaPCV = RodzajOknaPCV.NIEZNANY;
        this.sposobOtwarciaOkna = SposobOtwarciaOkna.NIEZNANY;
    }

    /**
     *
     * @param powierzchnia variable represents the area of the window
     * @param szerokosc variable represents the width of the window
     * @param wysokosc variable represents the height of the window
     * @param cena variable represents the price of the window
     * @param rodzajOknaPCV variable which contains one value from the set of constants RodzajOknaPCV
     *                      represents the type of the window
     * @param sposobOtwarciaOkna variable which contains one value from the set of constants SposobOtwarciaOkna
     *      *                      represents the type of opening the window
     */
    public Okno(double powierzchnia, double szerokosc, double wysokosc, double cena, RodzajOknaPCV rodzajOknaPCV, SposobOtwarciaOkna sposobOtwarciaOkna) {
        this.powierzchnia = powierzchnia;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.cena = cena;
        this.rodzajOknaPCV = rodzajOknaPCV;
        this.sposobOtwarciaOkna = sposobOtwarciaOkna;
    }

    /**
     *
     * @return the String containing names of variables and their values
     */
    @Override
    public String toString() {
        return "Okno{" +
                "powierzchnia=" + powierzchnia +
                ", szerokosc=" + szerokosc +
                ", wysokosc=" + wysokosc +
                ", cena=" + cena +
                ", rodzajOknaPCV=" + rodzajOknaPCV +
                ", sposobOtwarciaOkna=" + sposobOtwarciaOkna +
                '}';
    }

    /**
     *
     * @return the variable powierzchnia
     */
    public double getPowierzchnia() {
        return powierzchnia;
    }

    /**
     *
     * @param powierzchnia the same as described above, but here is passed to the setPowierzchnia method,
     *                     so we can set the value of the area
     */
    public void setPowierzchnia(double powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    /**
     *
     * @return the variable szerokosc
     */
    public double getSzerokosc() {
        return szerokosc;
    }

    /**
     *
     * @param szerokosc the same as described above, but here is passed to the setSzerokosc method,
     *                  so we can set the value of the width
     */
    public void setSzerokosc(double szerokosc) {
        this.szerokosc = szerokosc;
    }

    /**
     *
     * @return the variable wysokosc
     */
    public double getWysokosc() {
        return wysokosc;
    }

    /**
     *
     * @param wysokosc the same as described above, but here is passed to the setWysokosc method,
     *                 so we can set the value of the height
     */
    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    /**
     *
     * @return the variable cena
     */
    public double getCena() {
        return cena;
    }

    /**
     *
     * @param cena the same as described above, but here is passed to the setCena method,
     *             so we can set the value of the price
     */
    public void setCena(double cena) {
        this.cena = cena;
    }

    /**
     *
     * @return the variable rodzajOknaPCV
     */
    public RodzajOknaPCV getRodzajOknaPCV() {
        return rodzajOknaPCV;
    }

    /**
     *
     * @param rodzajOknaPCV the same as described above, but here is passed to the setRodzajOknaPCV method,
     *                      so we can set the value of the type of the window
     */
    public void setRodzajOknaPCV(RodzajOknaPCV rodzajOknaPCV) {
        this.rodzajOknaPCV = rodzajOknaPCV;
    }

    /**
     *
     * @return the variable sposobOtwarciaOkna
     */
    public SposobOtwarciaOkna getSposobOtwarciaOkna() {
        return sposobOtwarciaOkna;
    }

    /**
     *
     * @param sposobOtwarciaOkna the same as described above, but here is passed to the setSposobOtwarciaOkna method,
     *                           so we can set the value of the type of opening the window
     */
    public void setSposobOtwarciaOkna(SposobOtwarciaOkna sposobOtwarciaOkna) {
        this.sposobOtwarciaOkna = sposobOtwarciaOkna;
    }
}
