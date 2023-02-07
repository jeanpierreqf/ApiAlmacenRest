package pe.com.apialmacen.service.impl.gestion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.apialmacen.entity.gestion.ProveedorEntity;
import pe.com.apialmacen.repository.gestion.ProveedoresRepository;
import pe.com.apialmacen.service.gestion.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
        private ProveedoresRepository repositorio;

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
        public ProveedorEntity update(ProveedorEntity t) {
            ProveedorEntity objproveeor = repositorio.getById(t.getCodigo());
            BeanUtils.copyProperties(t, objproveeor);
            return repositorio.save(objproveeor);
        }

        @Override
        public ProveedorEntity delete(ProveedorEntity t) {
            ProveedorEntity objproveeor = repositorio.getById(t.getCodigo());
            objproveeor.setEstado(false);
            return repositorio.save(objproveeor);
        }

    @Override
    public Optional<ProveedorEntity> findById(Long id) {
        return repositorio.findById(id);
    }

        

}
