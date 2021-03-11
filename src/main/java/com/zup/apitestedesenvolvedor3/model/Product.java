package com.zup.apitestedesenvolvedor3.model;

import com.zup.apitestedesenvolvedor3.dto.ProductDTO;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_ID_SEQ")
    @SequenceGenerator(name = "PRODUCT_ID_SEQ", sequenceName="PRODUCT_ID_SEQ", allocationSize = 1)
    Long id;

    @NotBlank
    @Column(name = "NAME")
    String name;

    @NotBlank
    @Column(name = "DS_PRODUCT")
    String description;

    @NotNull
    @Column(name = "PRICE", precision = 12, scale = 4)
    BigDecimal price;

    @NotBlank
    @Column(name = "CATEGORY")
    String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ProductDTO convertEntityToDTO(Product product) {
        return new ModelMapper().map(product, ProductDTO.class);
    }

    public List<ProductDTO> convertEntityToDTOList(List<Product> product) {
        return product.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

}