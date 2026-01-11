package com.example.pharmacy.controller;


import com.example.pharmacy.model.Manufacturer;
import com.example.pharmacy.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(){
        return "Welcome to the server";
    }

    @RequestMapping(value = "/api/manufacturer/create", method = RequestMethod.POST)
    public String createManufacturer(@RequestBody Manufacturer manufacturer){
        return manufacturerService.createManufacturer(manufacturer);
    }


    @RequestMapping(value = "/api/manufacturers/read", method = RequestMethod.GET)
    public List<Manufacturer> readManufacturers(){
        return manufacturerService.readManufactuerers();
    }

    @RequestMapping(value = "/api/manufacturers/update",method = RequestMethod.PUT)
    public String updateManufacturers(@RequestBody Manufacturer manufacturer){
        return manufacturerService.updateManufacturer(manufacturer);
    }


    @DeleteMapping(value = "/api/manufacturers/delete/{name}")
    public String deleteManufacturers(@PathVariable String name){
        return manufacturerService.deleteManufacturer(name);
    }
}
