package com.zup.apitestedesenvolvedor3.service.product.impl;

import com.zup.apitestedesenvolvedor3.exception.BusinessException;
import com.zup.apitestedesenvolvedor3.model.Product;
import com.zup.apitestedesenvolvedor3.repository.ProductsRepository;
import com.zup.apitestedesenvolvedor3.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductsRepository productsRepository;

    public static final String PRODUCT_NOT_FOUND = "Product not found";

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Product findById(Long id) {
        return productsRepository.findById(id).orElseThrow(() -> new BusinessException(PRODUCT_NOT_FOUND));
    }

    public Product save(Product product) {
        return productsRepository.save(product);
    }

    public Product update(Long id, Product product) {
        Optional<Product> productOld = productsRepository.findById(id);
        if(productOld.isPresent()) {
            product.setId(productOld.get().getId());
            return productsRepository.save(product);
        }
        throw new BusinessException(PRODUCT_NOT_FOUND);
    }

    public void delete(Long id) {
        Optional<Product> product = productsRepository.findById(id);
        if(product.isPresent()) {
            productsRepository.deleteById(product.get().getId());
        } else {
            throw new BusinessException(PRODUCT_NOT_FOUND);
        }
    }

}
