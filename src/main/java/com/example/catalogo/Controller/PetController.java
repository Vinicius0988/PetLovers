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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogo.Pet.Pet;
import com.example.catalogo.Pet.PetDomestico;
import com.example.catalogo.Pet.PetRepository;
import com.example.catalogo.Pet.PetRequestDTO;
import com.example.catalogo.Pet.PetResponseDTO;
import com.example.catalogo.Pet.PetSilvestre;
//Um Controller (Controlador) no Spring Boot é a classe responsável por receber requisições HTTP,
//  processar e retornar respostas.
@RestController // Indica que esta classe é um controlador REST (retorna JSON por padrão)
@RequestMapping("pet") // Rota base: http://localhost:8080/pet
public class PetController { // requisições HTTPs

    @Autowired // Injeta automaticamente o repositório (não precisa instanciar manualmente)
    private PetRepository repository;

    @PostMapping // Rota POST /pet → cria um novo pet
    public void savePet(@RequestBody PetRequestDTO data) { // Recebe o JSON enviado pelo cliente
        Pet petData;

        // Verifica o tipo de pet e instancia a classe correta
        if ("DOMESTICO".equalsIgnoreCase(data.tipoPet())) {
            petData = new PetDomestico(data, data.raca());

        } else if ("SILVESTRE".equalsIgnoreCase(data.tipoPet())) {
            petData = new PetSilvestre(data, data.licenca());

        } else {
            // Caso não seja nenhum dos dois tipos válidos
            throw new IllegalArgumentException("Tipo de pet inválido: " + data.tipoPet());
        }

        // Salva o pet no banco de dados
        repository.save(petData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*") // permite requisições de qualquer origem (CORS liberado)
    @GetMapping // Rota GET /pet → lista todos os pets
    public List<PetResponseDTO> getAll() {

        // Busca todos os pets e converte para DTO de saída
        List<PetResponseDTO> petList = repository.findAll().stream()
                                             .map(PetResponseDTO::new)
                                             .collect(Collectors.toList());
        return petList;
    }

    @DeleteMapping("/{id}") // Rota DELETE /pet/{id} → remove um pet pelo ID
    public ResponseEntity<String> deleteById(@PathVariable Long id) {

        // Verifica se o ID existe antes de remover
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Deleta pelo repositório
        repository.deleteById(id);
        return ResponseEntity.ok("Pet deletado com sucesso.");
    }

    @PutMapping("/{id}") // Rota PUT /pet/{id} → atualiza um pet existente
    public ResponseEntity<String> updatePet(@PathVariable Long id, @RequestBody PetRequestDTO data) {

        // Busca o pet no banco
        Pet pet = repository.findById(id).orElse(null);
        
        if (pet == null) {
            // Retorna 404 se não existir
            return ResponseEntity.notFound().build();
        }

        // Atualiza campos comuns a todas as classes (classe mãe Pet)
        pet.setTitle(data.title());
        pet.setIdade(data.idade());
        pet.setPeso(data.peso());
        pet.setSexo(data.sexo());
        pet.setEspecie(data.especie());
        pet.setImage(data.image());

        // Atualiza campos específicos de cada tipo
        if (pet instanceof PetDomestico domestico) {
            domestico.setRaca(data.raca());

        } else if (pet instanceof PetSilvestre silvestre) {
            silvestre.setLicenca(data.licenca());
        }

        // Salva a atualização no banco
        repository.save(pet);

        return ResponseEntity.ok("Pet atualizado com sucesso.");
    }

}
