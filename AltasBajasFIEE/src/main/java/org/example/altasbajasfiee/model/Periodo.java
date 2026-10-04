package org.example.altasbajasfiee.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "periodo")
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperiodo")
    private Long idPeriodo;

    @Column(name = "nombreperiodo", nullable = false, length = 100)
    private String nombrePeriodo;

    @Column(name = "fechainicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fechafin", nullable = false)
    private LocalDate fechaFin;

    public Periodo(){

    }

    public Long getIdPeriodo(){
        return idPeriodo;
    }
    public void setIdPeriodo(Long idPeriodo){
        this.idPeriodo = idPeriodo;
    }

    public String getNombrePeriodo(){
        return nombrePeriodo;
    }
    public void setNombrePeriodo(String nombrePeriodo){
        this.nombrePeriodo = nombrePeriodo;
    }

    public LocalDate getFechaInicio(){
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio){
        this.fechaInicio= fechaInicio;
    }


}
