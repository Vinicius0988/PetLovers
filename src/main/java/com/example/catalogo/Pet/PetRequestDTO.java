package com.example.catalogo.Pet;

// DTO de entrada (Request): representa os dados enviados pelo cliente
// quando ele quer criar ou atualizar um Pet.
// Não contém regras de negócio, só carrega informações da requisição HTTP.
public record PetRequestDTO(
                String title, 
                Integer peso, 
                String sexo, 
                String especie, 
                String image, 
                Integer idade,
                String tipoPet,     
                String regiaoOrigem,
                boolean licenca,
                String raca) {
}
