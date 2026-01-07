package com.example.pharmacy.repo;


import com.example.pharmacy.model.Category;
import com.example.pharmacy.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {

    public boolean existsByName(String name);

    public List<Category> findByName(String name);

    @Query("select max(c.categoryId) from Category c")
    public Integer findMaxId();
}
