package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.entity.gestion.RolesEntity;
import pe.com.apialmacen.repository.gestion.RolesRepository;
import pe.com.apialmacen.service.gestion.RolesService;

@Service
public class RolesServiceImpl implements RolesService{
    
    @Autowired
     private RolesRepository repositorio;

    @Override
    public List<RolesEntity> findAll() {
      return repositorio.findAll();        
    }

    @Override
    public List<RolesEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }
    
    @Override
    public RolesEntity add(RolesEntity t) {
        return repositorio.save(t);
    }

    @Override
    public Optional<RolesEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public RolesEntity update(RolesEntity t) {
        RolesEntity objroles=repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objroles);
        return repositorio.save(objroles);
    }

    @Override
    public RolesEntity delete(RolesEntity t) {
        RolesEntity objroles=repositorio.getById(t.getCodigo());
        objroles.setEstado(false);
        return repositorio.save(objroles);
    }   

    @Override
    public RolesEntity enable(RolesEntity t) {
                RolesEntity objroles=repositorio.getById(t.getCodigo());
        objroles.setEstado(true);
        return repositorio.save(objroles);
    }
 }

