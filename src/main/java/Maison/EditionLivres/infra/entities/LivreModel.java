package Maison.EditionLivres.infra.entities;


import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import Maison.EditionLivres.infra.entities.ref.CollectionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "FORMAT_LIVRE", discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LIVRES")
public class LivreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ISBN", nullable = false)
    private String isbn;
    @Column(name = "TITRE", nullable = false)
    private String titre;
    @Column(name = "ILLUSTRATION")
    private String illustration; //photo
    @Column(name = "DATE_PARUTION")
    private LocalDate dateParution;
    @Column(name = "SYNOPSIS")
    private String synopsis;
    @Column(name = "PRIX")
    private double prix;
    @Column(name="NOMBRE_PAGES")
    private int nbrPages;

    @ManyToOne
    @JoinColumn(name = "AUTEUR_ID")
    private AuteurModel auteur; //Peuvent etre plusieurs auteurs

    @ManyToOne
    @JoinColumn(name = "COLLECTION_ID")
    private CollectionModel collection;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    public enum Categorie {
        MATERNELLE,
        PRIMAIRE,
        COLLEGE
    }

    //format numeric et/ou physique

}
