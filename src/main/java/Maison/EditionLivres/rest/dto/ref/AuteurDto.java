package Maison.EditionLivres.rest.dto.ref;

import Maison.EditionLivres.infra.entities.LivreModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class AuteurDto {

    private int id;
    @NotBlank(message = "nom d'auteur obligatoire")
    private String nomAuteur;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String photoAuteur;
    private String biographieAuteur;
    private String siteAuteur;
    private String emailAuteur;
    private boolean isActif;
//    private List<LivreModel> livres = new ArrayList<>();
}
