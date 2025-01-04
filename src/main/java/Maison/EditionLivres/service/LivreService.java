package Maison.EditionLivres.service;

import Maison.EditionLivres.infra.adaptaters.LivreJpaRepository;
import Maison.EditionLivres.infra.adaptaters.ref.AuteurJpaRepository;
import Maison.EditionLivres.infra.entities.LivreModel;
import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import Maison.EditionLivres.rest.dto.LivreDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LivreService {

    private final LivreJpaRepository livreJpaRepository;

    private final AuteurJpaRepository auteurJpaRepository;

    public LivreService(LivreJpaRepository livreJpaRepository, AuteurJpaRepository auteurJpaRepository) {

        this.livreJpaRepository = livreJpaRepository;
        this.auteurJpaRepository = auteurJpaRepository;
    }

    public LivreModel addLivre(LivreDto livreDto) {

        AuteurModel auteur = auteurJpaRepository.findById(livreDto.getAuteur().getId())
                .orElseThrow(() -> new IllegalArgumentException("Auteur introuvable avec l'ID : " + livreDto.getAuteur().getId()));

        if(livreJpaRepository.existsByIsbn(livreDto.getIsbn())){
           throw new IllegalArgumentException("Isbn déja présent");
        }

        LivreModel nouveauLivre =  new LivreModel();
        nouveauLivre.setIsbn(livreDto.getIsbn());
        nouveauLivre.setTitre(livreDto.getTitre());
        nouveauLivre.setIllustration(livreDto.getIllustration());
        nouveauLivre.setSynopsis(livreDto.getSynopsis());
        nouveauLivre.setPrix(livreDto.getPrix());
        nouveauLivre.setDateParution(livreDto.getDateParution());
        nouveauLivre.setNbrPages(livreDto.getNbrPages());
        nouveauLivre.setAuteur(auteur);

        return livreJpaRepository.save(nouveauLivre);
    }
}
