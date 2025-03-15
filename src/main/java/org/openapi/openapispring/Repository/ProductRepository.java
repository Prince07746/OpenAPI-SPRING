package org.openapi.openapispring.Repository;

import org.openapi.openapispring.Model.ProductId;
import org.openapi.openapispring.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

public class ProductRepository {
    private static final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        // Predefined products
        products.add(new Product("1aa", "Laptop", 1200.0));
        products.add(new Product("2ab", "Phone", 800.0));
        products.add(new Product("3ac", "Tablet", 500.0));
    }

    public void addProduct(Product product) {
        products.add(product);
    }


    public void updateProduct(String id, Product updatedProduct) {
        Optional<Product> productOptional = products.stream()
                .filter(p -> p.getId().equals(new ProductId(id)))
                .findFirst();
        productOptional.ifPresent(product -> {
            product.setId(updatedProduct.getId());
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
        });
    }


    public void removeProduct(String id) {
        products.removeIf(product -> product.getId().equals(new ProductId(id)));
    }


    public Product findById(String id) {

        return products.stream()
                .filter(product -> product.getId().equals(new ProductId(id)))
                .findFirst().orElse(null);
    }


    public List<Product> getAllProducts() {
        return products;
    }



}