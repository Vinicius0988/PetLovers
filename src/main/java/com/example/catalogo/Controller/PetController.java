package com.example.catalogo.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogo.Pet.Pet;
import com.example.catalogo.Pet.PetDomestico;
import com.example.catalogo.Pet.PetRepository;
import com.example.catalogo.Pet.PetRequestDTO;
import com.example.catalogo.Pet.PetResponseDTO;
import com.example.catalogo.Pet.PetSilvestre;

@RestController
@RequestMapping("pet")
public class PetController { //requisiçoes HTTPs

    @Autowired
    private PetRepository repository;

    @PostMapping
    public void savePet(@RequestBody PetRequestDTO data) {
        Pet petData;
        if ("DOMESTICO".equalsIgnoreCase(data.tipoPet())) {
        petData = new PetDomestico(data, data.raca());
    } else if ("SILVESTRE".equalsIgnoreCase(data.tipoPet())) {
        petData = new PetSilvestre(data, data.licenca());
    } else {
        throw new IllegalArgumentException("Tipo de pet inválido: " + data.tipoPet());
    }

    repository.save(petData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*") //permite de todas as fontes
    @GetMapping
    public List<PetResponseDTO> getAll() {
            List<PetResponseDTO> petList = repository.findAll().stream()
                                             .map(PetResponseDTO::new)
                                             .collect(Collectors.toList());
    return petList;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Pet deletado com sucesso.");
    }

}
