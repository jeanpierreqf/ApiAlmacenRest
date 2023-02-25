package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.entity.gestion.UsuariosEntity;
import pe.com.apialmacen.repository.gestion.UsuariosRepository;
import pe.com.apialmacen.service.gestion.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository repositorio;

    @Override
    public List<UsuariosEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<UsuariosEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public UsuariosEntity add(UsuariosEntity t) {
        return repositorio.save(t);
    }

    @Override
    public Optional<UsuariosEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public UsuariosEntity update(UsuariosEntity t) {
        UsuariosEntity objusuarios = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, objusuarios);
        return repositorio.save(objusuarios);
    }

    @Override
    public UsuariosEntity delete(UsuariosEntity t) {
        UsuariosEntity objusuarios = repositorio.getById(t.getCodigo());
        objusuarios.setEstado(false);
        return repositorio.save(objusuarios);
    }

    @Override
    public UsuariosEntity enable(UsuariosEntity t) {
        UsuariosEntity objusuarios = repositorio.getById(t.getCodigo());
        objusuarios.setEstado(true);
        return repositorio.save(objusuarios);
    }
}