package com.movieflix.Service;

import com.movieflix.Entity.Category;
import com.movieflix.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> listCategorys() {
        return categoryRepository.findAll();
    }
    public Category create(Category category) {
            return categoryRepository.save(category);
    }

    public Category category(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
