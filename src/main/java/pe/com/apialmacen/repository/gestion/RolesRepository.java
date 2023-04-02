package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.apialmacen.entity.gestion.RolesEntity;
import pe.com.apialmacen.repository.generic.GenericoRepository;

@Repository
public interface RolesRepository extends GenericoRepository<RolesEntity, Long>{
    //podemos crear query personalizados
    @Query("select r from RolesEntity r where r.estado=1")
    List<RolesEntity> findAllCustom();
}
