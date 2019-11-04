package GUI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class WebService {
    public void doget(String _url, String _sub, String _payload) {
        String url = "http://localhost:8080/Service?_url=" + _url + "&_sub=" + _sub + "&_payload=" + _payload;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(responseEntity.getBody().toString());
    }
}
