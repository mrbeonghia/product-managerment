package com.codegym.product.formatter;



import com.codegym.product.model.Category;
import com.codegym.product.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CategoryFormatter implements Formatter<Category> {
    private ICategoryService categoryService;

    @Autowired
    public CategoryFormatter(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category parse(String text, Locale locale) {
        Category category = new Category();
        try {
            category = categoryService.findById(Long.parseLong(text));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId() + ", " + object.getName() + "]";
    }
}
