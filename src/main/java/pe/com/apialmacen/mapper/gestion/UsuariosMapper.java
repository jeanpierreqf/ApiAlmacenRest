package pe.com.apialmacen.mapper.gestion;

import org.mapstruct.Mapper;
import pe.com.apialmacen.dto.gestion.UsuarioDTO;
import pe.com.apialmacen.entity.gestion.UsuariosEntity;
import pe.com.apialmacen.mapper.generic.GenericoMapper;

@Mapper(componentModel = "spring")
public interface UsuariosMapper extends GenericoMapper<UsuariosEntity,UsuarioDTO>{
}
