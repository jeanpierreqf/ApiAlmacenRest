package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.dto.gestion.SalidaDetalleDTO;
import pe.com.apialmacen.entity.gestion.SalidaDetalleEntity;
import pe.com.apialmacen.repository.gestion.SalidaDetalleRepository;
import pe.com.apialmacen.service.gestion.SalidaDetalleService;
import pe.com.apialmacen.util.mapper.GenericoMapper;

@Service
public class SalidaDetalleServiceImpl implements SalidaDetalleService{
    
    @Autowired
    private SalidaDetalleRepository repositorio;

    @Autowired
    private GenericoMapper<SalidaDetalleEntity, SalidaDetalleDTO> categoriamapper;

    @Override
    public List<SalidaDetalleDTO> findAll() {
        List<SalidaDetalleEntity> lista = repositorio.findAll();
        return categoriamapper.ConvertirListaDTO(lista, SalidaDetalleDTO.class);
    }

    @Override
    public List<SalidaDetalleDTO> findAllCustom() {
        List<SalidaDetalleEntity> lista = repositorio.findAllCustom();
        return categoriamapper.ConvertirListaDTO(lista, SalidaDetalleDTO.class);
    }

    @Override
    public SalidaDetalleDTO add(SalidaDetalleDTO t) {
        SalidaDetalleEntity objcategoria = categoriamapper.ConvertirEntity(t, SalidaDetalleEntity.class);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), SalidaDetalleDTO.class);
    }

    @Override
    public SalidaDetalleDTO update(SalidaDetalleDTO t) {
        SalidaDetalleEntity objcategoria = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objcategoria);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), SalidaDetalleDTO.class);
    }

    @Override
    public SalidaDetalleDTO delete(SalidaDetalleDTO t) {
        SalidaDetalleEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(false);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), SalidaDetalleDTO.class);

    }

    @Override
    public SalidaDetalleDTO enable(SalidaDetalleDTO t) {
        SalidaDetalleEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(true);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), SalidaDetalleDTO.class);
    }

    @Override
    public SalidaDetalleDTO findById(Long id) {
        SalidaDetalleEntity lista = repositorio.findById(id).get();
        return categoriamapper.ConvertirDTO(lista, SalidaDetalleDTO.class);
    }
    

}
