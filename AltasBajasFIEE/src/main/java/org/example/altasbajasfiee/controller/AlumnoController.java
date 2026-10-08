package org.example.altasbajasfiee.controller;

import org.example.altasbajasfiee.model.Alumno;
import org.example.altasbajasfiee.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/alumnos")
    public String alumnos(Model model){
        //llamas al services
        //TipoVarible nombreVariable= llamadaMetodoService
        List<Alumno> alumnos = alumnoService.listarAlumnos();
        model.addAttribute("alumnos", alumnos);
        return "alumnos";
    }


}
