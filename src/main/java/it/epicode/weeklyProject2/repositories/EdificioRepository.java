package it.epicode.weeklyProject2.repositories;

import it.epicode.weeklyProject2.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}
