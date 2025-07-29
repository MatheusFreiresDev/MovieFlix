package com.movieflix.Mapper;

import com.movieflix.Controller.Request.CategoryRequest;
import com.movieflix.Controller.Response.CategoryResponse;
import com.movieflix.Entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toCategory(CategoryRequest categoryResponse) {
            return Category.builder()
                    .name(categoryResponse.name())
                    .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
