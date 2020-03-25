package edu.eci.arsw.coronavirus;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cities")
public class CoronavirusController {
    @Autowired
    CoronavirusServices coronavirusServices;

    @RequestMapping(path ="/{name}",method = RequestMethod.GET)
    public ResponseEntity<?> GetCasesByCountry(@PathVariable("name")String name){
        try {
            JsonNode res = coronavirusServices.citiesByName(name);
            return new ResponseEntity<>(res.toString(), HttpStatus.ACCEPTED);
        } catch (UnirestException e) {
            Logger.getLogger(CoronavirusController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path ="/",method = RequestMethod.GET)
    public ResponseEntity<?> GetCases(){
        try {
            List res = coronavirusServices.cities();
            for (JsonNode nodo : lista) {
                return new ResponseEntity<>(nodo.toString(), HttpStatus.ACCEPTED);
            }
        } catch (UnirestException e) {
            Logger.getLogger(CoronavirusController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
