package jj.ubs.domain.infra;

import org.springframework.web.client.RestTemplate;

import jj.ubs.domain.Ubs;

public class UbsByCityRequest {

    public Ubs getNearestUbs(String city, String latitude, String longitude) {
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.postForEntity("http://api-ldc-hackathon.herokuapp.com/api/ubs/city/", request, responseType, uriVariables);

        restTemplate.getForObject("http://api-ldc-hackathon.herokuapp.com/api/ubs/city/", UbsResponse.class);
        return null;
    }

}
