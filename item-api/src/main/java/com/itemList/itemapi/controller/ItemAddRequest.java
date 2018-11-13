package com.itemList.itemapi.controller;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemAddRequest {
    private String name;
    private Integer amount;
}
