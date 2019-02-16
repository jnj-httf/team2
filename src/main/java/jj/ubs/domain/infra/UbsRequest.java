package jj.ubs.domain.infra;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import jj.ubs.domain.UbsInvoker;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UbsRequest implements UbsInvoker {

    @Override
    public UbsResponse getUbs(int page) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://api-ldc-hackathon.herokuapp.com/api/ubs/" + page, UbsResponse.class);
    }

    @Override
    public UbsResponse getUbsByCity(String city, int page) {
        RestTemplate restTemplate = new RestTemplate();
        CityRequest request = new CityRequest();
        request.setCity(city);
        request.setPage(page);


        return restTemplate.postForObject("http://api-ldc-hackathon.herokuapp.com/api/ubs/city/", request, UbsResponse.class);
    }
}
