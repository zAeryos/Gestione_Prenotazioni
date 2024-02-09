package it.epicode.weeklyProject2;

import it.epicode.weeklyProject2.entities.Edificio;
import it.epicode.weeklyProject2.entities.Postazione;
import it.epicode.weeklyProject2.entities.Prenotazione;
import it.epicode.weeklyProject2.entities.Utente;
import it.epicode.weeklyProject2.enums.TipoPostazione;
import it.epicode.weeklyProject2.repositories.EdificioRepository;
import it.epicode.weeklyProject2.repositories.PostazioneRepository;
import it.epicode.weeklyProject2.repositories.PrenotazioneRepository;
import it.epicode.weeklyProject2.repositories.UtenteRepository;
import it.epicode.weeklyProject2.services.PostazioneService;
import it.epicode.weeklyProject2.services.PrenotazioneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Inizio dell'esecuzione del runner...");

        Edificio edificio = new Edificio();
        edificio.setNome("HAL");
        edificio.setIndirizzo("450-0002 Aichi");
        edificio.setCitta("Nagoya");

        edificioRepository.save(edificio);

        Postazione postazione1 = new Postazione();
        postazione1.setCodice("A043");
        postazione1.setDescrizione("Postazione Privata");
        postazione1.setTipo(TipoPostazione.PRIVATO);
        postazione1.setNumeroMassimoOccupanti(1);
        postazione1.setEdificio(edificio);

        postazioneRepository.save(postazione1);

        Utente utente = new Utente();
        utente.setUsername("ikari23");
        utente.setNomeCompleto("Ikari Dunno");
        utente.setEmail("ikari_dunno@esempio.com");

        utenteRepository.save(utente);

        Utente utente2 = new Utente();
        utente2.setUsername("dave13");
        utente2.setNomeCompleto("Davide Jackowski");
        utente2.setEmail("dave13@esempio.com");

        utenteRepository.save(utente2);

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente2);
        prenotazione.setPostazione(postazione1);
        prenotazione.setDataPrenotazione(LocalDate.of(2020, 11, 12));

        prenotazioneRepository.save(prenotazione);

        prenotazioneService.cercaPostazioni(TipoPostazione.OPENSPACE, "Città di Esempio");

        prenotazioneService.effettuaPrenotazione("dave13", 1L, LocalDate.now());
        prenotazioneService.effettuaPrenotazione("ikari23", 1L, LocalDate.now());


        List<Postazione> postazioni = postazioneService.cercaPostazioni(TipoPostazione.OPENSPACE, "Città di Esempio");


        logger.info("Fine dell'esecuzione del runner.");

    }
}
