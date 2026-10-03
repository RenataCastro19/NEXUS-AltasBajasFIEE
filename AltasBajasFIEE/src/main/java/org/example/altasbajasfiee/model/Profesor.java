package org.example.altasbajasfiee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idprofesor")
    private Long idProfesor;

    @Column (name = "nombreprofesor", nullable = false, length = 100)
    private String nombreProfesor;

    @Column (name = "matriculaprofesor", nullable = false, length = 9, unique = true)
    private String matriculaProfesor;

    public Profesor() {}

    public Long getIdprofesor() {
        return idProfesor;
    }
    public void setIdprofesor(long idprofesor) {
        this.idProfesor= idprofesor;
    }

    public String getNombreprofesor() {
        return nombreProfesor;
    }
    public void setNombreprofesor(String nombreprofesor){
        this.nombreProfesor= nombreprofesor;
    }

    public String getMatriculaprofesor(){
        return matriculaProfesor;
    }
    public void setMatriculaprofesor(String matriculaprofesor){
        this.matriculaProfesor= matriculaprofesor;
    }



}
