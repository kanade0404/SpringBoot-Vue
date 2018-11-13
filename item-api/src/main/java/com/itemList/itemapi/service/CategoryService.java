package com.itemList.itemapi.service;

import com.itemList.itemapi.model.Category;
import com.itemList.itemapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).get();
    }

    @Transactional(readOnly = false)
    public Category save(String name){
        return categoryRepository.save(Category.newCategory(name));
    }

    @Transactional(readOnly = false)
    public void delete(Long id){
        Category category = this.findById(id);
        category.setEnabled(false);
        categoryRepository.save(category);
    }
}
