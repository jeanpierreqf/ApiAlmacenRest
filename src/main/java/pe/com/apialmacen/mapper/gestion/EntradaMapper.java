
package pe.com.apialmacen.mapper.gestion;

import org.mapstruct.Mapper;
import pe.com.apialmacen.dto.gestion.EntradaDTO;
import pe.com.apialmacen.entity.gestion.EntradaEntity;
import pe.com.apialmacen.mapper.generic.GenericoMapper;

@Mapper(componentModel = "spring")
public interface EntradaMapper extends GenericoMapper<EntradaEntity, EntradaDTO>{
    
}
