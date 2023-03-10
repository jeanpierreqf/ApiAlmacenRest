package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.apialmacen.entity.gestion.UsuariosEntity;


public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Long>{
    //podemos crear query personalizados
    @Query("select u from UsuariosEntity u where u.estado=1")
    List<UsuariosEntity> findAllCustom();
}
    

