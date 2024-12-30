package Maison.EditionLivres.service;

import Maison.EditionLivres.infra.adaptaters.LivreJpaRepository;
import Maison.EditionLivres.infra.entities.LivreModel;
import Maison.EditionLivres.rest.dto.LivreDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LivreService {

    private LivreJpaRepository livreJpaRepository;

    public LivreService(LivreJpaRepository livreJpaRepository) {
        this.livreJpaRepository = livreJpaRepository;
    }

    public LivreModel addLivre(LivreDto livreDto) {
        if(livreJpaRepository.existsByIsbn(livreDto.getIsbn())){
           throw new IllegalArgumentException("Isbn déja présent");
        }
        LivreModel nouveauLivre =  new LivreModel();
        nouveauLivre.setIsbn(nouveauLivre.getIsbn());
        nouveauLivre.setTitre(nouveauLivre.getTitre());
        nouveauLivre.setIllustration(nouveauLivre.getIllustration());
        nouveauLivre.setSynopsis(nouveauLivre.getSynopsis());
        nouveauLivre.setPrix(nouveauLivre.getPrix());
        nouveauLivre.setAuteur(nouveauLivre.getAuteur());

        return livreJpaRepository.save(nouveauLivre);
    }
}
