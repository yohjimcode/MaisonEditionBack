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

    // 🔥 Gestion des champs spécifiques aux livres numériques
    default LocalDate mapDateParutionNumerique(LivreModel livre) {
        return (livre instanceof LivreNumerique) ? ((LivreNumerique) livre).getDateParutionNumerique() : null;
    }

    default Double mapPrixNumerique(LivreModel livre) {
        return (livre instanceof LivreNumerique) ? ((LivreNumerique) livre).getPrixNumerique() : null;
    }

    default Integer mapNbrPagesNumerique(LivreModel livre) {
        return (livre instanceof LivreNumerique) ? ((LivreNumerique) livre).getNbrPagesNumerique() : null;
    }

    // 🔥 Gestion des champs spécifiques aux livres physiques
    default LocalDate mapDateParutionPhysique(LivreModel livre) {
        return (livre instanceof LivrePhysique) ? ((LivrePhysique) livre).getDateParutionPhysique() : null;
    }

    default Double mapPrixPhysique(LivreModel livre) {
        return (livre instanceof LivrePhysique) ? ((LivrePhysique) livre).getPrixPhysique() : null;
    }

    default Integer mapNbrPagesPhysique(LivreModel livre) {
        return (livre instanceof LivrePhysique) ? ((LivrePhysique) livre).getNbrPagesPhysique() : null;
    }
}
