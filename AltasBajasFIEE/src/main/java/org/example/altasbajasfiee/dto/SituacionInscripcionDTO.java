package org.example.altasbajasfiee.dto;

import java.time.LocalDate;
import java.time.LocalTime;


//es el contenedor de datos que viaja hacia React en formato json
public class SituacionInscripcionDTO {

    private Integer idAlumno;
    private String nombreAlumno;
    private Integer creditosAcumulados;
    private Integer creditosSemestre;
    private Integer idBloque;
    private String nombreBloque;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalTime horaLimite;
    private boolean ventanaAbierta;

    //es el constructor recibe los datos para crear el objet ya completo
    public SituacionInscripcionDTO(Integer idAlumno, String nombreAlumno,
                                   Integer creditosAcumulados, Integer creditosSemestre,
                                   Integer idBloque, String nombreBloque, LocalDate fechaInicio,
                                   LocalDate fechaFin, LocalTime horaLimite, boolean ventanaAbierta) {

        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.creditosAcumulados = creditosAcumulados;
        this.creditosSemestre = creditosSemestre;
        this.idBloque = idBloque;
        this.nombreBloque = nombreBloque;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horaLimite = horaLimite;
        this.ventanaAbierta = ventanaAbierta;

    }

    public Integer getIdAlumno() {
        return idAlumno;
    }
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public Integer getCreditosAcumulados() {
        return creditosAcumulados;
    }

    public Integer getCreditosSemestre() {
        return creditosSemestre;
    }

    public Integer getIdBloque() {
        return idBloque;
    }

    public String getNombreBloque() {
        return nombreBloque;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public LocalTime getHoraLimite() {
        return horaLimite;
    }

    public boolean isVentanaAbierta(){
        return ventanaAbierta;
    }
}
