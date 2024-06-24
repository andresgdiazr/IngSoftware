package com.api.fintech.Services;

import com.api.fintech.exceptions.ProductNotFoundException;
import com.api.fintech.Models.Product;
import com.api.fintech.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws Exception {
        // Implement validation (e.g., check for null values in required fields)
        if (product.getName() == null || product.getCodebar() == null) {
            throw new Exception("Required fields (name, codebar) cannot be null");
        }
        productRepository.save(product);
        return product;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Product product) throws ProductNotFoundException {
        // Check if product exists before updating
        Optional<Product> existingProduct = productRepository.findById(Long.valueOf(product.getId()));
        if (!existingProduct.isPresent()) {
            throw new ProductNotFoundException("Product not found with ID: " + product.getId());
        }

        // Update product details
        Product updatedProduct = existingProduct.get();
        updatedProduct.setName(product.getName());
        updatedProduct.setCodebar(product.getCodebar()); // Update with caution if codebar is not meant to be changed
        updatedProduct.setCategoryId(product.getCategoryId()); // Update category if applicable
        updatedProduct.setStatus(product.getStatus());

        return productRepository.save(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {
        // Check if product exists before deleting
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }

        productRepository.deleteById(id);
    }
}
