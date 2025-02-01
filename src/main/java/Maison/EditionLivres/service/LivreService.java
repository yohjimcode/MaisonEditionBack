package Maison.EditionLivres.service;

import Maison.EditionLivres.infra.adaptaters.LivreJpaRepository;
import Maison.EditionLivres.infra.adaptaters.ref.AuteurJpaRepository;
import Maison.EditionLivres.infra.entities.LivreModel;
import Maison.EditionLivres.infra.entities.LivreNumerique;
import Maison.EditionLivres.infra.entities.LivrePhysique;
import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import Maison.EditionLivres.rest.dto.LivreDto;
import Maison.EditionLivres.service.mappers.LivreMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class LivreService {

    private final LivreJpaRepository livreJpaRepository;
    private final AuteurJpaRepository auteurJpaRepository;

    private final LivreMapper livreMapper;

    LivreModel livreModel;


    public LivreService(LivreJpaRepository livreJpaRepository, AuteurJpaRepository auteurJpaRepository, LivreMapper livreMapper) {

        this.livreJpaRepository = livreJpaRepository;
        this.auteurJpaRepository = auteurJpaRepository;
        this.livreMapper = livreMapper;
    }

    public LivreDto addLivre(LivreDto livreDto) {

        if (livreJpaRepository.existsByIsbn(livreDto.getIsbn())) {
            throw new IllegalArgumentException("Isbn déja présent");
        }

        if (livreDto.getTypeLivre().equalsIgnoreCase("NUMERIQUE")) {
            LivreNumerique livreNumerique = new LivreNumerique();
            livreNumerique.setDateParutionNumerique(livreDto.getDateParutionNumerique());
            livreNumerique.setPrixNumerique(livreDto.getPrixNumerique());
            livreNumerique.setNbrPagesNumerique(livreDto.getNbrPagesNumerique());
            livreModel = livreNumerique;
        } else if (livreDto.getTypeLivre().equalsIgnoreCase("PHYSIQUE")) {
            LivrePhysique livrePhysique = new LivrePhysique();
            livrePhysique.setDateParutionPhysique(livreDto.getDateParutionPhysique());
            livrePhysique.setNbrPagesPhysique(livreDto.getNbrPagesPhysique());
            livrePhysique.setNbrPagesPhysique(livreDto.getNbrPagesPhysique());
            livreModel = livrePhysique;
        }

        livreModel.setIsbn(livreDto.getIsbn());
        livreModel.setTitre(livreDto.getTitre());
        livreModel.setIllustration(livreDto.getIllustration());
        livreModel.setSynopsis(livreDto.getSynopsis());
        livreModel.setCategorie(LivreModel.Categorie.valueOf(livreDto.getCategorie().toUpperCase()));

        List<Integer> auteursIds = livreDto.getAuteursId();
        Set<AuteurModel> auteurs = new HashSet<>(auteurJpaRepository.findAllById(auteursIds));
        if (auteurs.size() != auteursIds.size()) {
            throw new IllegalArgumentException("Certains auteurs fournis ne sont pas valides.");
        }
        livreModel.setAuteurs(auteurs);

        LivreModel savelivre = livreJpaRepository.save(livreModel);

        return livreMapper.toDto(savelivre);
    }

    public List<LivreDto> getAllLivre() {
        return livreMapper.toDtoList(livreJpaRepository.findAll());
    }

    public Optional<LivreDto> getLivrebyId(Long id) {
        return livreJpaRepository.findById(id).map(livreMapper::toDto);
    }

    public LivreDto deleteLivre(Long id) {
        LivreModel deleteLivre = livreJpaRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("le Livre n'existe pas "));
        livreJpaRepository.deleteById(id);
        return livreMapper.toDto(deleteLivre);
    }


}
