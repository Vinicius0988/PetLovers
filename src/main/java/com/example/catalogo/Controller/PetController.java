package com.example.catalogo.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogo.Pet.PetRepository;
import com.example.catalogo.Pet.PetResponseDTO;

@RestController
@RequestMapping("pet")
public class PetController { //requisiçoes HTTPs

    @Autowired
    private PetRepository repository;

    @GetMapping
    public List<PetResponseDTO> getAll() {
            List<PetResponseDTO> petList = repository.findAll().stream()
                                             .map(PetResponseDTO::new)
                                             .collect(Collectors.toList());
    return petList;
    }
}
