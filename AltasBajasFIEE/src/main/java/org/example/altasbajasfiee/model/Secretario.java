package org.example.altasbajasfiee.model;
import jakarta.persistence.*;

@Entity
@Table(name = "secretario")
public class Secretario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsecretario")
    private Integer idSecretario;

    @Column(name = "nombresecretario", nullable = false, length = 100)
    private String nombreSecretario;

    @Column(name = "correosecretario", length = 100, nullable = false, unique = true)
    private String correoSecretario;

    @Column(name = "matriculasecretario", length = 9, nullable = false, unique = true)
    private String matriculaSecretario;


    public Secretario(){}

    public Integer getIdSecretario(){
        return idSecretario;
    }
    public void setIdSecretario(Integer idSecretario){
        this.idSecretario= idSecretario;
    }

    public String getNombreSecretario(){
        return nombreSecretario;
    }
    public void setNombreSecretario(String nombreSecretario){
        this.nombreSecretario= nombreSecretario;
    }

    public String getCorreoSecretario(){
        return correoSecretario;
    }
    public void setCorreoSecretario(String correoSecretario){
        this.correoSecretario= correoSecretario;
    }

    public String getMatricula() {
        return matriculaSecretario;
    }
    public void setMatricula(String matriculaSecretario) {
        this.matriculaSecretario = matriculaSecretario;
    }
}

