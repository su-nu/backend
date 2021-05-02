package com.example.backend.service;

import com.example.backend.entity.Item;
import com.example.backend.repository.ItemRepository;
import com.example.backend.request.ItemRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public String create(Item item) {
        itemRepository.save(item);
        return "create succeed";
    }

    public String findById(Long id) {
        Optional<Item> itemData = itemRepository.findById(id);
        if (itemData.isPresent()) {
            return itemData.get().getName();
        } else {
            return "get failed";
        }
    }

    public String deleteById(Long id) {
        try {
            itemRepository.deleteById(id);
            return "delete succeed";
        } catch (Exception e) {
            return "delete failed".concat(e.getMessage());
        }
    }

    public String updateById(Long id, ItemRequest itemRequest) {
        Optional<Item> itemData = itemRepository.findById(id);
        if (itemData.isPresent()) {
            Item item = itemData.get();
            item.setName(itemRequest.getName());
            item.setPrice(item.getPrice());
            item.setUpdatedAt(new Date());
            itemRepository.save(item);
            return "update succeed";
        } else {
            return "update failed";
        }
    }
}
