package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.dto.gestion.UsuarioDTO;
import pe.com.apialmacen.entity.gestion.UsuariosEntity;
import pe.com.apialmacen.repository.gestion.UsuariosRepository;
import pe.com.apialmacen.service.gestion.UsuariosService;
import pe.com.apialmacen.util.mapper.GenericoMapper;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository repositorio;

    @Autowired
    private GenericoMapper<UsuariosEntity, UsuarioDTO> categoriamapper;

    @Override
    public List<UsuarioDTO> findAll() {
        List<UsuariosEntity> lista = repositorio.findAll();
        return categoriamapper.ConvertirListaDTO(lista, UsuarioDTO.class);
    }

    @Override
    public List<UsuarioDTO> findAllCustom() {
        List<UsuariosEntity> lista = repositorio.findAllCustom();
        return categoriamapper.ConvertirListaDTO(lista, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO add(UsuarioDTO t) {
        UsuariosEntity objcategoria = categoriamapper.ConvertirEntity(t, UsuariosEntity.class);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO update(UsuarioDTO t) {
        UsuariosEntity objcategoria = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objcategoria);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO delete(UsuarioDTO t) {
        UsuariosEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(false);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), UsuarioDTO.class);

    }

    @Override
    public UsuarioDTO enable(UsuarioDTO t) {
        UsuariosEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(true);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO findById(Long id) {
        UsuariosEntity lista = repositorio.findById(id).get();
        return categoriamapper.ConvertirDTO(lista, UsuarioDTO.class);
    }
    

}
