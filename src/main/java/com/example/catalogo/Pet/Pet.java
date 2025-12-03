package com.example.catalogo.Pet;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//JPA pega classes Java anotadas com @Entity e as transforma automaticamente em tabelas no banco de dados, 
// criando colunas correspondentes aos atributos da classe.

// Define que essa classe representa uma tabela no banco de dados chamada "pets"
@Table(name = "pets")
// Define que essa classe é uma entidade JPA chamada "catalogo"
@Entity(name = "catalogo")
// Estratégia de herança SINGLE_TABLE → todas as subclasses (Doméstico, Silvestre) 
// ficam dentro da MESMA tabela
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
// Cria uma coluna "tipo_pet" para identificar qual subtipo cada registro representa
@DiscriminatorColumn(name= "tipo_pet")
// Lombok → gera automaticamente os getters
@Getter 
// Lombok → gera automaticamente os setters
@Setter
// Construtor vazio obrigatório para o Hibernate
@NoArgsConstructor 
// Lombok → gera construtor com todos os atributos
@AllArgsConstructor 
// Define que o ID será usado para comparar objetos (equals e hashCode)
@EqualsAndHashCode(of = "id") 
// Classe abstrata base para todos os tipos de Pet (não pode ser instanciada diretamente)
public abstract class Pet { 
    
    @Id // Marca o identificador único da tabela
    
    // Gera ID automático no banco (AUTO_INCREMENT)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer idade;
    private Integer peso;
    private String sexo;
    private String especie;
    private String image;

    // Construtor que recebe um DTO e já preenche os dados base do Pet
    public Pet(PetRequestDTO data) {
        this.title = data.title();
        this.peso = data.peso();
        this.sexo = data.sexo();
        this.especie = data.especie();
        this.idade = data.idade();
        this.image = data.image();
    }
}
