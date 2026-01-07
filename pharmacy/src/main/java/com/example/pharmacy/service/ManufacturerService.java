package com.example.pharmacy.service;
import com.example.pharmacy.model.Manufacturer;
import com.example.pharmacy.repo.ManufacturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepo mRepo;

    @Transactional
    public String createManufacturer(Manufacturer manufacturer){
        try {
            if (!mRepo.existsByName(manufacturer.getName())){
                manufacturer.setCompanyID(null == mRepo.findMaxId()? 0 : mRepo.findMaxId() + 1);
                mRepo.save(manufacturer);
                return "Manufacturer record created successfully.";
            }else {
                return "Manufacturer already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Manufacturer> readManufactuerers(){
        return mRepo.findAll();
    }

    @Transactional
    public String updateManufacturer(Manufacturer manufacturer){
        if (mRepo.existsByName(manufacturer.getName())){
            try {
                List<Manufacturer> students = mRepo.findByName(manufacturer.getName());
                students.stream().forEach(s -> {
                    Manufacturer studentToBeUpdate = mRepo.findById(s.getCompanyID()).get();
                    studentToBeUpdate.setName(manufacturer.getName());
                    studentToBeUpdate.setAdresse(manufacturer.getAdresse());
                    mRepo.save(studentToBeUpdate);
                });
                return "Manufacturer record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Manufacturer does not exists in the database.";
        }
    }


    @Transactional
    public String deleteManufacturer(String name){
        List<Manufacturer> m = mRepo.findByName(name);
        if(m.isEmpty()){
            return "Manufacturer not found: " + name;
        }else{
            mRepo.deleteAll(m);
            return "Manufacturer deleted:" + name;
        }
    }

}
