package Maison.EditionLivres.service.mappers;
import Maison.EditionLivres.infra.entities.LivreModel;
import Maison.EditionLivres.rest.dto.LivreDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LivreMapper {

    LivreDto toDto (LivreModel livreModel);

    List<LivreDto> toDtoList(List<LivreModel> livres);


}
