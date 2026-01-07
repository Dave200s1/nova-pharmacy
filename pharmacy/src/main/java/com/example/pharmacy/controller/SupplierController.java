package com.example.pharmacy.controller;

import com.example.pharmacy.model.Supplier;
import com.example.pharmacy.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "/api/suppliers/create", method = RequestMethod.POST)
    public String createSupplier(@RequestBody Supplier supplier){
        return supplierService.createSupplier(supplier);
    }

    @RequestMapping(value = "/api/suppliers/all", method = RequestMethod.GET)
    public List<Supplier> readSuppliers(){
        return supplierService.readSuppler();
    }

    @RequestMapping(value = "/api/suppleirs/update", method = RequestMethod.PUT)
    public String updateSuppliers(@RequestBody Supplier supplier){
        return supplierService.updateSupplier(supplier);
    }

    @DeleteMapping(value = "/api/suppliers/delete/{name}")
    public String deleteSupplier(@PathVariable String name){
        return supplierService.deleteSupplier(name);
    }
}
