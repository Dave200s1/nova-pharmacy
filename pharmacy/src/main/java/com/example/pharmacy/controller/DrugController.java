package com.example.pharmacy.controller;

import com.example.pharmacy.DrugRequestDTO;
import com.example.pharmacy.model.Drug;
import com.example.pharmacy.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DrugController {
    @Autowired
    private DrugService drugService;

    @RequestMapping(value = "/api/drugs/create", method = RequestMethod.POST)
    public String createDrug(@RequestBody DrugRequestDTO drugDTO){
        return drugService.createDrug(drugDTO);
    }

    @RequestMapping(value= "/api/drugs/read", method = RequestMethod.GET)
    public List<Drug> readDrug(){
        return drugService.readDrug();
    }

    @RequestMapping(value = "/api/drugs/update", method = RequestMethod.PUT)
    public String updateDrug(@RequestBody Drug drug){
        return drugService.updateDrug(drug);
    }

    @RequestMapping(value="/api/drugs/delete/{name}")
    public String deleteDrug(@PathVariable String name){
        return drugService.deleteDrug(name);
    }
}
