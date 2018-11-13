package com.itemList.itemapi.service;

import com.itemList.itemapi.model.Store;
import com.itemList.itemapi.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    public List<Store> findAll(){
        return storeRepository.findAll();
    }

    public Store findById(Long id){
        return storeRepository.findById(id).get();
    }

    @Transactional(readOnly = false)
    public Store save(String name){
        return storeRepository.save(Store.newStore(name));
    }

    @Transactional(readOnly = false)
    public void delete(Long id){
        Store store = this.findById(id);
        store.setEnabled(false);
        storeRepository.save(store);
    }
}
