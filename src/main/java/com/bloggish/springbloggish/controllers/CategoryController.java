package com.bloggish.springbloggish.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloggish.springbloggish.payloads.ApiResponse;
import com.bloggish.springbloggish.payloads.CategoryDto;
import com.bloggish.springbloggish.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // GET: ALL CATEGORY
    @GetMapping("")
    private ResponseEntity<List<CategoryDto>> getAllCategory() {
        List<CategoryDto> categoryDto = this.categoryService.getAllCategory();
        return ResponseEntity.ok(categoryDto);
    }

    // POST:: CREATE CATEGORY
    @PostMapping("")
    private ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto cDto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(cDto, HttpStatus.CREATED);
    }

    // PUT:: UDPATE CATEGORY
    @PutMapping("/{categoryId}")
    private ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
            @PathVariable Integer categoryId) {
        CategoryDto cDto = this.categoryService.updateCategory(categoryDto, categoryId);
        return ResponseEntity.ok(cDto);
    }

    // DELETE:: CATEGORY
    @DeleteMapping("/{categoryId}")
    private ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(new ApiResponse("Category delete successfully", true));
    }

    // GET: SINGLE CATEGORY
    @GetMapping("/{categoryId}")
    private ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId) {
        CategoryDto categoryDto = this.categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDto);
    }
}
