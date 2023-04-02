package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.dto.gestion.SalidaDTO;
import pe.com.apialmacen.entity.gestion.SalidaEntity;
import pe.com.apialmacen.repository.gestion.SalidaRepository;
import pe.com.apialmacen.service.gestion.SalidaService;
import pe.com.apialmacen.util.mapper.GenericoMapper;

@Service
public class SalidaServiceImpl implements SalidaService{
    
    @Autowired
    private SalidaRepository repositorio;

    @Autowired
    private GenericoMapper<SalidaEntity, SalidaDTO> categoriamapper;

    @Override
    public List<SalidaDTO> findAll() {
        List<SalidaEntity> lista = repositorio.findAll();
        return categoriamapper.ConvertirListaDTO(lista, SalidaDTO.class);
    }

    @Override
    public List<SalidaDTO> findAllCustom() {
        List<SalidaEntity> lista = repositorio.findAllCustom();
        return categoriamapper.ConvertirListaDTO(lista, SalidaDTO.class);
    }

    @Override
    public SalidaDTO add(SalidaDTO t) {
        SalidaEntity objcategoria = categoriamapper.ConvertirEntity(t, SalidaEntity.class);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), SalidaDTO.class);
    }

    @Override
    public SalidaDTO update(SalidaDTO t) {
        SalidaEntity objcategoria = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objcategoria);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), SalidaDTO.class);
    }

    @Override
    public SalidaDTO delete(SalidaDTO t) {
        SalidaEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(false);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), SalidaDTO.class);

    }

    @Override
    public SalidaDTO enable(SalidaDTO t) {
        SalidaEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(true);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), SalidaDTO.class);
    }

    @Override
    public SalidaDTO findById(Long id) {
        SalidaEntity lista = repositorio.findById(id).get();
        return categoriamapper.ConvertirDTO(lista, SalidaDTO.class);
    }
    

}
