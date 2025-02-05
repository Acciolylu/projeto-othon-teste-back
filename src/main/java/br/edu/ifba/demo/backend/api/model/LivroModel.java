package br.edu.ifba.demo.backend.api.model;

import lombok.Data;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "livro")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private Long id_livro;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "editora", nullable = true)
    private String editora;

    @Column(name = "ano_publicacao", nullable = true)
    private Integer ano_publicacao;

    @ManyToOne
    @JoinColumn(name = "genero_id_genero", nullable = true)
    private GeneroModel genero;

    @Column(name = "isbn", nullable = true)
    private String isbn;

    @Column(name = "num_paginas", nullable = true)
    private Integer num_paginas;

    @Column(name = "sinopse", nullable = true)
    private String sinopse;

    @Column(name = "idioma", nullable = true)
    private String idioma;

    @Column(name = "data_cadastro", nullable = true)
    private Timestamp data_cadastro;

    @Column(name = "preco", nullable = true)
    private Double preco;
}