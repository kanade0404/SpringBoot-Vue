package com.itemList.itemapi.controller;

import com.itemList.itemapi.model.Category;
import com.itemList.itemapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/api/category")
    public ResponseEntity<CategoryResponse> findAll(){
        List<Category> categories = categoryService.findAll();
        CategoryResponse categoryResponse = CategoryResponse.builder().categories(categories).build();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }
    @PostMapping("/api/category")
    public ResponseEntity<HttpStatus> save(@RequestBody CategoryAddRequest request){
        categoryService.save(request.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("api/category/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
