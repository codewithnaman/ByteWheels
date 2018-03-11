package com.bytewheels.inventory.manager.impl;

import com.bytewheels.common.utility.DAOUtility;
import com.bytewheels.inventory.constant.InventoryErrorCodes;
import com.bytewheels.inventory.dao.Item;
import com.bytewheels.inventory.dao.ItemCategory;
import com.bytewheels.inventory.exceptions.InventoryServiceException;
import com.bytewheels.inventory.manager.ItemManager;
import com.bytewheels.inventory.repository.ItemCategoryRepository;
import com.bytewheels.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemManagerImpl implements ItemManager {

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(String itemId) throws InventoryServiceException {
        Optional<Item> item = itemRepository.findById(itemId);
        if (!item.isPresent()) {
            throw new InventoryServiceException(InventoryErrorCodes.ITEM_NOT_FOUND.name(), InventoryErrorCodes.ITEM_NOT_FOUND.getMessage());
        }
        return item.get();
    }

    @Override
    public Item createItem(Item item, ItemCategory itemCategory) throws InventoryServiceException {
        try {
            item.setId(DAOUtility.getUUID());
            item.setItemCategory(itemCategory);
            item.setModificationMetaData(DAOUtility.getCurrentModificationData());
            item = itemRepository.save(item);
        } catch (DataIntegrityViolationException exception) {
            throw new InventoryServiceException(InventoryErrorCodes.UNABLE_TO_CREATE_ITEM.name(),
                    InventoryErrorCodes.UNABLE_TO_CREATE_ITEM.getMessage());
        }
        return item;
    }


}
