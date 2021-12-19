package com.example.myRestApi.controller.open;


import com.example.myRestApi.controller.request.AddItemRequest;
import com.example.myRestApi.controller.response.ItemResponse;
import com.example.myRestApi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("public/api/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/addItem")
    public ResponseEntity<Void> addItem(@Valid @RequestBody AddItemRequest request) {
        itemService.saveItem(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<ItemResponse> getItem(@PathVariable("uuid") UUID uuid) {
        ItemResponse itemById = itemService.findByUUID(uuid);
        return new ResponseEntity<>(itemById, HttpStatus.OK);
    }
}
