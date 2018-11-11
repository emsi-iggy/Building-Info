package pl.put.poznan.buildingInfo.logic;

import java.util.ArrayList;

public class Poziom extends Lokalizacja {

    private ArrayList <Pomieszczenie> listaPomieszczen;

    public Poziom(){
        super();
        this.listaPomieszczen = new ArrayList<>();
    }

    public Poziom(int id, String nazwa, ArrayList <Pomieszczenie> listaPomieszczen) {
        super(id,nazwa);
        this.listaPomieszczen = listaPomieszczen;
    }

    @Override
    public String toString() {
        return "Poziom{" +
                "id=" + getId() +
                ", nazwa='" + getNazwa() + '\'' +
                "listaPomieszczen=" + listaPomieszczen +
                '}';
    }

    public ArrayList<Pomieszczenie> getListaPomieszczen() {
        return listaPomieszczen;
    }

    public void setListaPomieszczen(ArrayList <Pomieszczenie> listaPomieszczen) {
        this.listaPomieszczen = listaPomieszczen;
    }
}