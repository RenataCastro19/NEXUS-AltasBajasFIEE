package org.example.altasbajasfiee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.altasbajasfiee.model.TipoBloqueCreditos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoBloqueCreditosRepository extends JpaRepository<TipoBloqueCreditos, Integer> {

    @Query("SELECT t FROM TipoBloqueCreditos t " +
            "WHERE t.creditosMin IS NOT NULL AND t.creditosMin <= :creditos AND " +
            "(t.creditosMax IS NULL OR t.creditosMax >= :creditos) " +
            "ORDER BY t.idTipoBloque")
    List<TipoBloqueCreditos> buscarBloquesPorCreditos(@Param("creditos") Integer creditos);

}
