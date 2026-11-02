package org.example.altasbajasfiee.repository;

import org.example.altasbajasfiee.model.BloqueHorario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<BloqueHorario, Integer> {
}
