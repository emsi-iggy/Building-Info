package pl.put.poznan.buildingInfo.logic;


public class Budynek extends Lokalizacja{

    public ArrayList <Poziom> listaPoziomow ;


    public Budynek() {
        super();
        this.listaPoziomow = new ArrayList<>();

    }

    public Budynek(int id, String nazwa, ArrayList <Poziom> listaPoziomow) {
        super(id, nazwa);
        this.listaPoziomow = listaPoziomow;

    }

    @Override
    public String toString() {
        return "Budynek{" +
                "id=" + getId() +
                ", nazwa='" + getNazwa() + '\'' +
                "listaPoziomow=" + listaPoziomow +
                '}';
    }

    public int getListapoziomow() {
        return ArrayList <Poziom> listaPoziomow;
    }

    public void setListaPoziomow(ArrayList <Poziom> listaPoziomow) {
        this.listaPoziomow = listaPoziomow;
    }

}
