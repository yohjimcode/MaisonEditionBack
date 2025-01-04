package Maison.EditionLivres.infra.adaptaters.ref;

import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuteurJpaRepository extends JpaRepository<AuteurModel,Integer> {

    boolean existsBynomAuteur(String nomAuteur);
}
