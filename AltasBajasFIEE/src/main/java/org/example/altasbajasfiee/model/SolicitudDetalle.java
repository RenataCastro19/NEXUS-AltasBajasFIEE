package org.example.altasbajasfiee.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "solicituddetalle")
public class SolicitudDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsolicituddetalle")
    private Integer idSolicitudDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsolicitudtramite", nullable = false)
    private SolicitudTramite solicitudTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgrupo", nullable = false)
    private Grupo grupo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsecretario")
    private Secretario secretario;

    @Enumerated(EnumType.STRING)
    @Column(name = "tiposolicitud", nullable = false, length = 10)
    private TipoSolicitud tipoSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 15)
    private EstadoSolicitudDetalle estado;

    @Column(name = "fechasolucion")
    private LocalDate fechaSolucion;

    public SolicitudDetalle() {

    }

    public Integer getIdSolicitudDetalle() {
        return idSolicitudDetalle;
    }
    public void setIdSolicitudDetalle(Integer idSolicitudDetalle) {
        this.idSolicitudDetalle = idSolicitudDetalle;
    }

    public SolicitudTramite getIdsolicitudtramite() {
        return solicitudTramite;
    }
    public void setSolicitudTramite(SolicitudTramite solicitudTramite) {
        this.solicitudTramite = solicitudTramite;
    }

    public Grupo getGrupo() {
        return grupo;
    }
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Secretario getSecretario() {
        return secretario;
    }
    public void setSecretario(Secretario secretario) {
        this.secretario = secretario;
    }

    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }
    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public EstadoSolicitudDetalle getEstado() {
        return estado;
    }
    public void setEstado(EstadoSolicitudDetalle estado) {
        this.estado = estado;
    }

    public LocalDate getFechaSolucion() {
        return fechaSolucion;
    }
    public void setFechaSolucion(LocalDate fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }
















}
