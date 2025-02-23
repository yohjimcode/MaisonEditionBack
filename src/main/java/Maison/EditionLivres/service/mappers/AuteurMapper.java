package Maison.EditionLivres.service.mappers;

import Maison.EditionLivres.infra.entities.ref.AuteurModel;
import Maison.EditionLivres.rest.dto.ref.AuteurDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuteurMapper {

    AuteurMapper INSTANCE = Mappers.getMapper(AuteurMapper.class);

    AuteurDto toDto(AuteurModel auteurModel);

    AuteurModel toEntity(AuteurDto auteurDto);
}
