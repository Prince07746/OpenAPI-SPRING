package org.openapi.openapispring.Model;


import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

@Schema(description = "Product entity with ID, name, price, and stock")
public class Product {

    @Schema(description = "Product ID", example = "123-ABC")
    private ProductId id;

    @Schema(description = "Product name", example = "Smartphone")
    private String name;

    @Schema(description = "Product price", example = "699.99")
    private double price;

    public Product(String id, String name, double price) {
        this.id = new ProductId(id);
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public ProductId getId() { return id; }
    public void setId(ProductId id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
