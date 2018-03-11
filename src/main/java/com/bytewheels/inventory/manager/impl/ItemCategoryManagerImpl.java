package com.bytewheels.inventory.manager.impl;

import com.bytewheels.common.dao.ModificationMetaData;
import com.bytewheels.common.utility.DAOUtility;
import com.bytewheels.inventory.constant.InventoryErrorCodes;
import com.bytewheels.inventory.dao.ItemCategory;
import com.bytewheels.inventory.exceptions.InventoryServiceException;
import com.bytewheels.inventory.exceptions.ItemCategoryNotFoundException;
import com.bytewheels.inventory.manager.ItemCategoryManager;
import com.bytewheels.inventory.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Component
public class ItemCategoryManagerImpl implements ItemCategoryManager {

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategory> getAllCategories(){
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory createItemCategory(ItemCategory itemCategory) throws InventoryServiceException {
        itemCategory.setId(DAOUtility.getUUID());
        itemCategory.setModificationMetaData(DAOUtility.getCurrentModificationData());
        try {
            itemCategory = itemCategoryRepository.save(itemCategory);
        } catch (DataIntegrityViolationException exception) {
            throw new InventoryServiceException(InventoryErrorCodes.INVENTORY_NOT_FOUND.name(),
                    InventoryErrorCodes.INVENTORY_ALREADY_AVAILABLE.getMessage());
        }
        return itemCategory;
    }

    @Override
    public void updateItemCategory(ItemCategory itemCategory) throws InventoryServiceException {
        try{
            ItemCategory oldItemCategory = itemCategoryRepository.findById(itemCategory.getId()).get();
            ModificationMetaData oldModificationMetadata = oldItemCategory.getModificationMetaData();
            itemCategory.setModificationMetaData(DAOUtility.changeUpdateDate(oldModificationMetadata));
            if(StringUtils.isEmpty(itemCategory.getName())){
                itemCategory.setName(oldItemCategory.getName());
            }
            if(itemCategory.getPrice() == null){
                itemCategory.setPrice(oldItemCategory.getPrice());
            }
            itemCategoryRepository.save(itemCategory);
        }catch (DataIntegrityViolationException exception) {
            throw new InventoryServiceException(InventoryErrorCodes.INVENTORY_NOT_FOUND.name(),
                    InventoryErrorCodes.UNABLE_TO_UPDATE_INVENTORY.getMessage());
        }
    }

    public ItemCategory getItemCategory(String itemCategoryId) {
        Optional<ItemCategory> itemCategory = itemCategoryRepository.findById(itemCategoryId);
        return itemCategory.get();
    }

    @Override
    public void removeItemCategory(String itemCategoryId) {
        itemCategoryRepository.deleteById(itemCategoryId);
    }
}
