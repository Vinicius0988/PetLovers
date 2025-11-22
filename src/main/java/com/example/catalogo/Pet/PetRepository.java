package com.example.catalogo.Pet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long>{ //define a interface para acessar o DB
    

    
}
