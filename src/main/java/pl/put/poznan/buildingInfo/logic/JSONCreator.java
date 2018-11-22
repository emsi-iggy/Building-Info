package pl.put.poznan.buildingInfo.logic;

import org.json.simple.*;

public class JSONCreator {
    
    public JSONObject getJSONPomieszczenie(Pomieszczenie a){
        JSONObject tmp = new JSONObject();
        tmp.put("id", a.getId());
        tmp.put("nazwa", a.getNazwa());
        tmp.put("area", a.getArea());
        tmp.put("cube", a.getCube());
        tmp.put("heating", a.getHeating());
        tmp.put("light", a.getLight());
        return tmp;
    }

    public JSONObject getJSONPoziom(Poziom a){
        JSONObject tmp = new JSONObject();
        tmp.put("id", a.getId());
        tmp.put("nazwa", a.getNazwa());
        JSONArray jsonListaPomieszczen = new JSONArray();
        for(Pomieszczenie pomieszczenie : a.getListaPomieszczen()) {
            jsonListaPomieszczen.add(getJSONPomieszczenie(pomieszczenie));
        }
        tmp.put("lista pomieszczen", jsonListaPomieszczen);
        return tmp;
    }
    public JSONObject getJSONBudynek(Budynek a){
        JSONObject tmp = new JSONObject();
        tmp.put("id", a.getId());
        tmp.put("nazwa", a.getNazwa());
        JSONArray jsonListaPoziomow = new JSONArray();
        for(Poziom poziom : a.getListaPoziomow()) {
            jsonListaPoziomow.add(getJSONPoziom(poziom));
        }
        tmp.put("lista poziomow", jsonListaPoziomow);
        return tmp;
    }
}

