package com.MatheusBernardo.desafioAnotaAi.controllers;

import com.MatheusBernardo.desafioAnotaAi.domain.category.Category;
import com.MatheusBernardo.desafioAnotaAi.domain.category.CategoryDTO;
import com.MatheusBernardo.desafioAnotaAi.services.CategoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController()
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService service;

    public CategoryController(CategoryService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO catedoryData){
        Category newCategory= this.service.insert(catedoryData);
        return ResponseEntity.ok().body(newCategory);

    }
    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = this.service.getAll();
        return ResponseEntity.ok().body(categories);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") String id, @RequestBody CategoryDTO catedoryData){
        Category updateCategory= this.service.update(id,catedoryData);
        return ResponseEntity.ok().body(updateCategory);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
