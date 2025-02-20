package com.example.demo.controller;

import com.example.demo.entity.Job;
import com.example.demo.entity.Category;
import com.example.demo.reponsitory.JobRepository;
import com.example.demo.reponsitory.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
	
	@Autowired
    private JobRepository jobRepository;
    
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{categoryId}/jobs")
    public List<Job> getJobsByCategory(@PathVariable Long categoryId) {
        return jobRepository.findByCategoryId(categoryId);
    }
}