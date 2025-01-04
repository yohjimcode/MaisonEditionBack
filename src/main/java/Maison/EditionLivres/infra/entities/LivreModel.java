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
    @Column(name = "isbn", nullable = false)
    private String isbn;
    @Column(name = "livre", nullable = false)
    private String titre;
    @Column(name = "illustration")
    private String illustration; //photo
    @Column(name = "date_parution")
    private LocalDate dateParution;
    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "prix")
    private double prix;
    @Column(name="nombre_pages")
    private int nbrPages;

    @Column(name = "recommandation")
    private Long recommandation;

    @ManyToOne
    @JoinColumn(name = "auteur_id")
    private AuteurModel auteur;

//    @Column(name="collection")
//    private String collection; //tab de ref

//    @Column(name="public")
//    private String publicConcerne; // modifer par une tab de referentiel

    //typeProduit, format = ebook ou papier // tab de ref
}
