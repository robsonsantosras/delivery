package boasentregas.delivery.services.impl;

import boasentregas.delivery.models.DistributionCenter;
import boasentregas.delivery.services.FindDistributionCenter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FindDistributionCenterImpl implements FindDistributionCenter {

    @Autowired
    private RestTemplate restTemplate;

    private static String domain = "https://bedistributioncenter.azurewebsites.net/distributioncenter/v1/distributioncenters/";


    public DistributionCenter find(int zipcode){
        String url = domain + zipcode;
        DistributionCenter distributionCenter = restTemplate.getForObject(url, DistributionCenter.class);

        return distributionCenter;
    }

    public DistributionCenter findName(String name){
        String url = domain + "name/" + name;
        DistributionCenter distributionCenter = restTemplate.getForObject(url, DistributionCenter.class);

        return distributionCenter;
    }

}

