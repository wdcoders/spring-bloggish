package com.bloggish.springbloggish.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloggish.springbloggish.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
