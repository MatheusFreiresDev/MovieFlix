package com.movieflix.Controller;

import com.movieflix.Controller.Request.CategoryRequest;
import com.movieflix.Controller.Response.CategoryResponse;
import com.movieflix.Entity.Category;
import com.movieflix.Mapper.CategoryMapper;
import com.movieflix.Repository.CategoryRepository;
import com.movieflix.Service.CategoryService;
import jakarta.validation.Valid;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")

public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> categories () {
        List<Category> categories = categoryService.listCategorys();
        return ResponseEntity.ok( categories.stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList());

    }
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest category) {
    Category category1 = categoryService.create(CategoryMapper.toCategory(category));
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(category1));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> categoryId (@PathVariable Long id) {
        Category optionalCategory =  categoryService.category(id);
            if(optionalCategory != null) {
                return ResponseEntity.status(HttpStatus.FOUND) .body(
                        CategoryMapper.toCategoryResponse( optionalCategory));
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id ) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
