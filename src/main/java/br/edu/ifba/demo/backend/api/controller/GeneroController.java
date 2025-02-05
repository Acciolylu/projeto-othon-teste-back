package br.edu.ifba.demo.backend.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.ifba.demo.backend.api.model.GeneroModel;
import br.edu.ifba.demo.backend.api.repository.GeneroRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/generos") 
public class GeneroController {

    private final GeneroRepository generoRepository;

    public GeneroController(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    // Cadastrar um novo gênero
    @PostMapping
    public ResponseEntity<GeneroModel> criarGenero(@RequestBody GeneroModel genero) {
        try {
            GeneroModel generoSalvo = generoRepository.save(genero);
            return ResponseEntity.status(HttpStatus.CREATED).body(generoSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //  Listar todos os gêneros
    @GetMapping
    public ResponseEntity<List<GeneroModel>> listarTodosGeneros() {
        List<GeneroModel> generos = generoRepository.findAll();
        return ResponseEntity.ok(generos);
    }

    // Buscar um gênero por ID
    @GetMapping("/{id}")
    public ResponseEntity<GeneroModel> buscarGeneroPorId(@PathVariable Long id) {
        Optional<GeneroModel> genero = generoRepository.findById(id);
        return genero.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

   //Atualizar um gênero existente
    @PutMapping("/{id}")
    public ResponseEntity<GeneroModel> atualizarGenero(@PathVariable Long id, @RequestBody GeneroModel generoAtualizado) {
        return generoRepository.findById(id)
                .map(genero -> {
                    genero.setId_genero(generoAtualizado.getId_genero());
                    genero.setStatus(generoAtualizado.getStatus());
                    GeneroModel generoSalvo = generoRepository.save(genero);
                    return ResponseEntity.ok(generoSalvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar um gênero por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGenero(@PathVariable Long id) {
        try {
            generoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}