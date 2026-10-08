package org.example.altasbajasfiee.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "solicitudtramite")
public class SolicitudTramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsolicitudtramite")
    private Integer idSolicitudTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idperiodo", nullable = false)
    private Periodo periodo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idalumno", nullable = false)
    private Alumno alumno;

    @Column(name = "fechasolicitud", nullable = false)
    private LocalDate fechaSolicitud;


    public SolicitudTramite() {

    }

    public Integer getIdSolicitudTramite() {
        return idSolicitudTramite;
    }
    public void setIdSolicitudTramite(Integer idSolicitudTramite) {
        this.idSolicitudTramite = idSolicitudTramite;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Alumno getAlumno() {
        return alumno;
    }
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }
    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }


}
