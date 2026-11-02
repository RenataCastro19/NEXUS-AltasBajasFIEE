package org.example.altasbajasfiee.repository;

import org.example.altasbajasfiee.model.BloqueHorario;
import org.example.altasbajasfiee.model.Rol;
import org.example.altasbajasfiee.model.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRolRepository extends JpaRepository<Rol, Integer> {
}
