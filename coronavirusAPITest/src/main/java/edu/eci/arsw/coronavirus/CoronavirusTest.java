package edu.eci.arsw.coronavirus;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={CoronavirusApplication.class})
public class CoronavirusTest {

    @Autowired
    coronavirusServices afs;

    @Test
    public void shouldReturnAllCases() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest
                .get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
                .asJson();

        assertNotNull(response.getBody());
        assertEquals((int)HttpStatus.SC_OK,response.getStatus());
    }
}
