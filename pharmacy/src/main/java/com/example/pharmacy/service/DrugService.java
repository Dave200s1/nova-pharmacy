package com.example.pharmacy.service;

import com.example.pharmacy.DrugRequestDTO;
import com.example.pharmacy.model.Category;
import com.example.pharmacy.model.Drug;
import com.example.pharmacy.model.Manufacturer;
import com.example.pharmacy.repo.CategoryRepo;
import com.example.pharmacy.repo.DrugRepo;
import com.example.pharmacy.repo.ManufacturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DrugService {
    @Autowired
    private DrugRepo dRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ManufacturerRepo manufacturerRepo;
    @Transactional
    public String createDrug(DrugRequestDTO drugDTO) {
        try {
            // Check if drug already exists
            if (dRepo.existsByName(drugDTO.getName())) {
                return "Drug already exists in the database.";
            }

            // Create a new Drug entity
            Drug drug = new Drug();
            drug.setName(drugDTO.getName());
            drug.setVerkaufspreis(drugDTO.getVerkaufspreis());
            drug.setDosis(drugDTO.getDosis());

            // Set the Category by fetching it from the database
            if (drugDTO.getCategoryId() != null) {
                Category category = categoryRepo.findById(drugDTO.getCategoryId())
                        .orElseThrow(() -> new RuntimeException("Category not found with id: " + drugDTO.getCategoryId()));
                drug.setCategoryId(category);
            }

            // Set the Manufacturer by fetching it from the database
            if (drugDTO.getCompanyId() != null) {
                Manufacturer manufacturer = manufacturerRepo.findById(drugDTO.getCompanyId())
                        .orElseThrow(() -> new RuntimeException("Manufacturer not found with id: " + drugDTO.getCompanyId()));
                drug.setCompanyId(manufacturer);
            }


            Integer maxId = dRepo.findMaxId();
            drug.setDrugID(maxId == null ? 0 : maxId + 1);


            dRepo.save(drug);
            return "Drug record created successfully.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating drug: " + e.getMessage();
        }
    }


    public List<Drug> readDrug(){return dRepo.findAll();}

    @Transactional
    public String updateDrug(Drug drug){
        if (dRepo.existsByName(drug.getName())){
            try {
                List<Drug> drugs = dRepo.findByName(drug.getName());
                drugs.stream().forEach(d -> {
                    Drug drugToBeUpdated = dRepo.findById(d.getDrugID()).get();
                    drugToBeUpdated.setName(drug.getName());
                    drugToBeUpdated.setVerkaufspreis(drug.getVerkaufspreis());
                    drugToBeUpdated.setDosis(drug.getDosis());
                    dRepo.save(drugToBeUpdated);
                });
                return "Drug record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Drug does not exists in the database.";
        }
    }

    @Transactional
    public String deleteDrug(String name){
        List<Drug> d = dRepo.findByName(name);
        if(d.isEmpty()){
            return "Drug not found: " + name;
        }else{
            dRepo.deleteAll(d);
            return "Drug deleted:" + name;
        }
    }
}
