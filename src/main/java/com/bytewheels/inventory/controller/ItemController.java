package com.bytewheels.inventory.controller;

import com.bytewheels.common.controller.BaseController;
import com.bytewheels.common.exception.InvalidFieldException;
import com.bytewheels.common.utility.WebServiceEndPoints;
import com.bytewheels.inventory.dto.CreateItemRequest;
import com.bytewheels.inventory.dto.ItemData;
import com.bytewheels.inventory.dto.ItemDetails;
import com.bytewheels.inventory.exceptions.InventoryServiceException;
import com.bytewheels.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = WebServiceEndPoints.ITEM,method = RequestMethod.GET)
    public List<ItemData> getAllItems(){
       return itemService.getAllItems();
    }

    @RequestMapping(value = WebServiceEndPoints.ITEM+"/{itemId}", method = RequestMethod.GET)
    public ItemData getItem(@PathVariable("itemId") String itemId) throws InventoryServiceException {
        return itemService.getItem(itemId);
    }

    @RequestMapping(value = WebServiceEndPoints.ITEM,method = RequestMethod.POST)
    public ResponseEntity<ItemDetails> addItem(@RequestBody @Validated CreateItemRequest createItemRequest, BindingResult bindingResult) throws InvalidFieldException, InventoryServiceException {
        validRequest(bindingResult);
        ItemDetails itemDetails = itemService.createItem(createItemRequest);
        return new ResponseEntity<ItemDetails>(itemDetails, HttpStatus.CREATED);
    }

}
