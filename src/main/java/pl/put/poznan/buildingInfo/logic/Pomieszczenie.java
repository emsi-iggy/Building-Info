package pl.put.poznan.buildingInfo.logic;

public class Pomieszczenie {
    private int id; //dodana zmienna
    private String nazwa; //dodana zmienna
    private double area;
    private double cube;
    private double heating;
    private double light;

    public Pomieszczenie() {
        this.id = 0; //wyzerowanie nowej zmiennej
        this.nazwa = ""; //to samo co wyzej
        this.area = 0.0;
        this.cube = 0.0;
        this.heating = 0.0;
        this.light = 0.0;
    }

    public Pomieszczenie(int id, String nazwa, double area, double cube, double heating, double light) {
        this.id = id;       //tu tez
        this.nazwa = nazwa; //i tu
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    @Override
    public String toString() {
        return "Pomieszczenie{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", area=" + area +
                ", cube=" + cube +
                ", heating=" + heating +
                ", light=" + light +
                '}'; //czemu tu jest apostrof a nie cudzyslow? hmmm... doesn't matter
    }

    public int getId() { //settery i gettery do Id i Nazwy dodane
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCube() {
        return cube;
    }

    public void setCube(double cube) {
        this.cube = cube;
    }

    public double getHeating() {
        return heating;
    }

    public void setHeating(double heating) {
        this.heating = heating;
    }

    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        this.light = light;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}