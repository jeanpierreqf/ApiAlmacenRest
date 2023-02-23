package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.entity.gestion.CategoriaEntity;
import pe.com.apialmacen.repository.gestion.CategoriaRepository;
import pe.com.apialmacen.service.gestion.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
     private CategoriaRepository repositorio;

    @Override
    public List<CategoriaEntity> findAll() {
      return repositorio.findAll();        
    }

    @Override
    public List<CategoriaEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }
    
    @Override
    public CategoriaEntity add(CategoriaEntity t) {
        return repositorio.save(t);
    }

    @Override
    public Optional<CategoriaEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public CategoriaEntity update(CategoriaEntity t) {
        CategoriaEntity objcategoria=repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objcategoria);
        return repositorio.save(objcategoria);
    }

    @Override
    public CategoriaEntity delete(CategoriaEntity t) {
        CategoriaEntity objcategoria=repositorio.getById(t.getCodigo());
        objcategoria.setEstado(false);
        return repositorio.save(objcategoria);
    }   

    @Override
    public CategoriaEntity enable(CategoriaEntity t) {
                CategoriaEntity objcategoria=repositorio.getById(t.getCodigo());
        objcategoria.setEstado(true);
        return repositorio.save(objcategoria);
    }
}
