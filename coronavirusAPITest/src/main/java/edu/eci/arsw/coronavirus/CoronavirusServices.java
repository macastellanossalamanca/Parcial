package edu.eci.arsw.coronavirus;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("citiesFinder")
public class CoronavirusServices {
    @Autowired
    HttpConnectionService http;

    @Autowired
    CoronavirusCache cache;

    public JsonNode citiesByName(String name) throws UnirestException {
        JsonNode res = cache.getByName(name);
        if(res != null){
            return res;
        }else{
            res = http.getByName(name);
            cache.add(name,res);
            return res;
        }
    }

    public JsonNode cities() throws UnirestException {
        JsonNode res = cache.getCities();
        if(!res.isEmpty()){
            return res;
        }else{
            res = http.getCities();
            cache.add(res);
            return res;
        }
    }

}
