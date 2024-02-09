package it.epicode.weeklyProject2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "postazione_fk")
    private Postazione postazione;
    @ManyToOne
    @JoinColumn(name = "utente_username")
    private Utente utente;
    private LocalDate dataPrenotazione;
}
