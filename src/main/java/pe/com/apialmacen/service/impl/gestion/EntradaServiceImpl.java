package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.dto.gestion.EntradaDTO;
import pe.com.apialmacen.entity.gestion.EntradaEntity;
import pe.com.apialmacen.repository.gestion.EntradaRepository;
import pe.com.apialmacen.service.gestion.EntradaService;
import pe.com.apialmacen.util.mapper.GenericoMapper;

@Service
public class EntradaServiceImpl implements EntradaService{
    @Autowired
    private EntradaRepository repositorio;

    @Autowired
    private GenericoMapper<EntradaEntity, EntradaDTO> categoriamapper;

    @Override
    public List<EntradaDTO> findAll() {
        List<EntradaEntity> lista = repositorio.findAll();
        return categoriamapper.ConvertirListaDTO(lista, EntradaDTO.class);
    }

    @Override
    public List<EntradaDTO> findAllCustom() {
        List<EntradaEntity> lista = repositorio.findAllCustom();
        return categoriamapper.ConvertirListaDTO(lista, EntradaDTO.class);
    }

    @Override
    public EntradaDTO add(EntradaDTO t) {
        EntradaEntity objcategoria = categoriamapper.ConvertirEntity(t, EntradaEntity.class);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), EntradaDTO.class);
    }

    @Override
    public EntradaDTO update(EntradaDTO t) {
        EntradaEntity objcategoria = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objcategoria);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), EntradaDTO.class);
    }

    @Override
    public EntradaDTO delete(EntradaDTO t) {
        EntradaEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(false);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), EntradaDTO.class);

    }

    @Override
    public EntradaDTO enable(EntradaDTO t) {
        EntradaEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(true);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), EntradaDTO.class);
    }

    @Override
    public EntradaDTO findById(Long id) {
        EntradaEntity lista = repositorio.findById(id).get();
        return categoriamapper.ConvertirDTO(lista, EntradaDTO.class);
    }
    

}
