package pl.put.poznan.buildingInfo.rest;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildingInfo.logic.*;

import static pl.put.poznan.buildingInfo.app.buildingInfoApplication.listaBudynkow;

@RestController //wpisz w przegladarke: localhost:8080/wyswietl
public class buildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(pl.put.poznan.buildingInfo.rest.buildingInfoController.class);

    @RequestMapping(value="/dodaj",method= RequestMethod.POST, produces = "application/json", consumes = "application/json") // (wpisz w przegladarke: localhost:8080/cokolwiek/pomieszczenie)
    public String wyswietlWszystkiePomieszczenia(@RequestBody(required=false) JSONObject obiekt){
        if(obiekt.containsKey("Pomieszczenie")) {
            System.out.println(obiekt.toJSONString());
            //chcemy dodac pomieszczenie
            Object o = (String) obiekt.get("Pomieszczenie").toString().replaceAll("[{}]","");;
            String [] czesci =  o.toString().split("[,=]");

        }
        else if(obiekt.containsKey("Poziom")) {
            //chcemy dodac poziom
        }
        else if(obiekt.containsKey("Budynek")){
            //chcemy dodac budynek
        }

        return "";
    }

    @RequestMapping(value="/w/{wyswietl}",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String wyswietlWszystko(@PathVariable("wyswietl") String wyswietl) {
        if(wyswietl.equals("powierzchnia")) {

        }

        else if(wyswietl.equals("kubatura")) {

        }
        else if(wyswietl.equals("moc")) { //moc oswietlenia

        }
        else { //zuzycie energii

        }
        return "Na razie ta metoda nic nie robi";
    }

    @RequestMapping(value="/w/{wyswietl}/{indeksBudynku}",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String wyswietlKonkretnyBudynek(@PathVariable("wyswietl") String wyswietl,@PathVariable("indeksBudynku") int indeksBudynku) {
        boolean czyJestIndeksBudynku = false;
        for(Budynek budynek : listaBudynkow) {
            if(budynek.getId()==indeksBudynku) {
                czyJestIndeksBudynku = true;
                break;
            }
        }
        if(czyJestIndeksBudynku) {
            // log the parameters
            logger.debug(wyswietl);
            logger.debug(Integer.toString(indeksBudynku));

            if (wyswietl.equals("powierzchnia")) {
                return "Powierzchnia budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = " + listaBudynkow.get(indeksBudynku).getArea();
            } else if (wyswietl.equals("kubatura")) {
                return "Kubatura budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = " + listaBudynkow.get(indeksBudynku).getCube();
            } else if (wyswietl.equals("moc")) { //moc oswietlenia
                return "Moc oświetlenia budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = " + listaBudynkow.get(indeksBudynku).getLight();
            } else if (wyswietl.equals("energia")) {//zuzycie energii
                return "Zużycie energii na ogrzewanie budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = " + listaBudynkow.get(indeksBudynku).getHeating();
            } else if (wyswietl.equals("mocPerPowierzchnia")) { //moc oswietlenia / powierzchnia
                return "Moc oświetlenia w przeliczeniu na jednostkę powierzchni budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = " + listaBudynkow.get(indeksBudynku).getLightPerSquareMeter();
            } else if (wyswietl.equals("energiaPerKubatura")) {//zuzycie energii / kubatura
                return "Zużycie energii na ogrzewanie w przeliczeniu na jednostkę objętości dla budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = " + listaBudynkow.get(indeksBudynku).getHeatingPerCubicMeter();
            } else if (wyswietl.equals("dataRemontu")) {//data wykonania ostatniego remontu
                return "Data wykonania ostatniego remontu w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = " + listaBudynkow.get(indeksBudynku).getDataRemontu();
            }
        }
        else return "Podano nieprawidłowy indeks budynku";
        return "Podano niepoprawną ścieżkę dotyczącą wyświetlania danych (indeks budynku jest poprawny)";
    }





    @RequestMapping(value="/w/{wyswietl}/{indeksBudynku}/{indeksPoziomu}",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String wyswietlKonkretnnyPoziom(@PathVariable("wyswietl") String wyswietl, @PathVariable("indeksBudynku") int indeksBudynku,
                                           @PathVariable("indeksPoziomu") int indeksPoziomu) {

        boolean czyJestIndeksBudynku = false;
        boolean czyJestIndeksPoziomu = false;
        for(Budynek budynek : listaBudynkow) {
            if(budynek.getId()==indeksBudynku) {
                czyJestIndeksBudynku = true;
                for(Poziom poziom : listaBudynkow.get(indeksBudynku).getListaPoziomow()) {
                    if(poziom.getId()==indeksPoziomu) {
                        czyJestIndeksPoziomu = true;
                        break;
                    }
                }
                break;
            }
        }
        if(czyJestIndeksBudynku && czyJestIndeksPoziomu) {
            // log the parameters
            logger.debug(wyswietl);
            logger.debug(Integer.toString(indeksBudynku));
            logger.debug(Integer.toString(indeksPoziomu));

            if (wyswietl.equals("powierzchnia")) {
                return "Powierzchnia poziomu " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getArea();
            } else if (wyswietl.equals("kubatura")) {
                return "Kubatura poziomu " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getCube();
            } else if (wyswietl.equals("moc")) { //moc oswietlenia
                return "Moc oświetlenia poziomu " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getLight();
            } else if (wyswietl.equals("energia")) { //zuzycie energii
                return "Zużycie energii na ogrzewanie poziomu " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getHeating();
            } else if (wyswietl.equals("mocPerPowierzchnia")) { //moc oswietlenia / powierzchnia
                return "Moc oświetlenia w przeliczeniu na jednostkę powierzchni poziomu " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getLightPerSquareMeter();
            } else if (wyswietl.equals("energiaPerKubatura")) { //zuzycie energii / kubatura
                return "Zużycie energii na ogrzewanie w przeliczeniu na jednostkę objętości dla poziomu " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getHeatingPerCubicMeter();
            } else if (wyswietl.equals("dataRemontu")) { //data wykonania ostatniego remontu
                return "Data wykonania ostatniego remontu w poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getDataRemontu();
            }
        }
        if(!czyJestIndeksBudynku) return "Podano nieprawidłowy indeks budynku";
        if(!czyJestIndeksPoziomu) return "Podano nieprawidłowy indeks poziomu (indeks budynku jest poprawny)";
        return "Podano niepoprawną ścieżkę dotyczącą wyświetlania danych (indeks budynku i indeks poziomu są poprawne)";
    }

    @RequestMapping(value="/w/{wyswietl}/{indeksBudynku}/{indeksPoziomu}/{indeksPomieszczenia}",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String wyswietlKonkretnePomieszczenie(@PathVariable("wyswietl") String wyswietl,
                                                 @PathVariable("indeksBudynku") int indeksBudynku, @PathVariable("indeksPoziomu") int indeksPoziomu,
                                           @PathVariable("indeksPomieszczenia") int indeksPomieszczenia) {

        boolean czyJestIndeksBudynku = false;
        boolean czyJestIndeksPoziomu = false;
        boolean czyJestIndeksPomieszczenia = false;
        for(Budynek budynek : listaBudynkow) {
            if(budynek.getId()==indeksBudynku) {
                czyJestIndeksBudynku = true;
                for(Poziom poziom : listaBudynkow.get(indeksBudynku).getListaPoziomow()) {
                    if(poziom.getId()==indeksPoziomu) {
                        czyJestIndeksPoziomu = true;
                        for(Pomieszczenie pomieszczenie : listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen()) {
                            if(pomieszczenie.getId()==indeksPomieszczenia) {
                                czyJestIndeksPomieszczenia = true;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        if(czyJestIndeksBudynku && czyJestIndeksPoziomu && czyJestIndeksPomieszczenia) {
            // log the parameters
            logger.debug(wyswietl);
            logger.debug(Integer.toString(indeksBudynku));
            logger.debug(Integer.toString(indeksPoziomu));
            logger.debug(Integer.toString(indeksPomieszczenia));

            //funkcja zwracajaca łączną powierzchnię budynku, poziomu lub pomieszczenia
            if (wyswietl.equals("powierzchnia")) {
                return "Powierzchnia pomieszczenia " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getNazwa()
                        + " na poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getArea();
            } else if (wyswietl.equals("kubatura")) {
                return "Kubatura pomieszczenia " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getNazwa()
                        + " na poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getCube();
            } else if (wyswietl.equals("moc")) { //moc oswietlenia
                return "Moc oświetlenia pomieszczenia " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getNazwa()
                        + " na poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getLight();
            } else if (wyswietl.equals("energia")) { //zuzycie energii
                return "Zużycie energii na ogrzewanie pomieszczenia " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getNazwa()
                        + " na poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getHeating();
            } else if (wyswietl.equals("mocPerPowierzchnia")) { //moc oswietlenia / powierzchnia
                return "Moc oświetlenia w przeliczeniu na jednostkę powierzchni pomieszczenia " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getNazwa()
                        + " na poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getLightPerSquareMeter();
            } else if (wyswietl.equals("energiaPerKubatura")) { //zuzycie energii / kubatura
                return "Zużycie energii na ogrzewanie w przeliczeniu na jednostkę objętości dla pomieszczenia " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getNazwa()
                        + " na poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getHeatingPerCubicMeter();
            } else if (wyswietl.equals("dataRemontu")) { //data wykonania ostatniego remontu
                return "Data wykonania ostatniego remontu w pomieszczeniu " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getNazwa()
                        + " na poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getDataRemontu();
            }
        }
        if(!czyJestIndeksBudynku) return "Podano nieprawidłowy indeks budynku";
        if(!czyJestIndeksPoziomu) return "Podano nieprawidłowy indeks poziomu (indeks budynku jest poprawny)";
        if(!czyJestIndeksPomieszczenia) return "Podano nieprawidłowy indeks pomieszczenia (indeks budynku i indeks poziomu są poprawne)";
        return "Podano niepoprawną ścieżkę dotyczącą wyświetlania danych (indeks budynku, indeks poziomu i indeks pomieszczenia są poprawne)";
    }



    @RequestMapping(value="/s/{sprawdz}/{indeksBudynku}/{limit}",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String wyswietlKonkretnePomieszczenie(@PathVariable("sprawdz") String sprawdz,
                                                 @PathVariable("indeksBudynku") int indeksBudynku,
                                                 @PathVariable("limit") double limit) {

        boolean czyJestIndeksBudynku = false;
        boolean czyJestIndeksPoziomu = false;
        boolean czyJestIndeksPomieszczenia = false;
        for(Budynek budynek : listaBudynkow) {
            if(budynek.getId()==indeksBudynku) {
                czyJestIndeksBudynku = true;
                break;
            }
        }



        if(czyJestIndeksBudynku && czyJestIndeksPoziomu) {
                // log the parameters
                logger.debug(sprawdz);
                logger.debug(Integer.toString(indeksBudynku));
                logger.debug(Double.toString(limit));

                //funkcja zwracajaca pomieszczenia, które przekracaja limity
                if (sprawdz.equals("limitEnergiiCieplnej")) {
                    return "Pomieszczenia, ktore przekracaja limit zuzycia energii cieplnej w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + ": "
                     + listaBudynkow.get(indeksBudynku).getListaPoziomow().getHeatingLimit(limit);

                } else if (sprawdz.equals("limitMocyOswietleniowej")) {
                    return "Pomieszczenia, ktore przekracaja limit mocy oswietleniowej " + listaBudynkow.get(indeksBudynku).getNazwa() + ": "
                            + listaBudynkow.get(indeksBudynku).getListaPoziomow().getLightLimit(limit);
                }
        }
                if(!czyJestIndeksBudynku) return "Podano nieprawidlowy indeks budynku";
                return "Podano niepoprawna sciezke dotyczaca wyswietlania danych (indeks budynku, indeks poziomu i indeks pomieszczenia sa poprawne)";
    }

/* KOD Z TRASNFORMERA:
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // do the transformation, you should run your logic here, below just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // do the transformation, you should run your logic here, below just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }
*/


}


