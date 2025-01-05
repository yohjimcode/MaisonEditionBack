package Maison.EditionLivres.infra.entities.ref;

import Maison.EditionLivres.infra.entities.LivreModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="refAuteur")
public class AuteurModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="NOM_AUTEUR",nullable = false)
    private String nomAuteur;
    @Column(name="NOM")
    private String nom;
    @Column(name="PRENOM")
    private String prenom;
    @Column(name="DATE_NAISSANCE")
    private LocalDate dateNaissance;
    @Column(name = "PHOTO_AUTEUR")
    private String photoAuteur;
    @Column(name = "BIOGRAPHIE", columnDefinition = "TEXT")
    private String biographieAuteur;
    @Column(name = "SOCIAL")
    private String siteAuteur;
    @Column(name = "EMAIL")
    private String emailAuteur;
    @Column(name = "ACTIF")
    private boolean isActif;

    @OneToMany(mappedBy = "AUTEUR")
    private List<LivreModel> livres = new ArrayList<>();
}
