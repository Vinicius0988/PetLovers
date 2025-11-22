package com.example.catalogo.Pet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "pets")
@Entity(name = "pets")
public class Pet { //indica um tabela
    
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer idade;
    private Integer peso;
    private String sexo;
    private String especie;
    private String image;
}
