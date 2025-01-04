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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivreDto {

    private Long id;

    @NotBlank(message = "isbn obligatoire")
    private String isbn;

    @NotBlank(message = "titre obligatoire")
    private String titre;

    private String illustration; //photo
    private LocalDate dateParution;
    private String synopsis;
    private double prix;
    private int nbrPages;

    private AuteurModel auteur;
}



