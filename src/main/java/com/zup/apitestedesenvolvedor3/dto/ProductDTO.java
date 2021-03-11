package com.zup.apitestedesenvolvedor3.dto;

import com.zup.apitestedesenvolvedor3.model.Product;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductDTO {

    Long id;

    @NotBlank
    String name;

    @NotBlank
    String description;

    @NotNull
    BigDecimal price;

    @NotBlank
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

    public Product convertDTOToEntity(ProductDTO productDTO) {
        return new ModelMapper().map(productDTO, Product.class);
    }
}
