package com.bytewheels.inventory.converter;

import com.bytewheels.inventory.dao.ItemCategory;
import com.bytewheels.inventory.dto.UpdateItemCategoryRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component("updateItemRequestConverter")
public class UpdateItemCategoryRequestConverter implements Converter<UpdateItemCategoryRequest, ItemCategory>{
    @Override
    public ItemCategory convert(UpdateItemCategoryRequest source) {
        ItemCategory itemCategory = null;
        if(source instanceof UpdateItemCategoryRequest){
            itemCategory = new ItemCategory();
            itemCategory.setId(source.getId());
            if(source.getName() != null){
                itemCategory.setName(source.getName());
            }
            if(source.getPrice() != null){
                itemCategory.setPrice(source.getPrice());
            }
        }
        return itemCategory;
    }
}
