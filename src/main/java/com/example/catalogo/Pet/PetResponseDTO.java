package com.example.catalogo.Pet;

// DTO de saída (Response):
// usado para enviar os dados de um Pet para o cliente (ex: frontend).
// Evita expor a entidade inteira e permite controlar exatamente
// o que será retornado na resposta HTTP.
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