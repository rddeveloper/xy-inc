package com.zup.apitestedesenvolvedor3.repository;

import com.zup.apitestedesenvolvedor3.model.Product;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Order(1)
    public void testProductSave() {
        Product product = new Product(null, "PRODUCT TEST1", "PRODUCT TESTING JUNIT", new BigDecimal(20), "TEST");
        Product response = productRepository.save(product);
        assertNotNull(response);
    }

    @Test
    @Order(2)
    public void testProductListAll() {
        List<Product> response = productRepository.findAll();
        assertFalse(response.isEmpty());
    }

    @Test
    @Order(3)
    public void testProductListById() {
        Optional<Product> response = productRepository.findById(1L);
        assertTrue(response.isPresent());
    }

//    @AfterAll
//    private void tearDown() {
//        productRepository.deleteAll();
//    }
}
