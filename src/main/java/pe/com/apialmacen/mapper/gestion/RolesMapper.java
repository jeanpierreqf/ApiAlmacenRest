
package pe.com.apialmacen.mapper.gestion;

import org.mapstruct.Mapper;
import pe.com.apialmacen.dto.gestion.RolesDTO;
import pe.com.apialmacen.entity.gestion.RolesEntity;
import pe.com.apialmacen.mapper.generic.GenericoMapper;

@Mapper(componentModel = "spring")
public interface RolesMapper extends GenericoMapper<RolesEntity, RolesDTO>{
    
}
