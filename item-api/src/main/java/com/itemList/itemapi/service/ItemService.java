package com.itemList.itemapi.service;

import com.itemList.itemapi.model.Item;
import com.itemList.itemapi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public Item findById(Long id){
        return itemRepository.findById(id).get();
    }

    @Transactional(readOnly = false)
    public Item save(String name, Integer amount, Long userId, Long storeId, Long categoryId){
        return itemRepository.save(Item.newItem(name, amount, userId, storeId, categoryId));
    }

    @Transactional(readOnly = false)
    public void delete(Long id){
        Item item = this.findById(id);
        item.setEnabled(false);
        itemRepository.save(item);
    }
}
