package Maison.EditionLivres.service.mappers;

import Maison.EditionLivres.infra.entities.LivreModel;
import Maison.EditionLivres.infra.entities.LivreNumerique;
import Maison.EditionLivres.infra.entities.LivrePhysique;
import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import Maison.EditionLivres.rest.dto.LivreDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface LivreMapper {

    @Mapping(target = "auteursId", source = "auteurs", qualifiedByName = "mapAuteursToIds")
    @Mapping(target = "dateParutionNumerique", expression = "java(mapDateParutionNumerique(livreModel))")
    @Mapping(target = "prixNumerique", expression = "java(mapPrixNumerique(livreModel))")
    @Mapping(target = "nbrPagesNumerique", expression = "java(mapNbrPagesNumerique(livreModel))")
    @Mapping(target = "dateParutionPhysique", expression = "java(mapDateParutionPhysique(livreModel))")
    @Mapping(target = "prixPhysique", expression = "java(mapPrixPhysique(livreModel))")
    @Mapping(target = "nbrPagesPhysique", expression = "java(mapNbrPagesPhysique(livreModel))")
    LivreDto toDto(LivreModel livreModel);

    List<LivreDto> toDtoList(List<LivreModel> livres);

    // 🔥 Méthode pour mapper les auteurs en IDs
    @Named("mapAuteursToIds")
    static List<Integer> mapAuteursToIds(Set<AuteurModel> auteurs) {
        if (auteurs == null) {
            return null;
        }
        return auteurs.stream().map(AuteurModel::getId).collect(Collectors.toList());
    }

    default LocalDate mapDateParutionNumerique(LivreModel livre) {
        if (livre instanceof LivreNumerique numerique) {
            return numerique.getDateParutionNumerique();
        }
        return null;
    }

    default Double mapPrixNumerique(LivreModel livre) {
        if (livre instanceof LivreNumerique numerique){
            return numerique.getPrixNumerique();
        }
      return null;
    }

    default Integer mapNbrPagesNumerique(LivreModel livre) {
        if (livre instanceof LivreNumerique numerique){
            return numerique.getNbrPagesNumerique();
        }
        return null;
    }

    default LocalDate mapDateParutionPhysique(LivreModel livre) {
        if (livre instanceof LivrePhysique physique){
            return physique.getDateParutionPhysique();
        }
        return null;
    }

    default Double mapPrixPhysique(LivreModel livre) {
       if (livre instanceof LivrePhysique physique) {
           return physique.getPrixPhysique();
       }
       return null;
    }

    default Integer mapNbrPagesPhysique(LivreModel livre) {
        if(livre instanceof LivrePhysique physique){
            return physique.getNbrPagesPhysique();
        }
        return null;
    }
}
