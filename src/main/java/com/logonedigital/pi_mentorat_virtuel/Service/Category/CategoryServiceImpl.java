package com.logonedigital.pi_mentorat_virtuel.Service.Category;

import com.logonedigital.pi_mentorat_virtuel.entities.Category;
import com.logonedigital.pi_mentorat_virtuel.repository.CategoryRepo;

import java.util.List;
import java.util.Optional;

public class CategoryImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepo.save(category);

    }

    @Override
    public List<Category> getAllCategoryByid() {
        return this.categoryRepo.findAll();
    }

    @Override
    public Category getCategoryByid(Long id) {
        Optional<Category> category = this.categoryRepo.findById(id);
        if (category.isEmpty())
            throw new RessourceNotFoundException("Category not found");
        return category.get();

    }

    @Override
    public Category updateCategoryByid(Category newCategory, Long id) {
        Optional<Category> oldCategory = this.categoryRepo.findById(id);
        if (oldCategory.isEmpty())
            throw new RessourceNotFoundException("Category Not Found");
        return newCategory;
    }

    @Override
    public void deleteCategoryByid(Long id) {

    }
}
