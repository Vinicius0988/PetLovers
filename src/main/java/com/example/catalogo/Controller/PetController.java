package com.example.catalogo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogo.Pet.Pet;
import com.example.catalogo.Pet.PetRepository;

@RestController
@RequestMapping("pet")
public class PetController { //requisiçoes HTTPs

    @Autowired
    private PetRepository repository;

    @GetMapping
    public List getAll() {

        List<Pet> petList = repository.findAll();
        return petList;
    }
}
