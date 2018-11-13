package com.itemList.itemapi.repository;

import com.itemList.itemapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
