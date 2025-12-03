package com.example.catalogo.Pet;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
