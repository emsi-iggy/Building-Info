package pl.put.poznan.buildingInfo.logic;

public class Lokalizacja {
    private int id;
    private String nazwa;

    public Lokalizacja() {
        this.id = 0;
        this.nazwa = "";
    }

    public Lokalizacja(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Lokalizacja{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }

    public int getId() {
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
}
