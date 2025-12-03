package com.example.catalogo.Pet;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("SILVESTRE")  
@NoArgsConstructor
public class PetSilvestre extends Pet{
    private Boolean licenca;

    public PetSilvestre(PetRequestDTO data, Boolean licenca) {
        super(data);
        this.licenca = licenca;
    }
}
