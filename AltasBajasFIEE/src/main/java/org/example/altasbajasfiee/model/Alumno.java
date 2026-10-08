package org.example.altasbajasfiee.model;

import jakarta.persistence.*;


@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalumno")
    private Integer idAlumno;

    @Column(name = "matriculaalumno", length = 9, unique = true, nullable = false)
    private String matriculaAlumno;

    @Column(name = "nombrealumno", length = 200, nullable = false)
    private String nombreAlumno;
// si el correo solo debe aceptar lo que tiene @estudiantes.ux.mx como lo hago?
    @Column(name = "correoinstitucional", length = 50, nullable = false, unique = true)
    private String correoInstitucional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprogramaeducativo", nullable = false)
    private ProgramaEducativo programaEducativo;


    public Alumno() {}

    public Integer getIdAlumno(){
        return idAlumno;
    }
    public void setIdAlumno(Integer idAlumno){
        this.idAlumno = idAlumno;
    }

    public String getMatriculaAlumno(){
        return matriculaAlumno;
    }
    public void setMatriculaAlumno(String matriculaAlumno){
        this.matriculaAlumno = matriculaAlumno;
    }

    public String getNombreAlumno(){
        return nombreAlumno;
    }
    public void setNombreAlumno(String nombreAlumno){
        this.nombreAlumno = nombreAlumno;
    }
    public String getCorreoInstitucional(){
        return correoInstitucional;
    }
    public void setCorreoInstitucional(String correoInstitucional){
        this.correoInstitucional = correoInstitucional;
    }

    public ProgramaEducativo getProgramaEducativo(){
        return programaEducativo;
    }
    public void setProgramaEducativo(ProgramaEducativo programaEducativo){
        this.programaEducativo = programaEducativo;
    }


}
