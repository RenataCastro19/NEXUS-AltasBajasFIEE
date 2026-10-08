package org.example.altasbajasfiee.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name="habilitadobloque", uniqueConstraints = @UniqueConstraint(columnNames = {"idperiodo", "idtipobloque"}))
public class HabilitadoBloque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhabilitadobloque")
    private Integer  idHabilitadoBloque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idperiodo", nullable = false)
    private Periodo periodo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipobloque", nullable = false)
    private  TipoBloqueCreditos  tipoBloqueCreditos;

    @Column(name = "fechainicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fechafin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "horalimite", nullable = false)
    private LocalTime horalimite;

    public HabilitadoBloque() {

    }

    public Integer getIdHabilitadoBloque() {
        return idHabilitadoBloque;
    }
    public void setIdHabilitadoBloque(Integer idHabilitadoBloque) {
        this.idHabilitadoBloque = idHabilitadoBloque;
    }

    public Periodo getPeriodo(){
        return periodo;
    }
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public TipoBloqueCreditos getTipoBloqueCreditos() {
        return tipoBloqueCreditos;
    }
    public void setTipoBloqueCreditos(TipoBloqueCreditos tipoBloqueCreditos) {
        this.tipoBloqueCreditos = tipoBloqueCreditos;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalTime getHoralimite() {
        return horalimite;
    }
    public void setHoralimite(LocalTime horalimite) {
        this.horalimite = horalimite;
    }






}
