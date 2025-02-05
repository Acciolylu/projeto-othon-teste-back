package br.edu.ifba.demo.backend.api.dto;

import java.io.Serializable;

import br.edu.ifba.demo.backend.api.model.GeneroModel;

public class GeneroDTO implements Serializable {

    private Long id_genero;
    private String nome_genero;
    private byte status;

 

    public GeneroDTO() {
    }



    public GeneroDTO(Long id_genero, String nome_genero, byte status) {
        this.id_genero = id_genero;
        this.nome_genero = nome_genero;
        this.status = status;
    }



    public Long getId_genero() {
        return id_genero;
    }



    public void setId_genero(Long id_genero) {
        this.id_genero = id_genero;
    }



    public String getNome_genero() {
        return nome_genero;
    }



    public void setNome_genero(String nome_genero) {
        this.nome_genero = nome_genero;
    }



    public byte getStatus() {
        return status;
    }



    public void setStatus(byte status) {
        this.status = status;
    }



    public static GeneroDTO converter(GeneroModel model) {
        GeneroDTO dto = new GeneroDTO();
        dto.setId_genero(model.getId_genero());
        dto.setNome_genero(model.getNome_genero());
        dto.setStatus(model.getStatus());
        return dto;
    }
}