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
    @Column(name="nomAuteur",nullable = false)
    private String nomAuteur;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="date_naissance")
    private LocalDate dateNaissance;
    @Column(name = "photo_auteur")
    private String photoAuteur;
    @Column(name = "biographie", columnDefinition = "TEXT")
    private String biographieAuteur;
    @Column(name = "site_social")
    private String siteAuteur;
    @Column(name = "email_Auteur")
    private String emailAuteur;
    @Column(name = "actif")
    private boolean isActif;

    @OneToMany(mappedBy = "auteur")
    private List<LivreModel> livres = new ArrayList<>();
}
