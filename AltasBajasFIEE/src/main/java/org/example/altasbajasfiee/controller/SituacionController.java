package org.example.altasbajasfiee.controller;
import org.example.altasbajasfiee.dto.SituacionInscripcionDTO;
import org.example.altasbajasfiee.service.BloqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;



//clase que recibe la peticion de react y llama a obtenerSituacion
@RestController //atiende peticiones web y devuelve json
@RequestMapping("/api")
public class SituacionController {


    @Autowired
    private BloqueService bloqueService;

    @GetMapping("/alumnos/{idAlumno}/situacion")
    public SituacionInscripcionDTO obtenerSituacion(@PathVariable Integer idAlumno, @RequestParam Integer idPeriodo,
                                                    //lo de requires es pq el parametro es opcional, @DateTimeFormat le dice a spring com leer el texto de fecha y hora
                                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime momento){

        //si no se manda el momento, se usa el instante actual
        if(momento == null){
            momento = LocalDateTime.now();
        }

        return bloqueService.obtenerSituacion(idAlumno, idPeriodo, momento);
    }


}
