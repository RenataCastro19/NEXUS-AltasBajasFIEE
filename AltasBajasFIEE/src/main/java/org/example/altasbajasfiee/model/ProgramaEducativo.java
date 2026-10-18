package org.example.altasbajasfiee.model;
import jakarta.persistence.*;


@Entity
@Table(name = "programaeducativo")
public class ProgramaEducativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprogramaeducativo")
    private Integer idProgramaEducativo;

    @Column(name = "nombreprogramaeducativo", nullable = false, length = 100)
    private String nombreProgramaEducativo;

    public ProgramaEducativo() {}


    public Integer getIdProgramaEducativo() {
        return idProgramaEducativo;
    }
    public void setIdProgramaEducativo(Integer idProgramaEducativo){
        this.idProgramaEducativo = idProgramaEducativo;
    }

    public String getNombreProgramaEducativo(){
        return nombreProgramaEducativo;
    }
    public void setNombreProgramaEducativo(String nombreProgramaEducativo){
        this.nombreProgramaEducativo = nombreProgramaEducativo;
    }

}
