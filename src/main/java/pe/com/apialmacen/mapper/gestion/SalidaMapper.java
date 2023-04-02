package pe.com.apialmacen.mapper.gestion;

import org.mapstruct.Mapper;
import pe.com.apialmacen.dto.gestion.SalidaDTO;
import pe.com.apialmacen.entity.gestion.SalidaEntity;
import pe.com.apialmacen.mapper.generic.GenericoMapper;

@Mapper(componentModel = "spring")
public interface SalidaMapper extends GenericoMapper<SalidaEntity, SalidaDTO>{
    
}
