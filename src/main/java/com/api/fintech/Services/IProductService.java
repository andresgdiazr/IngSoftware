package com.api.fintech.Services;

import com.api.fintech.exceptions.ProductNotFoundException;
import com.api.fintech.Models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAllProducts();

    Product createProduct(Product product) throws Exception;

    Optional<Product> findProductById(Long id);

    Product updateProduct(Product product) throws ProductNotFoundException, Exception;

    void deleteProduct(Long id) throws ProductNotFoundException, Exception;
}
