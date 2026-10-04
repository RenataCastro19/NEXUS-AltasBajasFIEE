package org.example.altasbajasfiee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipobloquecreditos")
public class TipoBloqueCreditos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipobloque")
    private Long idTipoBloque;

    @Column(name= "nombrebloquecreditos", nullable = false, length = 100)
    private String nombreBloque;

    @Column(name = "creditosmin")
    private Integer creditosMin;

    @Column(name = "creditosmax")
    private Integer creditosMax;

    public TipoBloqueCreditos() {

    }


    public Long getIdTipoBloque() {
        return idTipoBloque;
    }
    public void setIdTIpoBloque(Long idTipoBloque) {
        this.idTipoBloque = idTipoBloque;
    }

    public String getNombreBloque(){
        return nombreBloque;
    }
    public void setNombreBloque(String nombreBloque){
        this.nombreBloque = nombreBloque;
    }

    public Integer getCreditosMin(){
        return creditosMin;
    }
    public void setCreditosMin(Integer creditosMin){
        this.creditosMin = creditosMin;
    }

    public Integer getCreditosMax(){
        return creditosMax;
    }
    public void setCreditosMax(Integer creditosMax){
        this.creditosMax = creditosMax;
    }






}
