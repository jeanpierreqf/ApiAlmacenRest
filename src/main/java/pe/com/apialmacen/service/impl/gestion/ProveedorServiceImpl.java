package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.dto.gestion.ProveedorDTO;
import pe.com.apialmacen.entity.gestion.ProveedorEntity;
import pe.com.apialmacen.repository.gestion.ProveedorRepository;
import pe.com.apialmacen.service.gestion.ProveedorService;
import pe.com.apialmacen.util.mapper.GenericoMapper;



@Service
public class ProveedorServiceImpl implements ProveedorService{
    
    @Autowired
    private ProveedorRepository repositorio;

    @Autowired
    private GenericoMapper<ProveedorEntity, ProveedorDTO> categoriamapper;

    @Override
    public List<ProveedorDTO> findAll() {
        List<ProveedorEntity> lista = repositorio.findAll();
        return categoriamapper.ConvertirListaDTO(lista, ProveedorDTO.class);
    }

    @Override
    public List<ProveedorDTO> findAllCustom() {
        List<ProveedorEntity> lista = repositorio.findAllCustom();
        return categoriamapper.ConvertirListaDTO(lista, ProveedorDTO.class);
    }

    @Override
    public ProveedorDTO add(ProveedorDTO t) {
        ProveedorEntity objcategoria = categoriamapper.ConvertirEntity(t, ProveedorEntity.class);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), ProveedorDTO.class);
    }

    @Override
    public ProveedorDTO update(ProveedorDTO t) {
        ProveedorEntity objcategoria = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objcategoria);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), ProveedorDTO.class);
    }

    @Override
    public ProveedorDTO delete(ProveedorDTO t) {
        ProveedorEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(false);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), ProveedorDTO.class);

    }

    @Override
    public ProveedorDTO enable(ProveedorDTO t) {
        ProveedorEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(true);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), ProveedorDTO.class);
    }

    @Override
    public ProveedorDTO findById(Long id) {
        ProveedorEntity lista = repositorio.findById(id).get();
        return categoriamapper.ConvertirDTO(lista, ProveedorDTO.class);
    }
    

}
