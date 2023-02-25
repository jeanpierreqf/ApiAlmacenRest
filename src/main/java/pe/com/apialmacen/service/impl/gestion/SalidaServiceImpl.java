package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.entity.gestion.SalidaEntity;
import pe.com.apialmacen.repository.gestion.SalidaRepository;
import pe.com.apialmacen.service.gestion.SalidaService;

@Service
public class SalidaServiceImpl implements SalidaService{
    
    @Autowired
     private SalidaRepository repositorio;

    @Override
    public List<SalidaEntity> findAll() {
      return repositorio.findAll();        
    }

    @Override
    public List<SalidaEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }
    
    @Override
    public SalidaEntity add(SalidaEntity t) {
        return repositorio.save(t);
    }

    @Override
    public Optional<SalidaEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public SalidaEntity update(SalidaEntity t) {
        SalidaEntity objentrada=repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objentrada);
        return repositorio.save(objentrada);
    }

    @Override
    public SalidaEntity delete(SalidaEntity t) {
        SalidaEntity objsalida=repositorio.getById(t.getCodigo());
        objsalida.setEstado(false);
        return repositorio.save(objsalida);
    }   

    @Override
    public SalidaEntity enable(SalidaEntity t) {
                SalidaEntity objsalida=repositorio.getById(t.getCodigo());
        objsalida.setEstado(true);
        return repositorio.save(objsalida);
    }
    
}
