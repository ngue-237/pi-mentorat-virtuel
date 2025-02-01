package com.logonedigital.pi_mentorat_virtuel.Controller;

import com.logonedigital.pi_mentorat_virtuel.Service.Category.CategoryServiceImpl;
import com.logonedigital.pi_mentorat_virtuel.entities.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("api/v1/category/add")
    public ResponseEntity<Category> addCategory(@RequestBody @Valid Category category){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.categoryService.addCategory(category));

    }


    @GetMapping(path ="api/v1/category/get_by_id/{idCategory}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long idCategory){
        return ResponseEntity
                .status(200)
                .body(this.categoryService.getCategoryByid(idCategory));
    }
}
