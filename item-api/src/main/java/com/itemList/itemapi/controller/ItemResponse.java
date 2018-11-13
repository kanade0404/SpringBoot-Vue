package com.itemList.itemapi.controller;

import com.itemList.itemapi.model.Item;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ItemResponse {
    private List<Item> items;
}
