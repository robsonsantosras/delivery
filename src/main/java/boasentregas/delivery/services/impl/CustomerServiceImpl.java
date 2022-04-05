package boasentregas.delivery.services.impl;

import boasentregas.delivery.models.Customer;
import boasentregas.delivery.services.CustomerService;
import boasentregas.security.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final HttpServletRequest httpServletRequest;

    @Autowired
    private RestTemplate restTemplate;

    private String FindCustomerId(){
        String token = httpServletRequest.getHeader("Authorization");
        token = token.substring(7);
        TokenService tokenService = new TokenService();
        return tokenService.getClientId(token);
    }

    public Customer FindCustomer()
    {
        String idcustomer = FindCustomerId();
        String url = "https://becustomer.azurewebsites.net/customer/v1/customers/" + idcustomer;
        Customer customer = restTemplate.getForObject(url, Customer.class);

        return customer;
    }
}
