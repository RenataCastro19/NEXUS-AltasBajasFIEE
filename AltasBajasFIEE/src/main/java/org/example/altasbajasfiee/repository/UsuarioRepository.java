package org.example.altasbajasfiee.repository;

import org.example.altasbajasfiee.model.BloqueHorario;
import org.example.altasbajasfiee.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
