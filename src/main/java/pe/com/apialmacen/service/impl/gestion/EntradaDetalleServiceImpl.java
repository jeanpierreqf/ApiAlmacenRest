package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.dto.gestion.EntradaDetalleDTO;
import pe.com.apialmacen.entity.gestion.EntradaDetalleEntity;
import pe.com.apialmacen.util.mapper.GenericoMapper;
import pe.com.apialmacen.repository.gestion.EntradaDetalleRepository;
import pe.com.apialmacen.service.gestion.EntradaDetalleService;

@Service
public class EntradaDetalleServiceImpl implements EntradaDetalleService{
    
    @Autowired
    private EntradaDetalleRepository repositorio;

    @Autowired
    private GenericoMapper<EntradaDetalleEntity, EntradaDetalleDTO> categoriamapper;

    @Override
    public List<EntradaDetalleDTO> findAll() {
        List<EntradaDetalleEntity> lista = repositorio.findAll();
        return categoriamapper.ConvertirListaDTO(lista, EntradaDetalleDTO.class);
    }

    @Override
    public List<EntradaDetalleDTO> findAllCustom() {
        List<EntradaDetalleEntity> lista = repositorio.findAllCustom();
        return categoriamapper.ConvertirListaDTO(lista, EntradaDetalleDTO.class);
    }

    @Override
    public EntradaDetalleDTO add(EntradaDetalleDTO t) {
        EntradaDetalleEntity objcategoria = categoriamapper.ConvertirEntity(t, EntradaDetalleEntity.class);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), EntradaDetalleDTO.class);
    }

    @Override
    public EntradaDetalleDTO update(EntradaDetalleDTO t) {
        EntradaDetalleEntity objcategoria = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objcategoria);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), EntradaDetalleDTO.class);
    }

    @Override
    public EntradaDetalleDTO delete(EntradaDetalleDTO t) {
        EntradaDetalleEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(false);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), EntradaDetalleDTO.class);

    }

    @Override
    public EntradaDetalleDTO enable(EntradaDetalleDTO t) {
        EntradaDetalleEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(true);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), EntradaDetalleDTO.class);
    }

    @Override
    public EntradaDetalleDTO findById(Long id) {
        EntradaDetalleEntity lista = repositorio.findById(id).get();
        return categoriamapper.ConvertirDTO(lista, EntradaDetalleDTO.class);
    }
    

}
