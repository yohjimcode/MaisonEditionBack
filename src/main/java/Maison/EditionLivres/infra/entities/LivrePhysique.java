package Maison.EditionLivres.infra.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("PHYSIQUE")
@Data
public class LivrePhysique extends LivreModel {

    @Column(name = "DATE_PARUTION_PHYSIQUE")
    private LocalDate dateParutionPhysique;
    @Column(name = "PRIX_PHYSIQUE")
    private Double prixPhysique;
    @Column(name="NOMBRE_PAGES_PHYSIQUE")
    private Integer nbrPagesPhysique;
}
