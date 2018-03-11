package com.bytewheels.inventory.repository;

import com.bytewheels.inventory.dao.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
