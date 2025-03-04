package org.openapi.openapispring.Repository;

import org.openapi.openapispring.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        // Predefined products
        products.add(new Product(1, "Laptop", 1200.0));
        products.add(new Product(2, "Phone", 800.0));
        products.add(new Product(3, "Tablet", 500.0));
    }


    public List<Product> getAllProducts() {
        return products;
    }


    public void addProduct(Product product) {
        products.add(product);
    }


    public void updateProduct(int id, Product updatedProduct) {
        Optional<Product> productOptional = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        productOptional.ifPresent(product -> {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
        });
    }


    public void removeProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }


    public Product findById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

}