package com.end.fridge.controller;

import com.end.fridge.domain.Fridge;
import com.end.fridge.service.FridgeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
