package keven.springframework.msscbreweryclient.web.client;

import keven.springframework.msscbreweryclient.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BreweryCLientTest {

    @Autowired
    BreweryCLient client;

    @Test
    void testGetBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
        log.info("dto is {}", dto);

    }

    @Test
    void testSaveNewBeer() {

        BeerDto beerDto = BeerDto.builder().beerName("New beer").build();
        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
        log.info("uri is {}", uri);
        //System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer(){

        BeerDto beerDto = BeerDto.builder().beerName("New beer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
        log.info("testUpdateBeer is passed");
    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
        log.info("TesteDeleteBeer is passed");
    }


}