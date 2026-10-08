package org.example.altasbajasfiee.model;

import jakarta.persistence.*;


@Entity
@Table(name = "programaeducativoee", uniqueConstraints = @UniqueConstraint(columnNames = {"idprogramaeducativo", "idee"}))
public class ProgramaEducativoEE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprogramaeducativoee")
    private Integer idProgramaEducativoee;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprogramaeducativo", nullable = false)
    private ProgramaEducativo programaEducativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idee", nullable = false)
    private ExperienciaEducativa experienciaEducativa;

    public ProgramaEducativoEE(){

    }

    public Integer getIdprogramaeducativoee() {
        return idProgramaEducativoee;
    }
    public void setIdprogramaeducativoee(Integer idprogramaeducativoee){
        this.idProgramaEducativoee= idprogramaeducativoee;
    }

    public ProgramaEducativo getProgramaEducativo() {
        return programaEducativo;
    }
    public void setProgramaEducativo(ProgramaEducativo programaEducativo){
        this.programaEducativo= programaEducativo;
    }

    public ExperienciaEducativa getExperienciaEducativa() {
        return experienciaEducativa;
    }
    public void setExperienciaEducativa(ExperienciaEducativa experienciaEducativa){
        this.experienciaEducativa= experienciaEducativa;
    }

}
