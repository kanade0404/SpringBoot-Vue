package com.itemList.itemapi.controller;

import com.itemList.itemapi.model.Item;
import com.itemList.itemapi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/api/item")
    public ResponseEntity<ItemResponse> findAll(){
        List<Item> items = itemService.findAll();
        ItemResponse itemResponse = ItemResponse.builder().items(items).build();
        return new ResponseEntity<>(itemResponse, HttpStatus.OK);
    }

    @PostMapping("/api/item")
    public ResponseEntity<HttpStatus> save(@RequestBody ItemAddRequest request, Long userId, Long storeId, Long categoryId){
        itemService.save(request.getName(), request.getAmount(), userId, storeId, categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/api/item/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        itemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
