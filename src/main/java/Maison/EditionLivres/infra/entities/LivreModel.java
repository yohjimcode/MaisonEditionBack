package Maison.EditionLivres.infra.entities;


import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LIVRES")
public class LivreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "livre")
    private String titre;
    @Column(name = "illustration")
    private String illustration; //photo
    @Column(name = "date_parution")
    private LocalDate dateParution;
    @Column(name = "synopsis")
    private String synopsis;
    @Column(name = "prix")
    private double prix;
    @Column(name = "recommandation")
    private Long recommandation;

    @ManyToOne
    @JoinColumn(name = "auteur_id")
    private AuteurModel auteur;
}
