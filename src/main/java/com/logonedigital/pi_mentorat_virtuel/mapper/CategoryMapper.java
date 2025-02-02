package com.logonedigital.pi_mentorat_virtuel.mapper;

import com.logonedigital.pi_mentorat_virtuel.entities.Category;
import com.logonedigital.pi_mentorat_virtuel.entities.Ressource;

import java.sql.ResultSet;

public class CategoryMapper {
    public Category mapToCategory(ResultSet rs) {
        Category category = new Category();
        return category;
    }

    public void mapToResultSet(Category category, ResultSet rs) {

    }

}
