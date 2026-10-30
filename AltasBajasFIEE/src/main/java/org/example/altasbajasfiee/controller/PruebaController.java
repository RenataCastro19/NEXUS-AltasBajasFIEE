package org.example.altasbajasfiee.controller;


import org.example.altasbajasfiee.model.TipoBloqueCreditos;
import org.example.altasbajasfiee.service.AlumnoService;
import org.example.altasbajasfiee.service.BloqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class PruebaController {
    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private BloqueService bloqueService;

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

    @GetMapping("/prueba/bloque/{idAlumno}/{idPeriodo}")
    @ResponseBody
    public Integer bloque(@PathVariable Integer idAlumno, @PathVariable Integer idPeriodo){
        TipoBloqueCreditos tipoBloqueCreditos = bloqueService.determinarBloque(idAlumno, idPeriodo);
        return tipoBloqueCreditos.getIdTipoBloque();
    }

    @GetMapping("/prueba/ventana/{idPeriodo}/{idTipoBloque}")
    @ResponseBody
    public boolean ventanaAbierta(@PathVariable Integer idPeriodo, @PathVariable Integer idTipoBloque, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime momento){
        return bloqueService.ventanaEstado(idPeriodo, idTipoBloque, momento);


    }
}
