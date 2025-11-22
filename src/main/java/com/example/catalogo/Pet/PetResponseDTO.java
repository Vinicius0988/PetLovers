package com.example.catalogo.Pet;

public record PetResponseDTO(Long id, String title, Integer peso, String sexo, String especie, 
                String image) {
    
    public PetResponseDTO(Pet pet) {
        this(pet.getId(), pet.getTitle(), pet.getPeso(), pet.getSexo(), pet.getEspecie(), pet.getImage());
    }
}