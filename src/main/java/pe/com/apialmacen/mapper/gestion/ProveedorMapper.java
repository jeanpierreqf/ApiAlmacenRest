package pe.com.apialmacen.mapper.gestion;

import org.mapstruct.Mapper;
import pe.com.apialmacen.dto.gestion.ProveedorDTO;
import pe.com.apialmacen.entity.gestion.ProveedorEntity;
import pe.com.apialmacen.mapper.generic.GenericoMapper;

@Mapper(componentModel = "spring")
public interface ProveedorMapper extends GenericoMapper<ProveedorEntity, ProveedorDTO>{
    
}
