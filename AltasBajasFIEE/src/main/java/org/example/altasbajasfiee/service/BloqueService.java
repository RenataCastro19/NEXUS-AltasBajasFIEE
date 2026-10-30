package org.example.altasbajasfiee.service;

import org.example.altasbajasfiee.dto.SituacionInscripcionDTO;
import org.example.altasbajasfiee.model.Alumno;
import org.example.altasbajasfiee.model.HabilitadoBloque;
import org.example.altasbajasfiee.model.TipoBloqueCreditos;
import org.example.altasbajasfiee.repository.HabilitadoBloqueRepository;
import org.example.altasbajasfiee.repository.TipoBloqueCreditosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class BloqueService {

    @Autowired
    private TipoBloqueCreditosRepository tipoBloqueCreditosRepository;

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private HabilitadoBloqueRepository habilitadoBloqueRepository;

    //metodo que determina en que bloque de altas esta, segun tus creditos del semestre

    @Transactional(readOnly = true)
    public TipoBloqueCreditos determinarBloque(Integer idAlumno, Integer idPeriodo) {

        Integer creditos = alumnoService.calcularCreditosDelSemestre(idAlumno, idPeriodo);

        List<TipoBloqueCreditos> bloques = tipoBloqueCreditosRepository.buscarBloquesPorCreditos(creditos);
        if (bloques.isEmpty()) {
            throw new RuntimeException("no existe un bloque para esta cantidad de creditos");
        }
        return bloques.get(0);
    }


    //metodo que determina si la ventana esta dabierta en un memento determinado
    @Transactional(readOnly = true)
    public boolean ventanaEstado(Integer idPeriodo, Integer idTipoBloque, LocalDateTime momento) {
        //buscar la fechas de ese periodo y bloque
        Optional<HabilitadoBloque> fechaHabilitada = habilitadoBloqueRepository.buscarPorPeriodoYBloque(idPeriodo, idTipoBloque);
        //si no hya fechas, la ventana se considerará cerrada
        if (fechaHabilitada.isEmpty()) {
            return false;
        }

        //sacamos la ventana
        HabilitadoBloque ventana = fechaHabilitada.get();

        //moemnto de apertura, la fecha de inicio es a las 0:00
        //atStartOfDay convierte un LocalDate en LocalDateTime al inicio del día
        LocalDateTime apertura = ventana.getFechaInicio().atStartOfDay();

        //momento de cierre: la fecha de fin a la hora limite
        //Junta un LocalDate y un LocalTime
        LocalDateTime cierre = LocalDateTime.of(ventana.getFechaFin(), ventana.getHoralimite());

        //abierta si el moemnto no es antes de la apertura y no es despues del cierre
        return !momento.isBefore(apertura) && !momento.isAfter(cierre);
    }

    //metodo que llama a mas metodos y junta lo que devuelve, lo mete al resultado del dto
    @Transactional(readOnly = true)
    public SituacionInscripcionDTO obtenerSituacion (Integer idAlumno, Integer idPeriodo, LocalDateTime momento){

        Alumno alumno  = alumnoService.buscarPorId(idAlumno);
        if (alumno == null) {
            throw new RuntimeException("no existe un alumno con id " + idAlumno);
        }

        //metodos que ya estan en AlumnoService
        Integer creditosAcumulados = alumnoService.calcularCreditosAcumulados(idAlumno);
        Integer creditosSemestre = alumnoService.calcularCreditosDelSemestre(idAlumno, idPeriodo);

        TipoBloqueCreditos bloque = determinarBloque(idAlumno, idPeriodo);
        //ventana de fechas de ese bloque en ese periodo, cunaod le toca inscribirse
        Optional<HabilitadoBloque> ventana = habilitadoBloqueRepository.buscarPorPeriodoYBloque(idPeriodo, bloque.getIdTipoBloque());

        //varibale que se llenan solo si hay ventana, si no hay queda en null
        LocalDate fechaInicio = null;
        LocalDate fechaFin = null;
        LocalTime horaLimite = null;
        //hay una ventana registrada? trae algo?
        if (ventana.isPresent()){
            HabilitadoBloque v = ventana.get();
            fechaInicio = v.getFechaInicio();
            fechaFin = v.getFechaFin();
            horaLimite = v.getHoralimite();
        }
        //llama al metodo que compara el momento con el inicio y el cierre de la ventana con true o false
        boolean ventanaAbierta = ventanaEstado(idPeriodo, bloque.getIdTipoBloque(), momento);

        //devuleve el objeto
        return new SituacionInscripcionDTO(
                alumno.getIdAlumno(),
                alumno.getNombreAlumno(),
                creditosAcumulados,
                creditosSemestre,
                bloque.getIdTipoBloque(),
                bloque.getNombreBloque(),
                fechaInicio,
                fechaFin,
                horaLimite,
                ventanaAbierta
        );

    }

}
