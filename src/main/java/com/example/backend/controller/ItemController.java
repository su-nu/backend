package com.example.backend.controller;


import com.example.backend.entity.Item;
import com.example.backend.request.ItemRequest;
import com.example.backend.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/item")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/create")
    public String create(@RequestBody ItemRequest itemRequest) {
        Item item = new Item(itemRequest.getPrice(),
                itemRequest.getName());
        return itemService.create(item);
    }

    @GetMapping("/get/{id}")
    public String findById(@PathVariable ("id") Long id) {
       return itemService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable ("id") Long id) {
        return itemService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public String deleteById(@PathVariable ("id") Long id, @RequestBody ItemRequest itemRequest) {
        return itemService.updateById(id, itemRequest);
    }


}
