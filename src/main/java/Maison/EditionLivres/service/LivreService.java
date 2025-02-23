package Maison.EditionLivres.service;

import Maison.EditionLivres.infra.adaptaters.LivreJpaRepository;
import Maison.EditionLivres.infra.adaptaters.ref.AuteurJpaRepository;
import Maison.EditionLivres.infra.entities.LivreModel;
import Maison.EditionLivres.infra.entities.LivreNumerique;
import Maison.EditionLivres.infra.entities.LivrePhysique;
import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import Maison.EditionLivres.rest.dto.LivreDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class LivreService {

        private final LivreJpaRepository livreJpaRepository;
        private final AuteurJpaRepository auteurJpaRepository;

        public LivreService(LivreJpaRepository livreJpaRepository, AuteurJpaRepository auteurJpaRepository) {
            this.livreJpaRepository = livreJpaRepository;
            this.auteurJpaRepository = auteurJpaRepository;
        }

        public LivreDto addLivre(LivreDto livreDto) {

            LivreModel livreModel;

            if (livreJpaRepository.existsByIsbn(livreDto.getIsbn())) {
                throw new IllegalArgumentException("Isbn déjà présent");
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
                livreModel = livrePhysique;
            }  else {
                throw new IllegalArgumentException("Type de livre inconnu : " + livreDto.getTypeLivre());
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

            LivreModel savedLivre = livreJpaRepository.save(livreModel);

            // Conversion manuelle en DTO
            LivreDto savedLivreDto = new LivreDto();
            savedLivreDto.setId(savedLivre.getId());
            savedLivreDto.setIsbn(savedLivre.getIsbn());
            savedLivreDto.setTitre(savedLivre.getTitre());
            savedLivreDto.setIllustration(savedLivre.getIllustration());
            savedLivreDto.setSynopsis(savedLivre.getSynopsis());
            savedLivreDto.setCategorie(savedLivre.getCategorie().name());
            savedLivreDto.setAuteursId(savedLivre.getAuteurs().stream().map(AuteurModel::getId).collect(Collectors.toList()));

            if (savedLivre instanceof LivreNumerique) {
                LivreNumerique livreNumerique = (LivreNumerique) savedLivre;
                savedLivreDto.setDateParutionNumerique(livreNumerique.getDateParutionNumerique());
                savedLivreDto.setPrixNumerique(livreNumerique.getPrixNumerique());
                savedLivreDto.setNbrPagesNumerique(livreNumerique.getNbrPagesNumerique());
            } else if (savedLivre instanceof LivrePhysique) {
                LivrePhysique livrePhysique = (LivrePhysique) savedLivre;
                savedLivreDto.setDateParutionPhysique(livrePhysique.getDateParutionPhysique());
                savedLivreDto.setPrixPhysique(livrePhysique.getPrixPhysique());
                savedLivreDto.setNbrPagesPhysique(livrePhysique.getNbrPagesPhysique());
            }

            return savedLivreDto;
        }

        @Transactional
        public List<LivreDto> getAllLivre() {
            return livreJpaRepository.findAll().stream().map(livre -> {
                LivreDto livreDto = new LivreDto();
                livreDto.setId(livre.getId());
                livreDto.setIsbn(livre.getIsbn());
                livreDto.setTitre(livre.getTitre());
                livreDto.setIllustration(livre.getIllustration());
                livreDto.setSynopsis(livre.getSynopsis());
                livreDto.setCategorie(livre.getCategorie().name());
                livreDto.setAuteursId(livre.getAuteurs().stream().map(AuteurModel::getId).collect(Collectors.toList()));

                if (livre instanceof LivreNumerique) {
                    LivreNumerique livreNumerique = (LivreNumerique) livre;
                    livreDto.setDateParutionNumerique(livreNumerique.getDateParutionNumerique());
                    livreDto.setPrixNumerique(livreNumerique.getPrixNumerique());
                    livreDto.setNbrPagesNumerique(livreNumerique.getNbrPagesNumerique());
                } else if (livre instanceof LivrePhysique) {
                    LivrePhysique livrePhysique = (LivrePhysique) livre;
                    livreDto.setDateParutionPhysique(livrePhysique.getDateParutionPhysique());
                    livreDto.setPrixPhysique(livrePhysique.getPrixPhysique());
                    livreDto.setNbrPagesPhysique(livrePhysique.getNbrPagesPhysique());
                }

                return livreDto;
            }).collect(Collectors.toList());
        }

        @Transactional
        public Optional<LivreDto> getLivrebyId(Long id) {
            return livreJpaRepository.findById(id).map(livre -> {
                LivreDto livreDto = new LivreDto();
                livreDto.setId(livre.getId());
                livreDto.setIsbn(livre.getIsbn());
                livreDto.setTitre(livre.getTitre());
                livreDto.setIllustration(livre.getIllustration());
                livreDto.setSynopsis(livre.getSynopsis());
                livreDto.setCategorie(livre.getCategorie().name());
                livreDto.setAuteursId(livre.getAuteurs().stream().map(AuteurModel::getId).collect(Collectors.toList()));

                if (livre instanceof LivreNumerique) {
                    LivreNumerique livreNumerique = (LivreNumerique) livre;
                    livreDto.setDateParutionNumerique(livreNumerique.getDateParutionNumerique());
                    livreDto.setPrixNumerique(livreNumerique.getPrixNumerique());
                    livreDto.setNbrPagesNumerique(livreNumerique.getNbrPagesNumerique());
                } else if (livre instanceof LivrePhysique) {
                    LivrePhysique livrePhysique = (LivrePhysique) livre;
                    livreDto.setDateParutionPhysique(livrePhysique.getDateParutionPhysique());
                    livreDto.setPrixPhysique(livrePhysique.getPrixPhysique());
                    livreDto.setNbrPagesPhysique(livrePhysique.getNbrPagesPhysique());
                }

                return livreDto;
            });
        }

        public LivreDto deleteLivre(Long id) {
            LivreModel deleteLivre = livreJpaRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Le livre n'existe pas"));
            livreJpaRepository.deleteById(id);

            LivreDto deleteLivreDto = new LivreDto();
            deleteLivreDto.setId(deleteLivre.getId());
            deleteLivreDto.setIsbn(deleteLivre.getIsbn());
            deleteLivreDto.setTitre(deleteLivre.getTitre());
            deleteLivreDto.setIllustration(deleteLivre.getIllustration());
            deleteLivreDto.setSynopsis(deleteLivre.getSynopsis());
            deleteLivreDto.setCategorie(deleteLivre.getCategorie().name());
            deleteLivreDto.setAuteursId(deleteLivre.getAuteurs().stream().map(AuteurModel::getId).collect(Collectors.toList()));

            return deleteLivreDto;
        }
    }

