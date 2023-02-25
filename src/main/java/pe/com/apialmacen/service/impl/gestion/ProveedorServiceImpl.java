package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.entity.gestion.ProveedorEntity;
import pe.com.apialmacen.repository.gestion.ProveedorRepository;
import pe.com.apialmacen.service.gestion.ProveedorService;



@Service
public class ProveedorServiceImpl implements ProveedorService{
    
    @Autowired
     private ProveedorRepository repositorio;

    @Override
    public List<ProveedorEntity> findAll() {
      return repositorio.findAll();        
    }

    @Override
    public List<ProveedorEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }
    
    @Override
    public ProveedorEntity add(ProveedorEntity t) {
        return repositorio.save(t);
    }

    @Override
    public Optional<ProveedorEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public ProveedorEntity update(ProveedorEntity t) {
        ProveedorEntity objproveedor=repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objproveedor);
        return repositorio.save(objproveedor);
    }

    @Override
    public ProveedorEntity delete(ProveedorEntity t) {
        ProveedorEntity objproveedor=repositorio.getById(t.getCodigo());
        objproveedor.setEstado(false);
        return repositorio.save(objproveedor);
    }   

    @Override
    public ProveedorEntity enable(ProveedorEntity t) {
                ProveedorEntity objproveedor=repositorio.getById(t.getCodigo());
        objproveedor.setEstado(true);
        return repositorio.save(objproveedor);
    }
}

