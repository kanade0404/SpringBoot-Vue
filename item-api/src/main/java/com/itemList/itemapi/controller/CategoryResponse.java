package com.itemList.itemapi.controller;

import com.itemList.itemapi.model.Category;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CategoryResponse {
    private List<Category> categories;
}
