package com.zup.apitestedesenvolvedor3.repository;

import com.zup.apitestedesenvolvedor3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
}
