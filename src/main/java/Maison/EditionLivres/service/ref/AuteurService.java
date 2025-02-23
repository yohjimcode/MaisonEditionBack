package Maison.EditionLivres.service.ref;

import Maison.EditionLivres.infra.adaptaters.ref.AuteurJpaRepository;
import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import Maison.EditionLivres.rest.dto.ref.AuteurDto;
import Maison.EditionLivres.service.mappers.AuteurMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class AuteurService {

    private final AuteurJpaRepository auteurJpaRepository;
    private final AuteurMapper auteurMapper;

    public AuteurService(AuteurJpaRepository auteurJpaRepository, AuteurMapper auteurMapper) {
        this.auteurJpaRepository = auteurJpaRepository;
        this.auteurMapper = auteurMapper;
    }

    public AuteurModel addAuteur(AuteurDto auteurDto) {
        if (auteurJpaRepository.existsBynomAuteur(auteurDto.getNomAuteur())) {
            throw new IllegalArgumentException("Auteur déjà existant");
        }

        AuteurModel nouvelAuteur = auteurMapper.toEntity(auteurDto);
        return auteurJpaRepository.save(nouvelAuteur);
    }

    public List<AuteurDto> getAllAuteurs() {
        return auteurJpaRepository.findAll().stream()
                .map(auteurMapper::toDto)
                .collect(Collectors.toList());
    }

    public AuteurDto getAuteurById(int id) {
        return auteurJpaRepository.findById(id)
                .map(auteurMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Auteur non trouvé"));
    }

}
