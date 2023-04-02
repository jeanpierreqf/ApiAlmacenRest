package pe.com.apialmacen.mapper.gestion;

import org.mapstruct.Mapper;
import pe.com.apialmacen.dto.gestion.SalidaDetalleDTO;
import pe.com.apialmacen.entity.gestion.SalidaDetalleEntity;
import pe.com.apialmacen.mapper.generic.GenericoMapper;

@Mapper(componentModel = "spring")
public interface SalidaDetalleMapper extends GenericoMapper<SalidaDetalleEntity, SalidaDetalleDTO> {
    
}
