package boasentregas.delivery.services.impl;

import boasentregas.delivery.models.Distance;
import boasentregas.delivery.models.Addresses;
import boasentregas.delivery.services.DistanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;


@Service
@AllArgsConstructor
public class DistanceServiceImpl implements DistanceService {

    @Autowired
    private RestTemplate restTemplate;

    private final HttpServletRequest httpServletRequest;

    public Distance Distance(Addresses addresses) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String token = httpServletRequest.getHeader("Authorization");

        headers.add("Authorization",token);

        String url = "https://becalculate.azurewebsites.net/calculate/v1/distance";

        HttpEntity<Addresses> httpEntity = new HttpEntity<>(addresses, headers);

        return restTemplate.postForObject(url, httpEntity, Distance.class);

    }
}
