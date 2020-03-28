package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

//@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class CustomerClient {

    private static final String CUSTOMER_PATH_V1 = "api/v1/customer/";

    @Value("${sfg.brewery.apihost}")
    private String apihost;

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    //get
    public CustomerDto getCustomerById(UUID customerID) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + customerID.toString(), CustomerDto.class);
    }

    //post
    public URI saveNewCustomer(CustomerDto dto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, dto);
    }

    //put
    public void updateCustomer(CustomerDto dto, UUID id) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + id.toString(), dto);
    }

    //delete
    public void deleteCustomer(UUID id) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + id.toString());
    }

}
