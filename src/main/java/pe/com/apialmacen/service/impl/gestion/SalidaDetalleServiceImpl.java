package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.entity.gestion.SalidaDetalleEntity;
import pe.com.apialmacen.repository.gestion.SalidaDetalleRepository;
import pe.com.apialmacen.service.gestion.SalidaDetalleService;

@Service
public class SalidaDetalleServiceImpl implements SalidaDetalleService{
    
    @Autowired
     private SalidaDetalleRepository repositorio;

    @Override
    public List<SalidaDetalleEntity> findAll() {
      return repositorio.findAll();        
    }

    @Override
    public List<SalidaDetalleEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }
    
    @Override
    public SalidaDetalleEntity add(SalidaDetalleEntity t) {
        return repositorio.save(t);
    }

    @Override
    public Optional<SalidaDetalleEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public SalidaDetalleEntity update(SalidaDetalleEntity t) {
        SalidaDetalleEntity objproveedor=repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objproveedor);
        return repositorio.save(objproveedor);
    }

    @Override
    public SalidaDetalleEntity delete(SalidaDetalleEntity t) {
        SalidaDetalleEntity objproveedor=repositorio.getById(t.getCodigo());
        objproveedor.setEstado(false);
        return repositorio.save(objproveedor);
    }   

    @Override
    public SalidaDetalleEntity enable(SalidaDetalleEntity t) {
                SalidaDetalleEntity objproveedor=repositorio.getById(t.getCodigo());
        objproveedor.setEstado(true);
        return repositorio.save(objproveedor);
    }
    
}
