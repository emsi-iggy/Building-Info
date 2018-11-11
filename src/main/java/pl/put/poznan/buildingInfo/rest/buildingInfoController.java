package pl.put.poznan.buildingInfo.rest;

import com.fasterxml.jackson.core.json.JsonReadContext;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.SocketUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildingInfo.app.buildingInfoApplication;
import pl.put.poznan.buildingInfo.logic.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/{text}") //wpisz w przegladarke: localhost:8080/wyswietl
public class buildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(pl.put.poznan.buildingInfo.rest.buildingInfoController.class);

    @RequestMapping(method= RequestMethod.POST, produces = "application/json", consumes = "application/json") // (wpisz w przegladarke: localhost:8080/cokolwiek/pomieszczenie)
    public String wyswietlWszystkiePomieszczenia(@PathVariable("text") String text,
                                                 @RequestBody(required=false) JSONObject obiekt){
        if(text.equals("dodaj")) {
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
        }
        else if(text.equals("wyswietl"))
        {
            //wyswietli wszywstkie budynki (wraz z poziomami i pomieszczeniami)
        }
        return "Nazwe tej metody trza zmienic ;)";
    }

    @RequestMapping(value="/{indeksBudynku}/{indeksPoziomu}/{indeksPomieszczenia}",method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public String wyswietlKonkretnePomieszczenie(@PathVariable("text") String text, @PathVariable("indeksBudynku") int indeksBudynku,
                                                 @PathVariable("indeksPoziomu") int indeksPoziomu,@PathVariable("indeksPomieszczenia") int indeksPomieszczenia) {
        //funkcja zwracajaca łączną powierzchnię budynku, poziomu lub pomieszczenia
        //to do
        return "jakis tutaj komentarz";
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


