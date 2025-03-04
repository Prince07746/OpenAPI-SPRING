package org.openapi.openapispring.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.openapi.openapispring.Model.Product;
import org.openapi.openapispring.Repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProductsByPriceRange(double minPrice, double maxPrice) {
        return productRepository.getAllProducts().stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public void applyDiscount(double discountPercentage) {
        productRepository.getAllProducts().forEach(product -> {
            double newPrice = product.getPrice() - (product.getPrice() * discountPercentage / 100);
            product.setPrice(newPrice);
        });
    }

    public Product findProductById(int id) {

        return productRepository.findById(id);
    }

    public int getProductCount() {
        return productRepository.getAllProducts().size();
    }

//    public List<Product> findProductsSortedByPrice(boolean ascending) {
//    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public void updateProduct(int id, Product product) {
        productRepository.updateProduct(id, product);
    }

    public void removeProduct(int id) {
        productRepository.removeProduct(id);
    }
}