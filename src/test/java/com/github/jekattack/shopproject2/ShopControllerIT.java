package com.github.jekattack.shopproject2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShopControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void checkProducts() {
        Product product = new Product("Teddy");
        ResponseEntity<Void> postResponse = restTemplate.postForEntity("/shop/addProduct/Teddy", product, Void.class);

        Assertions.assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        ResponseEntity<Product[]> getResponse = restTemplate.getForEntity("/shop/getProducts", Product[].class);
        Assertions.assertThat(getResponse.getBody().length).isEqualTo(1);
        Assertions.assertThat(getResponse.getBody()[0].getName()).isEqualTo("Teddy");
    }

}