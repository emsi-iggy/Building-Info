package pl.put.poznan.buildingInfo.rest;

import com.fasterxml.jackson.core.json.JsonReadContext;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.SocketUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildingInfo.logic.*;
import java.util.ArrayList;
import static org.junit.Assert.*;
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

    @RequestMapping(value="/{wyswietl}",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
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

    @RequestMapping(value="/{wyswietl}/{indeksBudynku}",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String wyswietlKonkretnyBudynek(@PathVariable("wyswietl") String wyswietl,@PathVariable("indeksBudynku") int indeksBudynku) {
        if(wyswietl.equals("powierzchnia")) {
            return "Powierzchnia budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = " + listaBudynkow.get(indeksBudynku).getArea();
        }

        else if(wyswietl.equals("kubatura")) {
            return "Kubatura budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = " + listaBudynkow.get(indeksBudynku).getCube();
        }
        else if(wyswietl.equals("moc")) { //moc oswietlenia
            return "Moc oświetlenia budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = " + listaBudynkow.get(indeksBudynku).getLight();
        }
        else { //zuzycie energii

        }
        return "Podano niepoprawną ścieżkę";
    }

    @RequestMapping(value="/{wyswietl}/{indeksBudynku}/{indeksPoziomu}",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String wyswietlKonkretnnyPoziom(@PathVariable("wyswietl") String wyswietl, @PathVariable("indeksBudynku") int indeksBudynku,
                                           @PathVariable("indeksPoziomu") int indeksPoziomu) {
        if(wyswietl.equals("powierzchnia")) {
            return "Powierzchnia poziomu " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                    + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                    + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getArea();
        }

        else if(wyswietl.equals("kubatura")) {
            return "Kubatura poziomu " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                    + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                    + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getCube();
        }
        else if(wyswietl.equals("moc")) { //moc oswietlenia
            return "Moc oświetlenia poziomu " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                    + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                    + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getLight();
        }
        else { //zuzycie energii

        }
        return "Podano niepoprawną ścieżkę";
    }

    @RequestMapping(value="/{wyswietl}/{indeksBudynku}/{indeksPoziomu}/{indeksPomieszczenia}",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String wyswietlKonkretnePomieszczenie(@PathVariable("wyswietl") String wyswietl,
                                                 @PathVariable("indeksBudynku") int indeksBudynku, @PathVariable("indeksPoziomu") int indeksPoziomu,
                                           @PathVariable("indeksPomieszczenia") int indeksPomieszczenia) {
        //funkcja zwracajaca łączną powierzchnię budynku, poziomu lub pomieszczenia
        if(wyswietl.equals("powierzchnia")) {
            return "Powierzchnia pomieszczenia " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getNazwa()
                   + " na poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                    + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                    + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getArea();
        }

        else if(wyswietl.equals("kubatura")) {
            return "Kubatura pomieszczenia " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getNazwa()
                    + " na poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                    + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                    + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getCube();
        }
        else if(wyswietl.equals("moc")) { //moc oswietlenia
            return "Moc oświetlenia pomieszczenia " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getNazwa()
                    + " na poziomie " + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getNazwa()
                    + " w budynku " + listaBudynkow.get(indeksBudynku).getNazwa() + " = "
                    + listaBudynkow.get(indeksBudynku).getListaPoziomow().get(indeksPoziomu).getListaPomieszczen().get(indeksPomieszczenia).getLight();
        }
        else { //zuzycie energii

        }
        return "Podano niepoprawną ścieżkę";
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


