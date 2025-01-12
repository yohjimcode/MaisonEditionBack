package Maison.EditionLivres.infra.entities;


import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import Maison.EditionLivres.infra.entities.ref.CollectionModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "FORMAT_LIVRE", discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LIVRES")
public abstract class LivreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ISBN", nullable = false)
    private String isbn;
    @Column(name = "TITRE", nullable = false)
    private String titre;
    @Column(name = "ILLUSTRATION")
    private String illustration; //photo
    @Column(name = "SYNOPSIS")
    private String synopsis;
    @ManyToMany
    @JoinTable(
            name = "LIVRE_AUTEUR",
            joinColumns = @JoinColumn(name = "LIVRE_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTEUR_ID")
    ) //Set ne permet pas les doublons
    @JsonManagedReference
    private Set<AuteurModel> auteurs = new HashSet<>();

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
}
