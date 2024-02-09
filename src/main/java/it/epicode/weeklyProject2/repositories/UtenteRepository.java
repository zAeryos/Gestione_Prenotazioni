package it.epicode.weeklyProject2.repositories;

import it.epicode.weeklyProject2.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, String> {
}
