package com.bytewheels.inventory.service;

import com.bytewheels.inventory.dto.ItemDetails;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public interface ItemInventoryService {

    Map<String, Set<ItemDetails>> searchItemsByDateAvailablity(Date fromDate, Date toDate);
}
