package com.bytewheels.inventory.controller;

import com.bytewheels.common.controller.BaseController;
import com.bytewheels.common.exception.InvalidFieldException;
import com.bytewheels.common.utility.WebServiceEndPoints;
import com.bytewheels.inventory.dto.InventorySearchRequestByDate;
import com.bytewheels.inventory.dto.ItemDetails;
import com.bytewheels.inventory.service.ItemInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
public class ItemInventoryController extends BaseController {

    @Autowired
    @Qualifier("fromToDateValidator")
    private Validator fromToDateValidator;

    @Autowired
    private ItemInventoryService itemInventoryService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(fromToDateValidator);
    }

    @RequestMapping(value = WebServiceEndPoints.INVENTORY_AVAILABILITY_BY_DATE, method = RequestMethod.POST)
    public Map<String, Set<ItemDetails>> getAvailableItems(@RequestBody @Validated InventorySearchRequestByDate
                                                       inventorySearchRequestByDate, BindingResult bindingResult) throws InvalidFieldException {
        validRequest(bindingResult);
        return itemInventoryService.searchItemsByDateAvailablity(inventorySearchRequestByDate.getFromDate()
                , inventorySearchRequestByDate.getToDate());
    }

}
