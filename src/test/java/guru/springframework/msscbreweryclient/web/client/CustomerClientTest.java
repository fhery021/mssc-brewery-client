package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    public void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    public void createCustomer() {
        CustomerDto dto = CustomerDto.builder().name("John Thompson").build();
        URI uri = client.saveNewCustomer(dto);

        System.out.println(uri);

        assertNotNull(uri);
    }

    @Test
    public void updateCustomer() {
        CustomerDto dto = CustomerDto.builder().name("John Thompson").build();
        client.updateCustomer(dto, UUID.randomUUID());
    }

    @Test
    public void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}
