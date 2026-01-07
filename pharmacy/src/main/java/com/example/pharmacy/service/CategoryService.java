package com.example.pharmacy.service;


import com.example.pharmacy.model.Category;
import com.example.pharmacy.model.Manufacturer;
import com.example.pharmacy.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo cRepo;


    @Transactional
    public String createCategory(Category category){
        try {
            if (!cRepo.existsByName(category.getName())){
                category.setCategoryId(null == cRepo.findMaxId()? 0 : cRepo.findMaxId() + 1);
                cRepo.save(category);
                return "Category record created successfully.";
            }else {
                return "Category already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Category> readCategory(){
        return cRepo.findAll();
    }

    @Transactional
    public String updateCategory(Category category){
        if (cRepo.existsByName(category.getName())){
            try {
                List<Category> categories = cRepo.findByName(category.getName());
                categories.stream().forEach(s -> {
                    Category categoryToBeUpdated = cRepo.findById(s.getCategoryId()).get();
                    categoryToBeUpdated.setName(category.getName());
                    categoryToBeUpdated.setDescription(category.getDescription());
                    cRepo.save(categoryToBeUpdated);
                });
                return "Category record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Category does not exists in the database.";
        }
    }

    @Transactional
    public String deleteCategory(String name){
        List<Category> c = cRepo.findByName(name);
        if(c.isEmpty()){
            return "Category not found: " + name;
        }else{
            cRepo.deleteAll(c);
            return "Category deleted:" + name;
        }
    }
}
