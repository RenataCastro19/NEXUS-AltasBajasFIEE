package org.example.altasbajasfiee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgrupo")
    private Long idGrupo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idee", nullable = false)
    private ExperienciaEducativa experienciaEducativa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idperiodo", nullable = false)
    private Periodo periodo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprofesor", nullable = false)
    private Profesor profesor;


    @Column(name = "cupomax", nullable = false)
    private Integer cupoMax;


    @Column(name = "nrc", nullable = false, unique = true, length = 5)
    private String nrc;

    @Column(name="salon", nullable = false, length = 3)
    private String salon;

    public Grupo() {

    }

    public Long getIdGrupo() {
        return idGrupo;
    }
    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public ExperienciaEducativa getExperienciaEducativa() {
        return experienciaEducativa;
    }
    public void setExperienciaEducativa(ExperienciaEducativa experienciaEducativa) {
        this.experienciaEducativa = experienciaEducativa;
    }

    public Periodo getPeriodo(){
        return periodo;
    }
    public void setPeriodo(Periodo periodo){
        this.periodo = periodo;
    }

    public Profesor getProfesor(){
        return profesor;
    }
    public void setProfesor(Profesor profesor){
        this.profesor = profesor;
    }

    public Integer getCupoMax() {
        return cupoMax;
    }
    public void setCupoMax(Integer cupoMax) {
        this.cupoMax = cupoMax;
    }

    public String getNrc(){
        return nrc;
    }
    public void setNrc(String nrc){
        this.nrc= nrc;
    }

    public String getSalon(){
        return salon;
    }
    public void setSalon(String salon){
        this.salon= salon;
    }
}
