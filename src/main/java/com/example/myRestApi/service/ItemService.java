package com.example.myRestApi.service;

import com.example.myRestApi.controller.request.AddItemRequest;
import com.example.myRestApi.controller.response.ItemResponse;

import java.util.UUID;

public interface ItemService {

    void saveItem(AddItemRequest request);

    ItemResponse findByUUID(UUID uuid);
}
