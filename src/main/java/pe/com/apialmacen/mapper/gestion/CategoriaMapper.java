package pe.com.apialmacen.mapper.gestion;

import org.mapstruct.Mapper;
import pe.com.apialmacen.dto.gestion.CategoriaDTO;
import pe.com.apialmacen.entity.gestion.CategoriaEntity;
import pe.com.apialmacen.mapper.generic.GenericoMapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends GenericoMapper<CategoriaEntity, CategoriaDTO>{
    
}