package jj.ubs.domain.infra;

import org.springframework.web.client.RestTemplate;

public class UbsByCityRequest {

    public Record getNearestUbs(String city, String latitude, String longitude) {
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.postForEntity("http://api-ldc-hackathon.herokuapp.com/api/ubs/city/", request, responseType, uriVariables);

        restTemplate.getForObject("http://api-ldc-hackathon.herokuapp.com/api/ubs/city/", UbsResponse.class);
        return null;
    }

}
