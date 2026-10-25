package org.example.altasbajasfiee.service;

import org.example.altasbajasfiee.model.TipoBloqueCreditos;
import org.example.altasbajasfiee.repository.TipoBloqueCreditosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BloqueService {

    @Autowired
    private TipoBloqueCreditosRepository tipoBloqueCreditosRepository;

    @Autowired
    private AlumnoService alumnoService;

    @Transactional(readOnly = true)
    public TipoBloqueCreditos determinarBloque(Integer idAlumno, Integer idPeriodo) {

        Integer creditos = alumnoService.calcularCreditosDelSemestre(idAlumno, idPeriodo);

        List<TipoBloqueCreditos> bloques = tipoBloqueCreditosRepository.buscarBloquesPorCreditos(creditos);
        if (bloques.isEmpty()) {
            throw new RuntimeException("no existe un bloque para esta cantidad de creditos");
        }
        return bloques.get(0);
    }

}
