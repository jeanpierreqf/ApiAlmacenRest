package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.apialmacen.entity.gestion.EntradaDetalleEntity;
import pe.com.apialmacen.repository.gestion.EntradaDetalleRepository;
import pe.com.apialmacen.service.gestion.EntradaDetalleService;

public class EntradaDetalleServiceImpl implements EntradaDetalleService{
    
    @Autowired
     private EntradaDetalleRepository repositorio;

    @Override
    public List<EntradaDetalleEntity> findAll() {
      return repositorio.findAll();        
    }

    @Override
    public List<EntradaDetalleEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }
    
    @Override
    public EntradaDetalleEntity add(EntradaDetalleEntity t) {
        return repositorio.save(t);
    }

    @Override
    public Optional<EntradaDetalleEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public EntradaDetalleEntity update(EntradaDetalleEntity t) {
        EntradaDetalleEntity objentrada=repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objentrada);
        return repositorio.save(objentrada);
    }

    @Override
    public EntradaDetalleEntity delete(EntradaDetalleEntity t) {
        EntradaDetalleEntity objentrada=repositorio.getById(t.getCodigo());
        objentrada.setEstado(false);
        return repositorio.save(objentrada);
    }   

    @Override
    public EntradaDetalleEntity enable(EntradaDetalleEntity t) {
                EntradaDetalleEntity objentrada=repositorio.getById(t.getCodigo());
        objentrada.setEstado(true);
        return repositorio.save(objentrada);
    }
}
