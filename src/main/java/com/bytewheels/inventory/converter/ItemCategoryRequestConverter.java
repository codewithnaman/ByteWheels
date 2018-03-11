package com.bytewheels.inventory.converter;

import com.bytewheels.inventory.dao.ItemCategory;
import com.bytewheels.inventory.dto.CreateItemCategoryRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("itemCategoryRequestConverter")
public class ItemCategoryRequestConverter implements Converter<CreateItemCategoryRequest, ItemCategory> {
    @Override
    public ItemCategory convert(CreateItemCategoryRequest source) {
        ItemCategory itemCategory = null;
        if (source instanceof CreateItemCategoryRequest) {
            itemCategory = new ItemCategory();
            itemCategory.setName(source.getName());
            itemCategory.setPrice(source.getPrice());
        }
        return itemCategory;
    }
}
