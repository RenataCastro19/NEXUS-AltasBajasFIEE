package org.example.altasbajasfiee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "experienciaeducativa")
public class ExperienciaEducativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idee")
    private Integer idEE;

    @Column(name = "nombreee", length = 150, nullable = false)
    private String nombreEE;

    @Column(name = "creditos", nullable = false)
    private Integer creditos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idareaformacion", nullable = false)
    private AreaFormacion areaFormacion;

    public ExperienciaEducativa() {

    }

    public Integer getIdAlumno() {
        return idEE;
    }
    public void setIdAlumno(Integer idEE) {
        this.idEE= idEE;
    }

    public String getNombreEE(){
        return nombreEE;
    }
    public void setNombreEE(String nombreEE){
        this.nombreEE=nombreEE;
    }

    public Integer getCreditos(){
        return creditos;
    }
    public void setCreditos(Integer creditos){
        this.creditos=creditos;
    }

    public AreaFormacion getAreaFormacion(){
        return areaFormacion;
    }
    public void setAreaFormacion(AreaFormacion areaFormacion){
        this.areaFormacion=areaFormacion;
    }

}
