package keven.springframework.msscbreweryclient.web.client;

import keven.springframework.msscbreweryclient.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerDto() {
        CustomerDto customerDto = customerClient.getCustomer(UUID.randomUUID());
        assertNotNull(customerDto);
        log.info("customerDto is {}", customerDto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("new Customer").build();
        URI uri = customerClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
        log.info("saveNewCustomer uri is {}", uri);
    }

    @Test
    void updateCustomerDto() {
        CustomerDto customerDto = CustomerDto.builder().name("new Customer").build();
        customerClient.updateCustomer(UUID.randomUUID(),customerDto);
        log.info("updateCustomerDto uri is done");
    }

    @Test
    void deleteCustomerDto() {
        customerClient.deleteCustomer(UUID.randomUUID());
        log.info("deleteCustomerDto uri is done");
    }
}