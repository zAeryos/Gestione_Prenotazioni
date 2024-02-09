package it.epicode.weeklyProject2.services;

import it.epicode.weeklyProject2.entities.Postazione;
import it.epicode.weeklyProject2.enums.TipoPostazione;
import it.epicode.weeklyProject2.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> cercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }
}
