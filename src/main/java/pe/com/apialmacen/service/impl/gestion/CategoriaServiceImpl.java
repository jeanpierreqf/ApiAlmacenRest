package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.dto.gestion.CategoriaDTO;
import pe.com.apialmacen.entity.gestion.CategoriaEntity;
import pe.com.apialmacen.repository.gestion.CategoriaRepository;
import pe.com.apialmacen.service.gestion.CategoriaService;
import pe.com.apialmacen.util.mapper.GenericoMapper;

@RequiredArgsConstructor
@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repositorio;

    @Autowired
    private GenericoMapper<CategoriaEntity, CategoriaDTO> categoriamapper;

    @Override
    public List<CategoriaDTO> findAll() {
        List<CategoriaEntity> lista = repositorio.findAll();
        return categoriamapper.ConvertirListaDTO(lista, CategoriaDTO.class);
    }

    @Override
    public List<CategoriaDTO> findAllCustom() {
        List<CategoriaEntity> lista = repositorio.findAllCustom();
        return categoriamapper.ConvertirListaDTO(lista, CategoriaDTO.class);
    }

    @Override
    public CategoriaDTO add(CategoriaDTO t) {
        CategoriaEntity objcategoria = categoriamapper.ConvertirEntity(t, CategoriaEntity.class);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), CategoriaDTO.class);
    }

    @Override
    public CategoriaDTO update(CategoriaDTO t) {
        CategoriaEntity objcategoria = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objcategoria);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), CategoriaDTO.class);
    }

    @Override
    public CategoriaDTO delete(CategoriaDTO t) {
        CategoriaEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(false);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), CategoriaDTO.class);

    }

    @Override
    public CategoriaDTO enable(CategoriaDTO t) {
        CategoriaEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(true);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), CategoriaDTO.class);
    }

    @Override
    public CategoriaDTO findById(Long id) {
        CategoriaEntity lista = repositorio.findById(id).get();
        return categoriamapper.ConvertirDTO(lista, CategoriaDTO.class);
    }
    

}
