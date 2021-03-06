package pl.put.poznan.buildingInfo.rest;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildingInfo.logic.*;

import java.util.ArrayList;
import java.util.Date;

import static pl.put.poznan.buildingInfo.app.buildingInfoApplication.listaBudynkow;

@RestController //wpisz w przegladarke: localhost:8080/wyswietl
/**
 * class buildingInfoController is used to create requests for the browser to retrieve
 * the data from the application.
 */
public class buildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(pl.put.poznan.buildingInfo.rest.buildingInfoController.class);

    /**
     * In the future this method will add new Building object (where the data will be inserted as JSON Object)
     * but this method isn't implemented yet.
     * @param obiekt is the JSON Object which contains Building type data
     * @return will print the success message in the future
     */
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

    /**
     * This method doesn't do anything yet
     * @param wyswietl variable which doesn't represent anything yet
     * @return the same as above (nothing yet)
     */
    @RequestMapping(value="/w/{wyswietl}",method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
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

    /**
     * Method wyswietlKonkretnyBudynek displays the data for the whole building according to the path which consists of
     * constant 'w', parameter 'wyswietl' and parameter 'indeksBudynku'
     * @param wyswietl can be one of the following: 'powierzchnia','kubatura','moc','energia','mocPerPowierzchnia',
     *                 'energiaPerKubatura','dataRemontu','powierzchniaOkien','liczbaOkien'
     * @param indeksBudynku represents the id of the building existing in the application
     * @return the text representing the answer to the request consisting of 'wyswietl' (what to display - e.g.
     * 'powierzchnia' displays the area of the whole building) and 'indeksBudynku' which tells the
     * application from which building we want to get the data
     * Furthermore the application can display appropriate information according to the wrong path
     * e.g. 'Podano nieprawidłowy indeks budynku' which means 'Wrong value of the parameter indeksBudynku was given'
     */
    @RequestMapping(value="/w/{wyswietl}/{indeksBudynku}",method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
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
            } else if (wyswietl.equals("powierzchniaOkien")) {//laczna powierzchnia okien w budynku
                return "Łączna powierzchnia okien w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = " + listaBudynkow.get(indeksBudynku).getPowierzchniaOkien();
            } else if (wyswietl.equals("liczbaOkien")) {//laczna liczba okien w budynku
                return "Łączna liczba okien w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = " + listaBudynkow.get(indeksBudynku).getLiczbaOkien();
            }
        }
        else return "Podano nieprawidłowy indeks budynku";
        return "Podano niepoprawną ścieżkę dotyczącą wyświetlania danych (indeks budynku jest poprawny)";
    }

    /**
     * Method wyswietlKonkretnnyPoziom displays the data for the whole floor in the building according to the path
     * which consists of constant 'w', parameter 'wyswietl', parameter 'indeksBudynku' and parameter 'indeksPoziomu'
     * @param wyswietl can be one of the following: 'powierzchnia','kubatura','moc','energia','mocPerPowierzchnia',
     *                 'energiaPerKubatura','dataRemontu','powierzchniaOkien','liczbaOkien'
     * @param indeksBudynku represents the id of the building existing in the application
     * @param indeksPoziomu represents the id of the floor existing in the building given by 'indeksBudynku'
     * @return the text representing the answer to the request consisting of 'wyswietl' (what to display - e.g.
     * 'powierzchnia' displays the area of the whole floor in the building), 'indeksBudynku' which tells the
     * application from which building we want to get the data and 'indeksPoziomu' which tells from which floor
     * we want to get the data
     * Furthermore the application can display appropriate information according to the wrong path
     * e.g. 'Podano nieprawidłowy indeks budynku' which means 'Wrong value of the parameter indeksBudynku was given'
     */
    @RequestMapping(value="/w/{wyswietl}/{indeksBudynku}/{indeksPoziomu}",method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
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
            } else if (wyswietl.equals("powierzchniaOkien")) { //laczna powierzchnia okien w poziomie
                return "Łączna powierzchnia okien w poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getPowierzchniaOkien();
            } else if (wyswietl.equals("liczbaOkien")) { //laczna liczba okien w poziomie
                return "Łączna liczba okien w poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getLiczbaOkien();
            }
        }
        if(!czyJestIndeksBudynku) return "Podano nieprawidłowy indeks budynku";
        if(!czyJestIndeksPoziomu) return "Podano nieprawidłowy indeks poziomu (indeks budynku jest poprawny)";
        return "Podano niepoprawną ścieżkę dotyczącą wyświetlania danych (indeks budynku i indeks poziomu są poprawne)";
    }

    /**
     * Method wyswietlKonkretnePomieszczenie displays the data for the room in the building according to the path
     * which consists of constant 'w', parameter 'wyswietl', parameter 'indeksBudynku', parameter 'indeksPoziomu'
     * and parameter 'indeksPomieszczenia'
     * @param wyswietl can be one of the following: 'powierzchnia','kubatura','moc','energia','mocPerPowierzchnia',
     *                 'energiaPerKubatura','dataRemontu','powierzchniaOkien','liczbaOkien'
     * @param indeksBudynku represents the id of the building existing in the application
     * @param indeksPoziomu represents the id of the floor existing in the building given by 'indeksBudynku'
     * @param indeksPomieszczenia represents the id of the room existing in the building given by 'indeksBudynku'
     *                            and in the floor given by 'indeksPoziomu'
     * @return the text representing the answer to the request consisting of 'wyswietl' (what to display - e.g.
     * 'powierzchnia' displays the area of the whole floor in the building), 'indeksBudynku' which tells the
     * application from which building we want to get the data, 'indeksPoziomu' which tells from which floor
     * we want to get the data and 'indeksPomieszczenia' which tells from which room we want to get the data
     * Furthermore the application can display appropriate information according to the wrong path
     * e.g. 'Podano nieprawidłowy indeks budynku' which means 'Wrong value of the parameter indeksBudynku was given'
     */
    @RequestMapping(value="/w/{wyswietl}/{indeksBudynku}/{indeksPoziomu}/{indeksPomieszczenia}",method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
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
            } else if (wyswietl.equals("powierzchniaOkien")) { //laczna powierzchnia okien w pomieszczeniu
                return "Łączna powierzchnia okien w pomieszczeniu " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getNazwa()
                        + " na poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getPowierzchniaOkien();
            } else if (wyswietl.equals("liczbaOkien")) { //laczna liczba okien w pomieszczeniu
                return "Łączna liczba okien w pomieszczeniu " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getNazwa()
                        + " na poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                        + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                        + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getLiczbaOkien();
            }
        }
        if(!czyJestIndeksBudynku) return "Podano nieprawidłowy indeks budynku";
        if(!czyJestIndeksPoziomu) return "Podano nieprawidłowy indeks poziomu (indeks budynku jest poprawny)";
        if(!czyJestIndeksPomieszczenia) return "Podano nieprawidłowy indeks pomieszczenia (indeks budynku i indeks poziomu są poprawne)";
        return "Podano niepoprawną ścieżkę dotyczącą wyświetlania danych (indeks budynku, indeks poziomu i indeks pomieszczenia są poprawne)";
    }

    /**
     * Method wyswietlKonkretnePomieszczenie displays rooms exceeding the parameter 'limit' of the parameter 'sprawdz'
     * The path consists of constant 's', parameter 'sprawdz', parameter 'indeksBudynku' and parameter 'limit'
     * @param sprawdz can be one of the following: 'limitEnergiiCieplnej','limitMocyOswietleniowej'
     * @param indeksBudynku represents the id of the building existing in the application
     * @param limit is the value which rooms can exceed and then they are considered as return value
     * @return the rooms exceeding 'limit' of 'sprawdz' e.g. rooms that have more
     * energy consumption (sprawdz) than 5400 (limit)
     * All of the rooms are inside the building identified by 'indeksBudynku'
     * Furthermore the application can display appropriate information according to the wrong path
     * e.g. 'Podano nieprawidłowy indeks budynku' which means 'Wrong value of the parameter indeksBudynku was given'
     */
    @RequestMapping(value="/s/{sprawdz}/{indeksBudynku}/{limit}",method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public String wyswietlKonkretnePomieszczenie(@PathVariable("sprawdz") String sprawdz,
                                                 @PathVariable("indeksBudynku") int indeksBudynku,
                                                 @PathVariable("limit") double limit) {

        boolean czyJestIndeksBudynku = false;
        for(Budynek budynek : listaBudynkow) {
            if(budynek.getId()==indeksBudynku) {
                czyJestIndeksBudynku = true;
                break;
            }
        }



        if(czyJestIndeksBudynku) {
            // log the parameters
            logger.debug(sprawdz);
            logger.debug(Integer.toString(indeksBudynku));
            logger.debug(Double.toString(limit));

            //funkcja zwracajaca pomieszczenia
            if (sprawdz.equals("limitEnergiiCieplnej")) {
                ArrayList <Pomieszczenie> listaPomieszczen = listaBudynkow.get(indeksBudynku).getHeatingLimit(limit);
                String wynik;
                wynik = "Pomieszczenia, ktore przekracaja limit zuzycia energii cieplnej w budynku \"" + listaBudynkow.get(indeksBudynku).getNazwa() + "\":";

                for(Pomieszczenie pomieszczenie : listaPomieszczen) {
                    wynik += "\n\t" + pomieszczenie.getNazwa() + " - " + pomieszczenie.getHeatingPerCubicMeter();
                }
                return wynik;
            } else if (sprawdz.equals("limitMocyOswietleniowej")) {
                ArrayList <Pomieszczenie> listaPomieszczen = listaBudynkow.get(indeksBudynku).getLightLimit(limit);
                String wynik;
                wynik = "Pomieszczenia, ktore przekracaja limit mocy oswietleniowej w budynku \"" + listaBudynkow.get(indeksBudynku).getNazwa() + "\":";

                for(Pomieszczenie pomieszczenie : listaPomieszczen) {
                    wynik += "\n\t" + pomieszczenie.getNazwa() + " - " + pomieszczenie.getLightPerSquareMeter();
                }
                return wynik;
            } else if (sprawdz.equals("poziomWspolczynnikaNaswietlenia")) {
                ArrayList <Pomieszczenie> listaPomieszczen = listaBudynkow.get(indeksBudynku).getNaturalLightLimit(limit);
                String wynik;
                wynik = "Pomieszczenia, ktore nie osiagaja okreslonego poziomu wspolczynnika oswietlenia naturalnego w budynku \"" + listaBudynkow.get(indeksBudynku).getNazwa() + "\":";

                for(Pomieszczenie pomieszczenie : listaPomieszczen) {
                    wynik += "\n\t" + pomieszczenie.getNazwa() + " - " + pomieszczenie.getNaturalLight();
                }
                return wynik;

            }
        }
        else return "Podano nieprawidlowy indeks budynku";
        return "Podano niepoprawna sciezke dotyczaca wyswietlania danych (indeks budynku, indeks poziomu i indeks pomieszczenia sa poprawne)";
    }

    /**
     * Method wyswietlKonkretnePomieszczenieDoRemontu displays rooms exceeding the parameter 'year-month-day' limit of the parameter 'sprawdz'
     * The path consists of constant 's', parameter 'sprawdz', parameter 'indeksBudynku' and parameters 'rok', 'miesiac', 'dzien'
     * @param sprawdz can be one of the following: 'limitDatyRemontu'
     * @param indeksBudynku represents the id of the building existing in the application
     * @param rok is the year of given date limit
     * @param miesiac is the month of given date limit
     * @param dzien is the day of given date limit
     * @return the rooms exceeding limit of 'sprawdz' e.g. rooms that haven't been renovating (sprawdz) since given date 2005-06-20 (limit year-month-day)
     * All of the rooms are inside the building identified by 'indeksBudynku'
     * Furthermore the application can display appropriate information according to the wrong path
     * e.g. 'Podano nieprawidłowy indeks budynku' which means 'Wrong value of the parameter indeksBudynku was given'
     */
    @RequestMapping(value="/s/{sprawdz}/{indeksBudynku}/{rok}/{miesiac}/{dzien}",method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public String wyswietlKonkretnePomieszczenieLimitDaty(@PathVariable("sprawdz") String sprawdz,
                                                          @PathVariable("indeksBudynku") int indeksBudynku,
                                                          @PathVariable("rok") int rok,
                                                          @PathVariable("miesiac") int miesiac,
                                                          @PathVariable("dzien") int dzien) {

        boolean czyJestIndeksBudynku = false;
        for(Budynek budynek : listaBudynkow) {
            if(budynek.getId()==indeksBudynku) {
                czyJestIndeksBudynku = true;
                break;
            }
        }



        if(czyJestIndeksBudynku) {
            // log the parameters
            logger.debug(sprawdz);
            logger.debug(Integer.toString(indeksBudynku));
            logger.debug(Integer.toString(rok));
            logger.debug(Integer.toString(miesiac));
            logger.debug(Integer.toString(dzien));

            //funkcja zwracajaca pomieszczenia
            if (sprawdz.equals("limitDatyRemontu")) {
                Date limitDaty = new Date(rok - 1900, miesiac - 1, dzien);
                ArrayList <Pomieszczenie> listaPomieszczen = listaBudynkow.get(indeksBudynku).getDataRemontuLimit(limitDaty);
                String wynik;
                wynik = "Pomieszczenia, ktore nie zostaly remontowane od czasu " + limitDaty.toString() + " w budynku \"" + listaBudynkow.get(indeksBudynku).getNazwa() + "\":";

                for(Pomieszczenie pomieszczenie : listaPomieszczen) {
                    wynik += "\n\t" + pomieszczenie.getNazwa() + " - " + pomieszczenie.getDataRemontu();
                }
                return wynik;
            }
        }
        else return "Podano nieprawidlowy indeks budynku";
        return "Podano niepoprawna sciezke dotyczaca wyswietlania danych (indeks budynku jest poprawny)";
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


