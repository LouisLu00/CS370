package com.end.fridge.service;

import com.end.fridge.domain.Fridge;
import com.end.fridge.repository.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FridgeService {
    @Autowired
    private FridgeRepository fridgeRepository;

    public Iterable<Fridge> list() {
        return fridgeRepository.findAll();
    }

    public Fridge save(Fridge fridge) {
        // Check if there's existing ingreidents with same expiration date
        Optional<Fridge> existingFridge = fridgeRepository.findByUidAndIidOrOtherNameAndExpirationDate(
                fridge.getUid(), fridge.getIid(), fridge.getOtherName(), fridge.getExpirationDate());

        if (existingFridge.isPresent()) {
            // If exists, upate the value
            Fridge existingRecord = existingFridge.get();
            existingRecord.setQuantity(existingRecord.getQuantity() + fridge.getQuantity());
            return fridgeRepository.save(existingRecord);
        } else {
            // Create new records
            return fridgeRepository.save(fridge);
        }
    }
}
