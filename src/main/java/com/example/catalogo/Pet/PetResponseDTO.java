package com.example.catalogo.Pet;

public record PetResponseDTO(
                Long id, 
                String title, 
                Integer peso, 
                String sexo, 
                String especie, 
                String image , 
                Integer idade,
                String raca,
                Boolean licenca) {
    
    public PetResponseDTO(Pet pet) {
        this(pet.getId(), 
            pet.getTitle(), 
            pet.getPeso(), 
            pet.getSexo(), 
            pet.getEspecie(), 
            pet.getImage(), 
            pet.getIdade(),
            (pet instanceof PetDomestico dom) ? dom.getRaca() : null,
            (pet instanceof PetSilvestre sil) ? sil.getLicenca() : null);
    }
}