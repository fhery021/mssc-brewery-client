package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);

    }

    @Test
    void saveNewBeer() {
        BeerDto dto = BeerDto.builder().beerName("Ursus").build();
        URI uri = client.saveNewBeer(dto);

        assertNotNull(uri);

        System.out.println(uri.toString());

    }

    @Test
    void updateBeer() {
        BeerDto dto = BeerDto.builder()
                .beerName("Ciuc")
                .build();
        UUID uuid = UUID.fromString("97fbe4e8-e492-4863-9959-1d14e2897d07");

        client.updateBeer(uuid, dto);
    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }
}
