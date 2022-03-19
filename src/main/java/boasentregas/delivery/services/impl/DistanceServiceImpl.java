package boasentregas.delivery.services.impl;

import boasentregas.delivery.models.Distance;
import boasentregas.delivery.models.Addresses;
import boasentregas.delivery.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class DistanceServiceImpl implements DistanceService {

    @Autowired
    private RestTemplate restTemplate;

    public Distance Distance(Addresses addresses) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = "https://becalculate.azurewebsites.net/calculate/v1/distance";

        HttpEntity<Addresses> httpEntity = new HttpEntity<>(addresses, headers);

        return restTemplate.postForObject(url, httpEntity, Distance.class);

    }
}
