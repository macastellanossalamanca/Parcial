package edu.eci.arsw.coronavirus;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service("connection")
public class HttpConnectionService {

    public JsonNode getByName(String name) throws UnirestException {
        HHttpResponse<JsonNode> response = Unirest
                .get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats/by-text?text=+" + name)
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
                .asJson();
        return response.getBody();
    }

    public JsonNode getByName(String name) throws UnirestException {
        HHttpResponse<JsonNode> response = Unirest
                .get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats)
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
                .asJson();
        return response.getBody();
    }
}