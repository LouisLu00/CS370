package com.end.fridge.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "fridge")
public class Fridge {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    public Fridge() {}
}
