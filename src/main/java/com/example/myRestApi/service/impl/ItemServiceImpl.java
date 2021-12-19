package com.example.myRestApi.service.impl;

import com.example.myRestApi.controller.request.AddItemRequest;
import com.example.myRestApi.controller.response.ItemResponse;
import com.example.myRestApi.exception.ItemNotFoundException;
import com.example.myRestApi.mapper.impl.ItemMapperImpl;
import com.example.myRestApi.model.Item;
import com.example.myRestApi.repository.ItemRepository;
import com.example.myRestApi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {
    static final String ITEM_NOT_FOUND_EXCEPTION_MESSAGE = "Item not found!";

    private final ItemRepository itemRepository;
    private final ItemMapperImpl itemMapper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapperImpl itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public void saveItem(AddItemRequest request) {
        Item newItem = itemMapper.mapRequestToEntity(request);
        itemRepository.save(newItem);
    }

    @Override
    public ItemResponse findByUUID(UUID uuid) {
        ItemResponse itemResponse = itemRepository.findByUuidEquals(uuid)
                .map(itemMapper::mapEntityToResponse)
                .orElseThrow(() -> new ItemNotFoundException(ITEM_NOT_FOUND_EXCEPTION_MESSAGE));
        return itemResponse;
    }

}
