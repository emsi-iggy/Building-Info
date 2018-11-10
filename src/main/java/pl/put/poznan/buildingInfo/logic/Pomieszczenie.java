package pl.put.poznan.buildingInfo.logic;

import pl.put.poznan.buildingInfo.logic.Lokalizacja;

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

    public Pomieszczenie(int id, String nazwa, double area, double cube, double heating, double light) {
        super(id, nazwa);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

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