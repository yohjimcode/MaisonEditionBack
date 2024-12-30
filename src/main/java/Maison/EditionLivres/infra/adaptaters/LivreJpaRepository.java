package Maison.EditionLivres.infra.adaptaters;

import Maison.EditionLivres.infra.entities.LivreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface LivreJpaRepository extends JpaRepository<LivreModel,Long> {

}
