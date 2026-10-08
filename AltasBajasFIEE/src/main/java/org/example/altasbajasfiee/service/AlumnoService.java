package org.example.altasbajasfiee.service;

import org.example.altasbajasfiee.model.Alumno;
import org.example.altasbajasfiee.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlumnoService {
    //
    @Autowired
    private AlumnoRepository alumnoRepository;


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







}
