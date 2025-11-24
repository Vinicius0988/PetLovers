package com.example.catalogo.Pet;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@DiscriminatorValue("DOMESTICO")  
@NoArgsConstructor
public class PetDomestico extends Pet{
    private String raca;

    public PetDomestico(PetRequestDTO data, String raca) {
        super(data);
        this.raca = raca;
    }
}
