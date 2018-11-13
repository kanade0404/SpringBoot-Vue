package com.itemList.itemapi.controller;

import com.itemList.itemapi.model.Store;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StoreResponse {
    private List<Store> stores;
}
