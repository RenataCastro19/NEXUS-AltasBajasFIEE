package org.example.altasbajasfiee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bloquehorario")
public class BloqueHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbloquehorario")
    private Long idBloqueHorario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgrupo", nullable = false)
    private Grupo grupo;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia", nullable = false, length = 10)
    private DiaSemana dia;




}
