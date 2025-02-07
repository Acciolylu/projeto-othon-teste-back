package br.edu.ifba.demo.backend.api.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.demo.backend.api.model.LivroModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class LivroDTO implements Serializable{


    private Long id_livro;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano_publicacao;
    private String genero;
    private String isbn;
    private Integer num_paginas;
    private String sinopse;
    private String idioma;
    private Timestamp data_cadastro;
    private Double preco;
    

    public static LivroDTO converter(LivroModel model) {
        return new LivroDTO(
            model.getId_livro(), 
            model.getTitulo(), 
            model.getAutor(), 
            model.getEditora(),
            model.getAno_publicacao(), 
            model.getGenero() != null ? model.getGenero().getNome_genero() : null, 
            model.getIsbn(),
            model.getNum_paginas(), 
            model.getSinopse(), 
            model.getIdioma(),
            model.getData_cadastro(), 
            model.getPreco()
        );
    }

    public static List<LivroDTO> converter(List<LivroModel> livros) {
        List<LivroDTO> livroDTO = new ArrayList<>();
        for (LivroModel livro : livros) {
            livroDTO.add(LivroDTO.converter(livro));
        }
        return livroDTO;
    }
    
}
