package org.example.altasbajasfiee.controller;


import org.example.altasbajasfiee.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PruebaController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/prueba/creditos/{idAlumno}")
    @ResponseBody
    public Integer creditos(@PathVariable Integer idAlumno){
        return alumnoService.calcularCreditosAcumulados(idAlumno);
    }

    @GetMapping("/prueba/creditos-semestre/{idAlumno}/{idPeriodo}")
    @ResponseBody
    public Integer creditosSemestre(@PathVariable Integer idAlumno, @PathVariable Integer idPeriodo){
        return alumnoService.calcularCreditosDelSemestre(idAlumno, idPeriodo);
    }

}
