package edu.eci.arsw.coronavirus;

import org.springframework.stereotype.Service;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import com.mashape.unirest.http.JsonNode;

@Service
public class CoronavirusCache {
    private ConcurrentHashMap<String, JsonNode> cities = new ConcurrentHashMap<>();

    public JsonNode getByName(String name){
        if(cities.containsKey(name)){
            return cities.get(name);
        }else{
            return null;
        }
    }
    public List getCities(String name){
        List lista = new List();
        Iterator it = cities.entrySet().iterator();
        while (it.hasNext()) {
            lista.append(it.next())
            it.remove();
        }
        return lista
    }

    public void add(String name, JsonNode data){
        Timer nuevo = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                cities.remove(name);
                nuevo.cancel();
            }
        };
        cities.put(name,data);
        nuevo.schedule(task, 300000, 1);
    }
}
