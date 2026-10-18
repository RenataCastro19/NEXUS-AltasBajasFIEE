package org.example.altasbajasfiee.model;

import jakarta.persistence.*;


@Entity
@Table(name = "programaeducativoee", uniqueConstraints = @UniqueConstraint(columnNames = {"idprogramaeducativo", "idee"}))
public class ProgramaEducativoEE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprogramaeducativoee")
    private Integer idProgramaEducativoEE;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprogramaeducativo", nullable = false)
    private ProgramaEducativo programaEducativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idee", nullable = false)
    private ExperienciaEducativa experienciaEducativa;

    @Column(name = "creditos", nullable = false)
    private Integer creditos;

    public ProgramaEducativoEE(){

    }

    public Integer getIdProgramaEducativoEE() {
        return idProgramaEducativoEE;
    }
    public void setIdProgramaEducativoEE(Integer idprogramaeducativoee){
        this.idProgramaEducativoEE= idprogramaeducativoee;
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

    public void setCreditos(Integer creditos){
        this.creditos= creditos;
    }
    public Integer getCreditos() {
        return creditos;
    }

}
