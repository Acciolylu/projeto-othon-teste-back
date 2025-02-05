package br.edu.ifba.demo.backend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifba.demo.backend.api.model.GeneroModel;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<GeneroModel, Long> {
    GeneroModel findByNomeGenero(String nomeGenero);
    List<GeneroModel> findByNomeGeneroContainingIgnoreCase(String nomeGenero);
}