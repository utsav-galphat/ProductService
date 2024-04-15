package org.utech.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.utech.productservice.services.CategoryService;

@RestController
public class CategoryController {

    final CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    public void saveCategory(){

    }
}
