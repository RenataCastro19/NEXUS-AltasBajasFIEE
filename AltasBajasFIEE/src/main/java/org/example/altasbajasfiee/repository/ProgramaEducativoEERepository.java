package org.example.altasbajasfiee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.altasbajasfiee.model.ProgramaEducativoEE;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.altasbajasfiee.model.EstadoInscripcion;



public interface ProgramaEducativoEERepository extends JpaRepository<ProgramaEducativoEE, Integer> {

    // dame la suma del atributo creditos de la tabla ProgramaEduactivoEE apodada como peee
    @Query("SELECT SUM(peee.creditos) FROM ProgramaEducativoEE peee " +
            //donde todas las filas sean solo de la carrera del alumno que digo
            "WHERE peee.programaEducativo.idProgramaEducativo = :idPrograma " +
            //solo las materias que estan en la subconsulta
            "AND peee.experienciaEducativa.idEE IN (" +
            //ids de las materia de las inscripciones de este alumno con este estado
            "SELECT g.experienciaEducativa.idEE FROM Inscripcion i JOIN i.grupo g " +
            "WHERE i.alumno.idAlumno = :idAlumno AND i.estado = :estado)")

    Long sumarCreditosAlumno(@Param("idPrograma") Integer idPrograma,
                             @Param("idAlumno") Integer idAlumno,
                             @Param("estado") EstadoInscripcion estado);


    //dame la suma de los creditos de la tabla programaEducativoEE
    @Query("SELECT SUM(peee.creditos) FROM ProgramaEducativoEE peee " +
            //donde el id del programa educativo del alumno coincida con la que te doy
            "WHERE peee.programaEducativo.idProgramaEducativo = :idPrograma " +
            //y donde las materia esten en la subconsulta
            "AND peee.experienciaEducativa.idEE IN (" +
            //las materias que me des deben de venir de la inscripcion del alumno que este cursando ese semestre
            "SELECT g.experienciaEducativa.idEE FROM Inscripcion i JOIN i.grupo g " +
            "WHERE i.alumno.idAlumno = :idAlumno AND i.estado = :estado AND g.periodo.idPeriodo = :idPeriodo)")

    Long sumarCreditosInscripcionEnPeriodo(@Param("idPrograma") Integer idPrograma,
                                           @Param("idAlumno") Integer idAlumno,
                                           @Param("estado") EstadoInscripcion estado,
                                           @Param("idPeriodo") Integer idPeriodo);



}
