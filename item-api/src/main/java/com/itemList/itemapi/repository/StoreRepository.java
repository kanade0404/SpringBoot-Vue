package com.itemList.itemapi.repository;

import com.itemList.itemapi.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
