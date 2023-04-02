package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.apialmacen.entity.gestion.ProveedorEntity;
import pe.com.apialmacen.repository.generic.GenericoRepository;

@Repository
public interface ProveedorRepository extends GenericoRepository<ProveedorEntity, Long>{
    //podemos crear query personalizados
    @Query("select d from ProveedorEntity d where d.estado=1")
    List<ProveedorEntity> findAllCustom();
}
    

