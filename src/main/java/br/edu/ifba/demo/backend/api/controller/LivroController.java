package br.edu.ifba.demo.backend.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.demo.backend.api.dto.LivroDTO;
import br.edu.ifba.demo.backend.api.model.LivroModel;
import br.edu.ifba.demo.backend.api.repository.LivroRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livRepository;

    public LivroController(LivroRepository livRepository) {
        this.livRepository = livRepository;
    }

    // Método para cadastrar um livro
    @PostMapping
    public ResponseEntity<LivroModel> cadastrarLivro(@RequestBody @Validated LivroModel livroModel) {
        try {
            LivroModel livroSalvo = livRepository.save(livroModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Método para testar a rota
    @GetMapping
    public String teste() {
        return "Testando Rota livro";
    }

    // Método para listar todos os livros
    @GetMapping("/listall")
    public ResponseEntity<List<LivroModel>> listall() {
        List<LivroModel> livros = livRepository.findAll();
        return ResponseEntity.ok(livros);
    }

    // Método para buscar um livro por ID
    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> findById(@PathVariable Long id) {
        Optional<LivroModel> livro = livRepository.findById(id);
        return livro.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Método para buscar livros por título
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<LivroDTO>> buscarTitulo(@PathVariable String titulo) {
        List<LivroModel> livros = livRepository.findByTituloContainingIgnoreCase(titulo);
        if (livros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LivroDTO.converter(livros));
    }

    // Método para buscar um livro por ISBN
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<LivroDTO> buscarIsbn(@PathVariable String isbn) {
        Optional<LivroModel> livro = livRepository.findByIsbn(isbn);
        if (livro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LivroDTO.converter(livro.get()));
    }

    // Método para atualizar um livro existente
    @PutMapping("/{id}")
    public ResponseEntity<LivroModel> atualizarLivro(@PathVariable Long id, @RequestBody @Validated LivroModel livroAtualizado) {
        Optional<LivroModel> livroExistente = livRepository.findById(id);

        if (livroExistente.isPresent()) {
            LivroModel livro = livroExistente.get();
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setEditora(livroAtualizado.getEditora());
            livro.setAno_publicacao(livroAtualizado.getAno_publicacao());
            livro.setGenero(livroAtualizado.getGenero());
            livro.setIsbn(livroAtualizado.getIsbn());
            livro.setNum_paginas(livroAtualizado.getNum_paginas());
            livro.setSinopse(livroAtualizado.getSinopse());
            livro.setIdioma(livroAtualizado.getIdioma());
            livro.setPreco(livroAtualizado.getPreco());

            LivroModel livroSalvo = livRepository.save(livro);
            return ResponseEntity.ok(livroSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para deletar um livro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id) {
        try {
            Optional<LivroModel> livro = livRepository.findById(id);
            if (livro.isPresent()) {
                livRepository.deleteById(id);
                return ResponseEntity.ok("Livro deletado com sucesso!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o livro.");
        }
    }
}