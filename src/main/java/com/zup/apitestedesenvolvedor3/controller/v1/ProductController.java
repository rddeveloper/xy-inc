package com.zup.apitestedesenvolvedor3.controller.v1;

import com.zup.apitestedesenvolvedor3.dto.ProductDTO;
import com.zup.apitestedesenvolvedor3.model.Product;
import com.zup.apitestedesenvolvedor3.service.product.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "/api/v1/products")
@Tag(name = "Products")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation(description = "Endpoint to list all products", summary = "List all products")
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(new Product().convertEntityToDTOList(products), HttpStatus.OK);
    }

    @GetMapping(value="{id}")
    @Operation(description = "Endpoint to get products by id", summary = "Get product by id")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(new Product().convertEntityToDTO(product), HttpStatus.OK);
    }

    @PostMapping()
    @Operation(description = "Endpoint to create new product", summary = "Create new Product")
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO productDTO) {
        Product product = productService.save(new ProductDTO().convertDTOToEntity(productDTO));
        return new ResponseEntity<>(new Product().convertEntityToDTO(product), HttpStatus.CREATED);
    }

    @PutMapping(value="{id}")
    @Operation(description = "Endpoint to update product", summary = "Update Product")
    public ResponseEntity<ProductDTO> create(@PathVariable("id") Long id,
                                             @Valid @RequestBody ProductDTO productDTO) {
        Product product = productService.update(id, new ProductDTO().convertDTOToEntity(productDTO));
        return new ResponseEntity<>(new Product().convertEntityToDTO(product), HttpStatus.OK);
    }

    @DeleteMapping(value="{id}")
    @Operation(description = "Endpoint to delete product", summary = "Delete Product")
    public ResponseEntity<ProductDTO> create(@PathVariable("id") Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
