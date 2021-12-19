package com.example.myRestApi.mapper;

import com.example.myRestApi.controller.request.AddItemRequest;
import com.example.myRestApi.controller.response.ItemResponse;
import com.example.myRestApi.model.Item;

public interface ItemMapper {

    Item mapRequestToEntity(AddItemRequest request);

    ItemResponse mapEntityToResponse(Item item);
}
