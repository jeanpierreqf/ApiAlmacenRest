
package pe.com.apialmacen.mapper.gestion;

import org.mapstruct.Mapper;
import pe.com.apialmacen.dto.gestion.EntradaDetalleDTO;
import pe.com.apialmacen.entity.gestion.EntradaDetalleEntity;
import pe.com.apialmacen.mapper.generic.GenericoMapper;

@Mapper(componentModel = "spring")
public interface EntradaDetalleMapper extends GenericoMapper<EntradaDetalleEntity, EntradaDetalleDTO>{
    
}
