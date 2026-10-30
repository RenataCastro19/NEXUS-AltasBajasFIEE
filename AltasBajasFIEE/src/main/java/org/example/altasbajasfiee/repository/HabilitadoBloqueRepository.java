package org.example.altasbajasfiee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.altasbajasfiee.model.HabilitadoBloque;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface HabilitadoBloqueRepository extends JpaRepository<HabilitadoBloque, Integer> {
    //obtiene el resitro de habilitado bloque cuyo periodo sea el que te doy y cuyo tipo de bloque sea el que te doy
    @Query("SELECT f FROM HabilitadoBloque f " +
            "WHERE f.periodo.idPeriodo = :idPeriodo AND f.tipoBloqueCreditos.idTipoBloque = :idTipoBloque")

    Optional<HabilitadoBloque> buscarPorPeriodoYBloque(@Param("idPeriodo") Integer idPeriodo,
                                                        @Param("idTipoBloque") Integer idTipoBloque);


}
