
package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.entity.gestion.ProductoEntity;
import pe.com.apialmacen.repository.gestion.ProductoRepository;
import pe.com.apialmacen.service.gestion.ProductoService;


@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repositorio;

    @Override
    public List<ProductoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ProductoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public ProductoEntity add(ProductoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public Optional<ProductoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public ProductoEntity update(ProductoEntity t) {
        ProductoEntity objcategoria = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objcategoria);
        return repositorio.save(objcategoria);
    }

    @Override
    public ProductoEntity delete(ProductoEntity t) {
        ProductoEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(false);
        return repositorio.save(objcategoria);
    }

    @Override
    public ProductoEntity enable(ProductoEntity t) {
        ProductoEntity objcategoria = repositorio.getById(t.getCodigo());
        objcategoria.setEstado(true);
        return repositorio.save(objcategoria);
    }
}
