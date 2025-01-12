package Maison.EditionLivres.rest.dto;

import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class LivreDto {

    private Long id;
    private String isbn;
    private String titre;
    private String illustration; //photo
    private String synopsis;
    private List<Integer> auteursId; //ManyToMany
    private Long collectionId;
    private String categorie; //Enum to String
    private String typeLivre;

    // livre numérique
    private LocalDate dateParutionNumerique;
    private Double prixNumerique;
    private Integer nbrPagesNumerique;

    // livre physique
    private LocalDate dateParutionPhysique;
    private Double prixPhysique;
    private Integer nbrPagesPhysique;

}



