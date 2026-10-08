package org.example.altasbajasfiee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "prerrequisito", uniqueConstraints =  @UniqueConstraint(columnNames = {"idee", "ideeprerrequisito"}))
public class Prerrequisito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprerrequisito")
    private Integer idPrerrequisito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idee", nullable = false)
    private ExperienciaEducativa experienciaEducativa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "ideeprerrequisito", nullable = false)
    private ExperienciaEducativa experienciaEducativaPrerrequisito;

    public Prerrequisito(){

    }

    public Integer getIdPrerrequisito() {
        return idPrerrequisito;
    }
    public void setIdPrerrequisito(Integer idPrerrequisito) {
        this.idPrerrequisito = idPrerrequisito;
    }

    public ExperienciaEducativa getExperienciaEducativa(){
        return experienciaEducativa;
    }
    public void setExperienciaEducativa(ExperienciaEducativa experienciaEducativa){
        this.experienciaEducativa = experienciaEducativa;
    }


    public ExperienciaEducativa getExperienciaEducativaPrerrequisito() {
        return experienciaEducativaPrerrequisito;
    }
    public void setExperienciaEducativaPrerrequisito(ExperienciaEducativa experienciaEducativaPrerrequisito){
        this.experienciaEducativaPrerrequisito = experienciaEducativaPrerrequisito;
    }
}
