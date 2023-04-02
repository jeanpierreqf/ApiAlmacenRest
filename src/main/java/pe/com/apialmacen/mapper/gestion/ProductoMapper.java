package pe.com.apialmacen.mapper.gestion;

import org.mapstruct.Mapper;
import pe.com.apialmacen.dto.gestion.ProductoDTO;
import pe.com.apialmacen.entity.gestion.ProductoEntity;
import pe.com.apialmacen.mapper.generic.GenericoMapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper extends GenericoMapper<ProductoEntity, ProductoDTO>{
    
}
