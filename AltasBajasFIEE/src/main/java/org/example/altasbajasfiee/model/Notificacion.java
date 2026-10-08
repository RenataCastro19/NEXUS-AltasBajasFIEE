package org.example.altasbajasfiee.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnotificacion")
    private Integer idnotificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idalumno", nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsolicituddetalle")
    private SolicitudDetalle solicitudDetalle;

    @Enumerated(EnumType.STRING)
    @Column(name = "canal", nullable = false, length = 10)
    private Canal canal;

    @Column(name = "fechaenvio", nullable = false)
    private LocalDate fechaenvio;

    @Column(name = "mensaje", nullable = false, length = 400)
    private String mensaje;

    public Notificacion() {}

    public Integer getIdnotificacion() {
        return idnotificacion;
    }
    public void setIdnotificacion(Integer idnotificacion) {
        this.idnotificacion = idnotificacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public SolicitudDetalle getSolicitudDetalle() {
        return solicitudDetalle;
    }
    public void setSolicitudDetalle(SolicitudDetalle solicitudDetalle) {
        this.solicitudDetalle = solicitudDetalle;
    }

    public Canal getCanal() {
        return canal;
    }
    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public LocalDate getFechaenvio() {
        return fechaenvio;
    }
    public void setFechaenvio(LocalDate fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }




}
