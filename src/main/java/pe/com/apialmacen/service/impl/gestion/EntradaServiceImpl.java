package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.entity.gestion.EntradaEntity;
import pe.com.apialmacen.repository.gestion.EntradaRepository;
import pe.com.apialmacen.service.gestion.EntradaService;

@Service
public class EntradaServiceImpl implements EntradaService{
    @Autowired
     private EntradaRepository repositorio;

    @Override
    public List<EntradaEntity> findAll() {
      return repositorio.findAll();        
    }

    @Override
    public List<EntradaEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }
    
    @Override
    public EntradaEntity add(EntradaEntity t) {
        return repositorio.save(t);
    }

    @Override
    public Optional<EntradaEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public EntradaEntity update(EntradaEntity t) {
        EntradaEntity objentrada=repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objentrada);
        return repositorio.save(objentrada);
    }

    @Override
    public EntradaEntity delete(EntradaEntity t) {
        EntradaEntity objentrada=repositorio.getById(t.getCodigo());
        objentrada.setEstado(false);
        return repositorio.save(objentrada);
    }   

    @Override
    public EntradaEntity enable(EntradaEntity t) {
                EntradaEntity objentrada=repositorio.getById(t.getCodigo());
        objentrada.setEstado(true);
        return repositorio.save(objentrada);
    }
}
