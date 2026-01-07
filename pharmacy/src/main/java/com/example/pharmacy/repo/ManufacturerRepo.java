package com.example.pharmacy.repo;

import com.example.pharmacy.model.Manufacturer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import  java.util.List;

@Repository
public interface ManufacturerRepo extends JpaRepository<Manufacturer, Integer> {
    public boolean existsByName(String name);

    public List<Manufacturer> findByName(String name);

    @Query("select max(m.companyID) from Manufacturer m")
    public Integer findMaxId();

}
