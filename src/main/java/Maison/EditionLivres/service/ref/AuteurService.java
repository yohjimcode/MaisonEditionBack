package Maison.EditionLivres.service.ref;

import Maison.EditionLivres.infra.adaptaters.ref.AuteurJpaRepository;
import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import Maison.EditionLivres.rest.dto.ref.AuteurDto;
import org.springframework.stereotype.Service;

@Service
public class AuteurService {

    private final AuteurJpaRepository auteurJpaRepository;

    public AuteurService(AuteurJpaRepository auteurJpaRepository) {
        this.auteurJpaRepository = auteurJpaRepository;
    }

    public AuteurModel addAuteur(AuteurDto auteurDto) {
        if(auteurJpaRepository.existsBynomAuteur(auteurDto.getNomAuteur())){
            throw new IllegalArgumentException("Auteur déja existant");
        }
        AuteurModel nouvelAuteur =  new AuteurModel();
        nouvelAuteur.setNomAuteur(auteurDto.getNomAuteur());
        nouvelAuteur.setNom(auteurDto.getNom());
        nouvelAuteur.setPrenom(auteurDto.getPrenom());
        nouvelAuteur.setDateNaissance(auteurDto.getDateNaissance());
        nouvelAuteur.setPhotoAuteur(auteurDto.getPhotoAuteur());
        nouvelAuteur.setBiographieAuteur(auteurDto.getBiographieAuteur());
        nouvelAuteur.setSiteAuteur(auteurDto.getSiteAuteur());
        nouvelAuteur.setEmailAuteur(auteurDto.getEmailAuteur());
        nouvelAuteur.setActif(auteurDto.isActif());
        nouvelAuteur.setLivres(auteurDto.getLivres());

        return auteurJpaRepository.save(nouvelAuteur);
    }
}
