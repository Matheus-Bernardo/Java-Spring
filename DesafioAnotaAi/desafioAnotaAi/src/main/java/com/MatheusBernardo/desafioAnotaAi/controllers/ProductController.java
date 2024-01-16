package com.MatheusBernardo.desafioAnotaAi.controllers;

import com.MatheusBernardo.desafioAnotaAi.domain.product.Product;
import com.MatheusBernardo.desafioAnotaAi.domain.product.ProductDTO;
import com.MatheusBernardo.desafioAnotaAi.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/api/product")
public class ProductController {

    private ProductService service;
    public ProductController(ProductService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productsData){
        Product newProduct= this.service.insert(productsData);
        return ResponseEntity.ok().body(newProduct);

    }
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = this.service.getAll();
        return ResponseEntity.ok().body(products);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDTO productData){
        Product updateProduct= this.service.update(id,productData);
        return ResponseEntity.ok().body(updateProduct);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
