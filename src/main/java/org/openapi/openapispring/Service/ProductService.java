package org.openapi.openapispring.Service;

import java.util.List;

import org.openapi.openapispring.Model.ProductId;
import org.openapi.openapispring.Model.Product;
import org.openapi.openapispring.Repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product findProductById(String id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductList(){
        return productRepository.getAllProducts();
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public void updateProduct(String id, Product product) {
        productRepository.updateProduct(id, product);
    }

    public void removeProduct(String id) {
        productRepository.removeProduct(id);
    }
}