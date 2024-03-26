package com.end.fridge.repository;

import com.end.fridge.domain.Fridge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface FridgeRepository extends CrudRepository<Fridge, Long> {
    // Retrieves an ingredient based on a combination of user ID, ingredient ID or
    // alternative name, and expiration date.
    @Query("SELECT f FROM Fridge f WHERE f.uid = :uid AND (f.iid = :iid OR f.otherName = :otherName) AND f.expirationDate = :expirationDate")
    Optional<Fridge> findByUidAndIidOrOtherNameAndExpirationDate(Long uid, Long iid, String otherName,
            LocalDateTime expirationDate);
}