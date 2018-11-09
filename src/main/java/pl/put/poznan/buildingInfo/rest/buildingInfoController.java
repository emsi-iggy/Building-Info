package pl.put.poznan.buildingInfo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildingInfo.app.buildingInfoApplication;
import pl.put.poznan.buildingInfo.logic.Pomieszczenie;

@RestController
@RequestMapping("/{text}") //wpisz w przegladarke: localhost:8080/cokolwiek
public class buildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(pl.put.poznan.buildingInfo.rest.buildingInfoController.class);

    @RequestMapping(value="/pomieszczenie",method= RequestMethod.GET, produces = "application/json") // (wpisz w przegladarke: localhost:8080/cokolwiek/pomieszczenie)
    public String [] wyswietlWszystkiePomieszczenia(){
        String [] ListaWynikowa = new String[buildingInfoApplication.listaPomieszczen.size()];
        for(int i=0; i<buildingInfoApplication.listaPomieszczen.size(); i++) {
            ListaWynikowa[i] = "id: "+buildingInfoApplication.listaPomieszczen.get(i).getId() + ", nazwa: " +
                    buildingInfoApplication.listaPomieszczen.get(i).getNazwa();
        }
        return ListaWynikowa;
    }

    @RequestMapping(value="/pomieszczenie/{index}",method = RequestMethod.GET, produces = "application/json") // (wpisz w przegladarke: localhost:8080/cokolwiek/pomieszczenie/0)
    public String wyswietlKonkretnePomieszczenie(@PathVariable("index") int index) {
        return buildingInfoApplication.listaPomieszczen.get(index).toString();
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


