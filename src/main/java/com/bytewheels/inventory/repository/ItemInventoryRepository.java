package com.bytewheels.inventory.repository;

import com.bytewheels.inventory.dao.ItemInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public interface ItemInventoryRepository extends JpaRepository<ItemInventory, String> {

    @Query("SELECT i FROM ItemInventory i WHERE i.item.id=:itemId " +
            "AND i.id NOT IN (SELECT itemInventory.id FROM Order WHERE from_date>=:fromDate OR to_date<=:toDate)")
    List<ItemInventory> findAvailableInventory(
            @Temporal(TemporalType.DATE) @Param("fromDate") Date fromDate, @Temporal(TemporalType.DATE) @Param("toDate") Date toDate, @Param("itemId") String itemId);


}
