package com.example.realestate.controller;

import com.example.realestate.model.Property;
import com.example.realestate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
@CrossOrigin("*")

public class PropertyController {
    @Autowired
    PropertyService propertyService;
    @GetMapping("/getAll")
    public List<Property> showAll(){
        return propertyService.getAll();
    }

    @PostMapping("/addproperty")
    public void save(@RequestBody Property pro){
        propertyService.addProperty(pro);
    }

    @GetMapping("/showpropertybyid")
    public Property show(@RequestParam int id){
        return  propertyService.getbyid(id);
    }


    @DeleteMapping("/deleteAll")
    public void deleteall(){
        propertyService.deleteall();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        propertyService.deletepropertybyid(id);
    }

    @GetMapping("/search/{desc}")
    public List<Property> getDepartmentByDesc(@PathVariable String desc){
     return propertyService.getpropertybyname(desc);
    }
    @GetMapping("/getAllPaginated")
    public Page<Property> getAllPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return propertyService.getAllPaginated(pageable);
    }
    @GetMapping("/searchByDescription")
    public List<Property> searchPropertyByDescription(@RequestParam String desc) {
        return propertyService.getpropertybyname(desc);
    }

}
