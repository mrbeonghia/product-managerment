package com.codegym.product.service.category;

import com.codegym.product.model.Category;
import com.codegym.product.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void delete(Long id) {

    }
}
