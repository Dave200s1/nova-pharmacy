package com.example.pharmacy.repo;

import com.example.pharmacy.model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrugRepo extends JpaRepository<Drug, Integer> {
    public boolean existsByName(String name);

    public List<Drug> findByName(String name);

    @Query("select max(d.drugID) from Drug d")
    public Integer findMaxId();

}
