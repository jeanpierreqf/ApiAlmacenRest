package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.dto.gestion.RolesDTO;
import pe.com.apialmacen.entity.gestion.RolesEntity;
import pe.com.apialmacen.repository.gestion.RolesRepository;
import pe.com.apialmacen.service.gestion.RolesService;
import pe.com.apialmacen.util.mapper.GenericoMapper;

@Service
public class RolesServiceImpl implements RolesService{
    
    @Autowired
    private RolesRepository repositorio;

    @Autowired
    private GenericoMapper<RolesEntity, RolesDTO> categoriamapper;

    @Override
    public List<RolesDTO> findAll() {
        List<RolesEntity> lista = repositorio.findAll();
        return categoriamapper.ConvertirListaDTO(lista, RolesDTO.class);
    }

    @Override
    public List<RolesDTO> findAllCustom() {
        List<RolesEntity> lista = repositorio.findAllCustom();
        return categoriamapper.ConvertirListaDTO(lista, RolesDTO.class);
    }

    @Override
    public RolesDTO add(RolesDTO t) {
        RolesEntity objcategoria = categoriamapper.ConvertirEntity(t, RolesEntity.class);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), RolesDTO.class);
    }

    @Override
    public RolesDTO update(RolesDTO t) {
        RolesEntity objcategoria = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objcategoria);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), RolesDTO.class);
    }

    @Override
    public RolesDTO delete(RolesDTO t) {
        RolesEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(false);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), RolesDTO.class);

    }

    @Override
    public RolesDTO enable(RolesDTO t) {
        RolesEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(true);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), RolesDTO.class);
    }

    @Override
    public RolesDTO findById(Long id) {
        RolesEntity lista = repositorio.findById(id).get();
        return categoriamapper.ConvertirDTO(lista, RolesDTO.class);
    }
    

}
