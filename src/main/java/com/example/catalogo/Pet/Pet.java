package com.example.catalogo.Pet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "pets") //cria a tabela pets
@Entity(name = "pets") //cria a entidade pets
@Getter
@NoArgsConstructor //declara um constructor q nao recebe argumentos
@AllArgsConstructor // declara um constructor q recebe todos os argumentos
@EqualsAndHashCode(of = "id") //indica o id como representação unica

public class Pet { //indica um tabela
    
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer idade;
    private Integer peso;
    private String sexo;
    private String especie;
    private String image;

    public Pet(PetRequestDTO data) {
         this.title = data.title();
    this.peso = data.peso();
    this.sexo = data.sexo();
    this.especie = data.especie();
    this.idade = data.idade();
    this.image = data.image();
    }
}
