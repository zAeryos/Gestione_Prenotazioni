package it.epicode.weeklyProject2.repositories;

import it.epicode.weeklyProject2.entities.Postazione;
import it.epicode.weeklyProject2.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);

}
