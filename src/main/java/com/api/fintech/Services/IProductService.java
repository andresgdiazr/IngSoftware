package com.api.fintech.Services;

import com.api.fintech.exceptions.ProductNotFoundException;
import com.api.fintech.Models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProducts();

    Product createProduct(Product product) throws Exception;

    Product findProductById(Long id);

    Product updateProduct(Product product) throws ProductNotFoundException, Exception;

    void deleteProduct(Long id) throws ProductNotFoundException, Exception;
}
