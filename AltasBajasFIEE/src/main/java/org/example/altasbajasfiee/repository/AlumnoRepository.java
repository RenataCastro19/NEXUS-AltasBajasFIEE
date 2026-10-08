package org.example.altasbajasfiee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.altasbajasfiee.model.Alumno;



public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    Alumno findByMatriculaAlumno(String matricula);



}
