package com.logonedigital.pi_mentorat_virtuel.Service.Category;

import com.logonedigital.pi_mentorat_virtuel.exception.RessourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.entities.Category;
import com.logonedigital.pi_mentorat_virtuel.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
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
    public Category updateCategoryByid(Category category, Long id) {
        Optional<Category> categoryOptional= this.categoryRepo.findById(id);
        if (categoryOptional.isEmpty())
            throw new RessourceNotFoundException("category not found");
        if (category.getEtat()!=null)
            categoryOptional.get().setEtat(category.getEtat());
        if (category.getUpdateAt()!=null)
            categoryOptional.get().setUpdateAt(category.getUpdateAt());

        return categoryOptional.get();

    }

    @Override
    public void deleteCategoryByid(Long id) {

        this.categoryRepo.delete(this.categoryRepo.findById(id)
                .orElseThrow(()->new RessourceNotFoundException("category not found")));
    }
}
