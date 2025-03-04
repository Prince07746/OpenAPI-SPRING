package org.openapi.openapispring.Controller;

import org.openapi.openapispring.Model.Product;
import org.openapi.openapispring.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/product")
public class AppController {

    private final ProductService productService;

    public AppController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public Product getProduct(@PathVariable(name="id") int id){
      return productService.findProductById(id);
    }


    @PostMapping()
    public ResponseEntity<String> createNewProduct(@RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("product created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> upDateProduct(@RequestBody Product product,@PathVariable(name="id") int id){

        if(productService.findProductById(id) != null){
            productService.updateProduct(id,product);
            return ResponseEntity.ok("Product updated successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name="id") int id){

        if(productService.findProductById(id) != null){
            productService.removeProduct(id);
            return ResponseEntity.ok("Product deleted successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product to delete not found");
        }
    }




}
