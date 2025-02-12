package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.Service.Category.CategoryServiceImpl;
import com.logonedigital.pi_mentorat_virtuel.entities.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService){
        this.categoryService = categoryService;

    }
    @Operation
    @PostMapping(path = "api/v1/category/add")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description="lorsqu'une category existe déjà aved un id déjà utilisé"),
            @ApiResponse(responseCode = "201", description = "lorsqu'une category a bien été ajouté")
    })
    public ResponseEntity<Category> addCategory(@RequestBody @Valid Category category){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.categoryService.addCategory(category));

    }
    @GetMapping(path = "api/v1/category/get-all-categories")
    public ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.status(200)
                .body(this.categoryService.getAllCategoryByid());
    }


    @GetMapping(path ="api/v1/category/get_by_id/{idCategory}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long idCategory){
        return ResponseEntity
                .status(200)
                .body(this.categoryService.getCategoryByid(idCategory));
    }

    @PutMapping(path = "/category/update_category_by_id/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable Long id){
        return this.categoryService.updateCategoryByid(category,id);
    }
    @DeleteMapping(path = "/category/delete_category_by_id/{id}")
    public String deleteCategoryById(@PathVariable Long id){
        this.categoryService.deleteCategoryByid(id);
        return "category deleted successfully !";
    }

}
