package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.apialmacen.entity.gestion.UsuariosEntity;
import pe.com.apialmacen.repository.generic.GenericoRepository;


public interface UsuariosRepository extends GenericoRepository<UsuariosEntity, Long>{
    //podemos crear query personalizados
    @Query("select u from UsuariosEntity u where u.estado=1")
    List<UsuariosEntity> findAllCustom();
}
    

