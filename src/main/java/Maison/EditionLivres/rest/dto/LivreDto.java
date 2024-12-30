package Maison.EditionLivres.rest.dto;

import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivreDto {

    private Long id;
    private String isbn;
    private String titre;
    private String illustration; //photo
    private LocalDate dateParution;
    private String synopsis;
    private double prix;
    private Long recommandation;
    private AuteurModel auteur;
}



