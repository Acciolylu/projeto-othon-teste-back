package br.edu.ifba.demo.backend.api.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "genero")
public class GeneroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Long id_genero;

    @Column(name = "nome_genero", nullable = false)
    private String nome_genero;

    @Column(name = "status", nullable = false)
    private byte status;

    //@OneToMany(mappedBy = "genero")
    //private List<LivroModel> livros;
}