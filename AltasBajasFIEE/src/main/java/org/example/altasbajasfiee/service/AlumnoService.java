package org.example.altasbajasfiee.service;

import org.example.altasbajasfiee.model.Alumno;
import org.example.altasbajasfiee.model.EstadoInscripcion;
import org.example.altasbajasfiee.repository.AlumnoRepository;
import org.example.altasbajasfiee.repository.ProgramaEducativoEERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AlumnoService {
    //
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private ProgramaEducativoEERepository programaEducativoEERepository;

    //metodo
    public List<Alumno> listarAlumnos(){
        return alumnoRepository.findAll();
    }

    public Alumno guardarAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public Alumno buscarPorId(Integer id){
        return alumnoRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Integer calcularCreditosAcumulados(Integer idAlumno ){

        Alumno alumno = buscarPorId(idAlumno) ;

        if(alumno == null){
            throw new RuntimeException("No existe el alumno con id " + idAlumno);
        }
        //sacar el id de la carrera
        Integer idPrograma = alumno.getProgramaEducativo().getIdProgramaEducativo();

        //pedir la suma al repository
        Long total= programaEducativoEERepository.sumarCreditosAlumno(idPrograma, idAlumno, EstadoInscripcion.APROBADA);

        //Si no hay nada que sumar devuelve 0, si no convierte a INteger
        if(total == null){
            return 0;
        }
        return total.intValue();
    }


    @Transactional(readOnly = true)
    public Integer calcularCreditosDelSemestre(Integer idAlumno, Integer idPeriodo){

        Alumno alumno = buscarPorId(idAlumno) ;

        if(alumno == null){
            throw new RuntimeException("No existe el alumno con id " + idAlumno);
        }
        Integer idPrograma = alumno.getProgramaEducativo().getIdProgramaEducativo();

        Long total= programaEducativoEERepository.sumarCreditosInscripcionEnPeriodo(idPrograma, idAlumno, EstadoInscripcion.CURSANDO, idPeriodo);

        if (total == null){
            return 0;
        }
        return total.intValue();
    }


}
