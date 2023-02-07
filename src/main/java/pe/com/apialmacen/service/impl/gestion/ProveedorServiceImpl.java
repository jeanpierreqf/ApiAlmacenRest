
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
        public ProveedorEntity add(ProveedorEntity p) {
            return repositorio.save(p);
        }

        @Override
        public Optional<ProveedorEntity> findById(long id) {
            return repositorio.findById(id);
        }

        @Override
        public ProveedorEntity update(ProveedorEntity p) {
            ProveedorEntity objproveeor = repositorio.getById(p.getCodigo());
            BeanUtils.copyProperties(p, objproveeor);
            return repositorio.save(objproveeor);
        }

        @Override
        public ProveedorEntity delete(ProveedorEntity p) {
            ProveedorEntity objproveeor = repositorio.getById(p.getCodigo());
            objproveeor.setEstado(false);
            return repositorio.save(objproveeor);
        }

        

}
