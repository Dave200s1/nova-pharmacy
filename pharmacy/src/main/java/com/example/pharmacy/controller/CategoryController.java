package com.example.pharmacy.controller;

import com.example.pharmacy.model.Category;
import com.example.pharmacy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "api/categories/create",method = RequestMethod.POST)
    public String createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @RequestMapping(value = "/api/categories/read", method = RequestMethod.GET)
    public List<Category> readCategories(){
        return categoryService.readCategory();
    }

    @RequestMapping(value = "/api/categories/update", method = RequestMethod.PUT)
    public String updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping(value = "/api/categories/delete/{name}")
    public String deleteCategory(@PathVariable String name){
        return categoryService.deleteCategory(name);
    }
}
