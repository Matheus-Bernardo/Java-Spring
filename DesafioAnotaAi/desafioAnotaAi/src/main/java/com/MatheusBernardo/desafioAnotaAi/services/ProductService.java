package com.MatheusBernardo.desafioAnotaAi.services;

import com.MatheusBernardo.desafioAnotaAi.domain.category.Category;
import com.MatheusBernardo.desafioAnotaAi.domain.category.exceptions.CategoryNotFoundException;
import com.MatheusBernardo.desafioAnotaAi.domain.product.Product;
import com.MatheusBernardo.desafioAnotaAi.domain.product.ProductDTO;
import com.MatheusBernardo.desafioAnotaAi.domain.product.exceptions.ProductNotFoundException;
import com.MatheusBernardo.desafioAnotaAi.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {

    private CategoryService categoryService;
    private ProductRepository repository;
    public ProductService (CategoryService categoryService, ProductRepository productRepository){
        this.categoryService = categoryService;
        this.repository = productRepository;
    }
    public Product insert(ProductDTO productDTO){
        Category category = this.categoryService.getById(productDTO.categoryId())
                .orElseThrow(CategoryNotFoundException::new);

        Product newProduct = new Product (productDTO);
        newProduct.setCategory(category);
        this.repository.save(newProduct);
        return newProduct;
    }
    public List<Product> getAll(){
        return this.repository.findAll();
    }
    public Product update(String id, ProductDTO productData){

        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        if (productData.categoryId() != null){
            this.categoryService.getById(productData.categoryId())
                    .ifPresent(product::setCategory);
        }

        this.categoryService.getById(productData.categoryId()).ifPresent(product::setCategory);

        if(!productData.title().isEmpty()) product.setTitle(productData.title());
        if(!productData.description().isEmpty()) product.setDescription(productData.description());
        if(!(productData.price() == null)) product.setPrice(productData.price());
        this.repository.save(product);
        return product;
    }

    public void delete(String id){
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        this.repository.delete(product);
    }
}
