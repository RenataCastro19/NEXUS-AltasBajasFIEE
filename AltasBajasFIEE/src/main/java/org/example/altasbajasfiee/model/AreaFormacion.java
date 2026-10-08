package org.example.altasbajasfiee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "areaformacion")
public class AreaFormacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idareaformacion")
    private Integer idAreaFormacion;

    @Column(name = "nombreareaformacion", nullable = false, length = 100)
    private String nombreAreaFormacion;

    public AreaFormacion() {

    }

    public Integer getIdAreaFormacion() {
        return idAreaFormacion;
    }

    public void setIdAreaFormacion(Integer idAreaFormacion) {
        this.idAreaFormacion = idAreaFormacion;
    }

    public String getNombreAreaFormacion() {
        return nombreAreaFormacion;
    }

    public void setNombreAreaFormacion(String nombreAreaFormacion) {
        this.nombreAreaFormacion = nombreAreaFormacion;
    }
}
