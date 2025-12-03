package com.example.catalogo.Pet;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository = Camada que faz acesso direto ao banco de dados.
// Estende JpaRepository para ganhar automaticamente métodos prontos
// como: save(), findAll(), findById(), deleteById(), etc.
public interface PetRepository extends JpaRepository<Pet, Long>{ //define a interface para acessar o DB
    

    
}
