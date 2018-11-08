package pl.put.poznan.pomieszczenie.logic;

public class Pomieszczenie {
    private Double area;
    private Double cube;
    private Double heating;
    private Double light;

    public Pomieszczenie() {
        this.area = 0.0;
        this.cube = 0.0;
        this.heating = 0.0;
        this.light = 0.0;
    }

    public Pomieszczenie(Double area, Double cube, Double heating, Double light) {
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    public Double getCube() {
        return cube;
    }

    public void setCube(Double cube) {
        this.cube = cube;
    }

    public Double getHeating() {
        return heating;
    }

    public void setHeating(Double heating) {
        this.heating = heating;
    }

    public Double getLight() {
        return light;
    }

    public void setLight(Double light) {
        this.light = light;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
