package com.example.pharmacy.service;

import com.example.pharmacy.model.Manufacturer;
import com.example.pharmacy.model.Supplier;
import com.example.pharmacy.repo.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class SupplierService {
    @Autowired
    private SupplierRepo sRepo;

    @Transactional
    public String createSupplier(Supplier supplier){
        try {
            if (!sRepo.existsByName(supplier.getName())){
                supplier.setSupplierID(null == sRepo.findMaxId()? 0 : sRepo.findMaxId() + 1);
                sRepo.save(supplier);
                return "Supplier record created successfully.";
            }else {
                return "Supplier already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Supplier> readSuppler(){
        return sRepo.findAll();
    }

    @Transactional
    public String updateSupplier(Supplier supplier){
        if (sRepo.existsByName(supplier.getName())){
            try {
                List<Supplier> suppliers = sRepo.findByName(supplier.getName());
                suppliers.stream().forEach(s -> {
                    Supplier supplierToBeUpdate = sRepo.findById(s.getSupplierID()).get();
                    supplierToBeUpdate.setName(supplier.getName());
                    supplierToBeUpdate.setAdress(supplier.getAdress());
                    supplierToBeUpdate.setCityCode(supplier.getCityCode());
                    supplierToBeUpdate.setActive(supplier.isActive());
                    supplierToBeUpdate.setTel(supplier.getTel());
                    supplierToBeUpdate.setDeliveryInDays(supplier.getDeliveryInDays());
                    sRepo.save(supplierToBeUpdate);
                });
                return "Supplier record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Supplier does not exists in the database.";
        }

    }

    @Transactional
    public String deleteSupplier(String name){
        List<Supplier> s = sRepo.findByName(name);
        if(s.isEmpty()){
            return "Supplier not found: " + name;
        }else{
            sRepo.deleteAll(s);
            return "Supplier deleted: " + name;
        }
    }
}
