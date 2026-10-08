package org.example.altasbajasfiee.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "bloquehorario")
public class BloqueHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbloquehorario")
    private Integer idBloqueHorario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgrupo", nullable = false)
    private Grupo grupo;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia", nullable = false, length = 10)
    private DiaSemana dia;

    @Column(name = "horainicio", nullable = false)
    private LocalTime horainicio;

    @Column(name = "horafin", nullable = false)
    private LocalTime horafin;


    public BloqueHorario() {

    }

    public Integer getIdBloqueHorario() {
        return idBloqueHorario;
    }
    public void setIdBloqueHorario(Integer idBloqueHorario) {
        this.idBloqueHorario = idBloqueHorario;
    }

    public Grupo getGrupo() {
        return grupo;
    }
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    public DiaSemana getDia() {
        return dia;
    }
    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    public LocalTime getHorainicio() {
        return horainicio;
    }
    public void setHorainicio(LocalTime horainicio) {
        this.horainicio = horainicio;
    }

    public LocalTime getHorafin() {
        return horafin;
    }
    public void setHorafin(LocalTime horafin) {
        this.horafin = horafin;
    }

}
