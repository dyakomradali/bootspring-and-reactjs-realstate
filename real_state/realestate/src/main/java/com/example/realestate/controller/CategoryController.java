package com.example.realestate.controller;

import com.example.realestate.model.Category;
import com.example.realestate.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> showAll() {
        return categoryService.getAll();
    }

    @PostMapping("/add")
    public void save(@RequestBody Category category) {
        categoryService.create(category);
    }

    @GetMapping("/getById")
    public Category show(@RequestParam int id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/deleteAllCategories")
    public void deleteAll() {
        categoryService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
    }

    @GetMapping("/getAllPaginated")
    public Page<Category> getAllPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return categoryService.getAllPaginated(pageable);
    }
}
