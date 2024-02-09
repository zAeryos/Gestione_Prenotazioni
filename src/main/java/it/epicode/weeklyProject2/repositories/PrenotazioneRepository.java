package it.epicode.weeklyProject2.repositories;

import it.epicode.weeklyProject2.entities.Postazione;
import it.epicode.weeklyProject2.entities.Prenotazione;
import it.epicode.weeklyProject2.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
    List<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
}
