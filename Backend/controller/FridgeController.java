package com.end.fridge.controller;

import com.end.fridge.domain.Fridge;
import com.end.fridge.service.FridgeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fridge")
@CrossOrigin
public class FridgeController {
    @Autowired
    private FridgeService fridgeService;

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        Iterable<Fridge> fridges = fridgeService.list();
        return ResponseEntity.ok(fridges);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid Fridge fridge) {
        Fridge savedFridge = fridgeService.save(fridge);
        return ResponseEntity.ok(savedFridge);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<?> saveAll(@RequestBody List<@Valid Fridge> fridges) {
        Iterable<Fridge> savedFridges = fridgeService.saveAll(fridges);
        return ResponseEntity.ok(savedFridges);
    }

    @CrossOrigin
    @PostMapping("/updateQuantity/{id}")
    public ResponseEntity<Fridge> updateItemQuantity(@PathVariable Long id,
            @RequestBody Map<String, Integer> quantityMap) {
        Integer quantity = quantityMap.get("quantity");
        if (id == null || quantity == null) {
            return ResponseEntity.badRequest().build();
        }
        Fridge updatedFridge = fridgeService.updateItemQuantity(id, quantity);
        return ResponseEntity.ok(updatedFridge);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        try {
            fridgeService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
