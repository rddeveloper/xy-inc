package com.zup.apitestedesenvolvedor3.service.product;


import com.zup.apitestedesenvolvedor3.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    Product update(Long id, Product product);
    void delete(Long id);
}
