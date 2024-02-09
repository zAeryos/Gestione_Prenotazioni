package it.epicode.weeklyProject2.services;

import it.epicode.weeklyProject2.entities.Postazione;
import it.epicode.weeklyProject2.entities.Prenotazione;
import it.epicode.weeklyProject2.entities.Utente;
import it.epicode.weeklyProject2.enums.TipoPostazione;
import it.epicode.weeklyProject2.repositories.PostazioneRepository;
import it.epicode.weeklyProject2.repositories.PrenotazioneRepository;
import it.epicode.weeklyProject2.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    public List<Postazione> cercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }

    public Prenotazione effettuaPrenotazione(String username, Long postazioneId, LocalDate dataPrenotazione) {
        Utente utente = utenteRepository.findById(username).orElseThrow(() -> new IllegalArgumentException("Utente non trovato"));
        Postazione postazione = postazioneRepository.findById(postazioneId).orElseThrow(() -> new IllegalArgumentException("Postazione non trovata"));

        if (prenotazioneRepository.findByUtenteAndDataPrenotazione(utente, dataPrenotazione).isEmpty()) {
            if (prenotazioneRepository.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione).isEmpty()) {
                Prenotazione prenotazione = new Prenotazione();
                prenotazione.setUtente(utente);
                prenotazione.setPostazione(postazione);
                prenotazione.setDataPrenotazione(dataPrenotazione);
                return prenotazioneRepository.save(prenotazione);
            } else {
                throw new IllegalStateException("Postazione già prenotata per la data specificata");
            }
        } else {
            throw new IllegalStateException("L'utente ha già una prenotazione per la data specificata");
        }
    }
}
