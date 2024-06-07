package com.example.realestate.service;


import com.example.realestate.model.Location;
import com.example.realestate.model.Property;
import com.example.realestate.repository.PropertyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropertyService {
    @Autowired
    PropertyRepository propertyRepository;

    public List<Property> getAll(){
        return propertyRepository.findAll();
    }

    public void addProperty(Property property){

        propertyRepository.save(property);
    }

    public Property getbyid(int id){
        return propertyRepository.findById(id).orElse(null);
    }

    public void deletepropertybyid(int id){
        propertyRepository.deleteById(id);
    }

    public void deleteall(){
        propertyRepository.deleteAll();
    }

    public Page<Property> getAllPaginated(Pageable pageable) {
        return propertyRepository.findAll(pageable);
    }

    @Transactional
    public  List<Property> getpropertybyname(String desc){
       return propertyRepository.getpropertybydescription(desc);
    }

}




