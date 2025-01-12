package Maison.EditionLivres.infra.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("NUMERIQUE")
@Data
public class LivreNumerique extends LivreModel{

    @Column(name = "DATE_PARUTION")
    private LocalDate dateParutionNumerique;
    @Column(name = "PRIX")
    private Double prixNumerique;
    @Column(name="NOMBRE_PAGES")
    private Integer nbrPagesNumerique;
}
