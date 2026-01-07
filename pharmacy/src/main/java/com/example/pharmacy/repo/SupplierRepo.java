package com.example.pharmacy.repo;



import com.example.pharmacy.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
    public boolean existsByName(String name);

    public List<Supplier> findByName(String name);

    @Query("select max(s.supplierID) from Supplier s")
    public Integer findMaxId();
}
