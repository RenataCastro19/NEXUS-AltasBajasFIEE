package org.example.altasbajasfiee.model;
import jakarta.persistence.*;

@Entity
@Table(name = "secretario")
public class Secretario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "secretario")
    private Long secretario;

    @Column(name = "nombresecretario", nullable = false, length = 100)
    private String nombreSecretario;

    @Column(name = "correosecretatio", length = 100, nullable = false, unique = true)
    private String correoSecretario;

    @Column(name = "matricula", length = 9, nullable = false, unique = true)
    private String matricula;
}

