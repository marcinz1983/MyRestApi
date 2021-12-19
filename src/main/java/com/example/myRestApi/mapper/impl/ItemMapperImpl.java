package com.example.myRestApi.mapper.impl;

import com.example.myRestApi.controller.request.AddItemRequest;
import com.example.myRestApi.controller.response.ItemResponse;
import com.example.myRestApi.mapper.ItemMapper;
import com.example.myRestApi.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapperImpl implements ItemMapper {
    @Override
    public Item mapRequestToEntity(AddItemRequest request) {
        return Item.builder()
                .withUuid(request.getUuid())
                .withName(request.getName())
                .build();
    }

    @Override
    public ItemResponse mapEntityToResponse(Item item) {
        return ItemResponse.builder()
                .withName(item.getName())
                .build();
    }
}
