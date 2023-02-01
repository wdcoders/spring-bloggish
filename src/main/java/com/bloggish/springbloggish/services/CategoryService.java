package com.bloggish.springbloggish.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggish.springbloggish.entities.Category;
import com.bloggish.springbloggish.exceptions.ResourceNotFoundException;
import com.bloggish.springbloggish.payloads.CategoryDto;
import com.bloggish.springbloggish.repositories.CategoryRepo;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    // create
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.dtoToCategory(categoryDto);
        Category saveCategory = this.categoryRepo.save(category);
        return this.categoryToDto(saveCategory);
    }

    // update
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());

        Category saveCategory = this.categoryRepo.save(category);
        return this.categoryToDto(saveCategory);
    }

    // delete
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
        this.categoryRepo.delete(category);
    }

    // get all
    public CategoryDto getCategoryById(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
        return this.categoryToDto(category);
    }

    // get all
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> uCategoryDtos = categories.stream().map(c -> this.categoryToDto(c))
                .collect(Collectors.toList());
        return uCategoryDtos;
    }

    // get single

    private Category dtoToCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        return category;
    }

    private CategoryDto categoryToDto(Category category) {
        CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }
}
