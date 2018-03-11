package com.bytewheels.inventory.converter;

import com.bytewheels.inventory.dao.Item;
import com.bytewheels.inventory.dto.ItemDetails;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component(value = "itemDetailsConverter")
public class ItemDetailsConverter implements Converter<Item, ItemDetails> {

    @Override
    public ItemDetails convert(Item item) {
        ItemDetails itemDetails = null;
        itemDetails = new ItemDetails();
        itemDetails.setCarName(item.getName());
        itemDetails.setCarDescription(item.getDescription());
        itemDetails.setCarPrice(item.getPrice() != null ? item.getPrice() : item.getItemCategory().getPrice());
        itemDetails.setItemId(item.getId());
        itemDetails.setCarCategory(item.getItemCategory().getName());
        return itemDetails;
    }
}
