
package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.dto.gestion.ProductoDTO;
import pe.com.apialmacen.entity.gestion.ProductoEntity;
import pe.com.apialmacen.repository.gestion.ProductoRepository;
import pe.com.apialmacen.service.gestion.ProductoService;
import pe.com.apialmacen.util.mapper.GenericoMapper;


@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repositorio;

    @Autowired
    private GenericoMapper<ProductoEntity, ProductoDTO> categoriamapper;

    @Override
    public List<ProductoDTO> findAll() {
        List<ProductoEntity> lista = repositorio.findAll();
        return categoriamapper.ConvertirListaDTO(lista, ProductoDTO.class);
    }

    @Override
    public List<ProductoDTO> findAllCustom() {
        List<ProductoEntity> lista = repositorio.findAllCustom();
        return categoriamapper.ConvertirListaDTO(lista, ProductoDTO.class);
    }

    @Override
    public ProductoDTO add(ProductoDTO t) {
        ProductoEntity objcategoria = categoriamapper.ConvertirEntity(t, ProductoEntity.class);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), ProductoDTO.class);
    }

    @Override
    public ProductoDTO update(ProductoDTO t) {
        ProductoEntity objcategoria = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objcategoria);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), ProductoDTO.class);
    }

    @Override
    public ProductoDTO delete(ProductoDTO t) {
        ProductoEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(false);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), ProductoDTO.class);

    }

    @Override
    public ProductoDTO enable(ProductoDTO t) {
        ProductoEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(true);
        return categoriamapper.ConvertirDTO(repositorio.save(objcategoria), ProductoDTO.class);
    }

    @Override
    public ProductoDTO findById(Long id) {
        ProductoEntity lista = repositorio.findById(id).get();
        return categoriamapper.ConvertirDTO(lista, ProductoDTO.class);
    }
    

}
