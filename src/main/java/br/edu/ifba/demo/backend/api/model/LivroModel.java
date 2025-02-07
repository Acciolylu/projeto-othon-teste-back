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
    
    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(name = "editora")
    private String editora;

    @Column(name = "ano_publicacao")
    private Integer ano_publicacao;

    @ManyToOne
    @JoinColumn(name = "genero_id_genero")
    private GeneroModel genero;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "num_paginas")
    private Integer num_paginas;

    @Column(name = "sinopse")
    private String sinopse;

    @Column(name = "idioma")
    private String idioma;

    @Column(name = "data_cadastro")
    private Timestamp data_cadastro;

    @Column(name = "preco")
    private Double preco;

    public LivroModel() {
    }

    public LivroModel(Long id_livro, String titulo, String autor, String editora, Integer ano_publicacao,
            GeneroModel genero, String isbn, Integer num_paginas, String sinopse, String idioma,
            Timestamp data_cadastro, Double preco) {
        this.id_livro = id_livro;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano_publicacao = ano_publicacao;
        this.genero = genero;
        this.isbn = isbn;
        this.num_paginas = num_paginas;
        this.sinopse = sinopse;
        this.idioma = idioma;
        this.data_cadastro = data_cadastro;
        this.preco = preco;
    }

  

}