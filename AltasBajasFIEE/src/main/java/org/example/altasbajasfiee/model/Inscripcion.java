package org.example.altasbajasfiee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inscripcion", uniqueConstraints = @UniqueConstraint(columnNames = {"idalumno", "idgrupo"}))
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinscripcion")
    private Integer idInscripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false )
    private EstadoInscripcion estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idalumno", nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idgrupo", nullable = false)
    private Grupo grupo;



    public Inscripcion(){

    }

    public Integer getIdInscripcion(){
        return idInscripcion;
    }
    public void setIdInscripcion(Integer idInscripcion){
        this.idInscripcion = idInscripcion;
    }

    public EstadoInscripcion getEstado() {
        return estado;
    }
    public void setEstado(EstadoInscripcion estado) {
        this.estado= estado;
    }

    public Alumno getAlumno(){
        return alumno;
    }
    public void setAlumno(Alumno alumno){
        this.alumno= alumno;
    }

    public Grupo getGrupo(){
        return grupo;
    }
    public void setGrupo(Grupo grupo){
        this.grupo= grupo;
    }
}
