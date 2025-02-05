package br.edu.ifba.demo.backend.api.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.demo.backend.api.model.LivroModel;

public class LivroDTO implements Serializable{


    private Long id_livro;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano_publicacao;
    private GeneroDTO genero;
    private String isbn;
    private Integer num_paginas;
    private String sinopse;
    private String idioma;
    private Timestamp data_cadastro;
    private Double preco;
    

    public LivroDTO() {
    }

    

    public LivroDTO(Long id_livro, String titulo, String autor, String editora, Integer ano_publicacao,
            GeneroDTO genero, String isbn, Integer num_paginas, String sinopse, String idioma, Timestamp data_cadastro,
            Double preco) {
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



    public Long getId_livro() {
        return id_livro;
    }



    public void setId_livro(Long id_livro) {
        this.id_livro = id_livro;
    }



    public String getTitulo() {
        return titulo;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public String getAutor() {
        return autor;
    }



    public void setAutor(String autor) {
        this.autor = autor;
    }



    public String getEditora() {
        return editora;
    }



    public void setEditora(String editora) {
        this.editora = editora;
    }



    public Integer getAno_publicacao() {
        return ano_publicacao;
    }



    public void setAno_publicacao(Integer ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }



    public GeneroDTO getGenero() {
        return genero;
    }



    public void setGenero(GeneroDTO genero) {
        this.genero = genero;
    }



    public String getIsbn() {
        return isbn;
    }



    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }



    public Integer getNum_paginas() {
        return num_paginas;
    }



    public void setNum_paginas(Integer num_paginas) {
        this.num_paginas = num_paginas;
    }



    public String getSinopse() {
        return sinopse;
    }



    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }



    public String getIdioma() {
        return idioma;
    }



    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }



    public Timestamp getData_cadastro() {
        return data_cadastro;
    }



    public void setData_cadastro(Timestamp data_cadastro) {
        this.data_cadastro = data_cadastro;
    }



    public Double getPreco() {
        return preco;
    }



    public void setPreco(Double preco) {
        this.preco = preco;
    }



    public static LivroDTO converter(LivroModel model) {
        LivroDTO dto = new LivroDTO();
        dto.setId_livro(model.getId_livro());
        dto.setTitulo(model.getTitulo());
        dto.setAutor(model.getAutor());
        dto.setEditora(model.getEditora());
        dto.setAno_publicacao(model.getAno_publicacao());
        dto.setGenero(GeneroDTO.converter(model.getGenero()));
        dto.setIsbn(model.getIsbn());
        dto.setNum_paginas(model.getNum_paginas());
        dto.setSinopse(model.getSinopse());
        dto.setIdioma(model.getIdioma());
        dto.setData_cadastro(model.getData_cadastro());
        dto.setPreco(model.getPreco());
        return dto;
    }

    public static List<LivroDTO> converter(List<LivroModel> livros) {
        List<LivroDTO> livroDTO = new ArrayList<>();
        for (LivroModel livro : livros) {
            livroDTO.add(LivroDTO.converter(livro));
        }
        return livroDTO;
    }
    
}
