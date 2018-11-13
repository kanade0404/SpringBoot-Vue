package com.itemList.itemapi.controller;

import com.itemList.itemapi.model.Store;
import com.itemList.itemapi.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping("/api/store")
    public ResponseEntity<StoreResponse> findAll(){
        List<Store> stores = storeService.findAll();
        StoreResponse storeResponse = StoreResponse.builder().stores(stores).build();
        return new ResponseEntity<>(storeResponse, HttpStatus.OK);
    }
    @PostMapping("/api/store")
    public ResponseEntity<HttpStatus> save(@RequestBody StoreAddRequest request){
        storeService.save(request.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/store/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        storeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
