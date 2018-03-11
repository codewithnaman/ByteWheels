package com.bytewheels.inventory.repository;

import com.bytewheels.inventory.dao.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, String> {
}
