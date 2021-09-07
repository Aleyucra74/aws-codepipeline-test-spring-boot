package br.com.bandtec.projetojpa05;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EsporteRepository extends JpaRepository<Esporte, Integer> {
    List<Esporte> findByCategoriaId(Integer idCategoria);
}
