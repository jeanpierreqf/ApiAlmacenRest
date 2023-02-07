
package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.apialmacen.entity.gestion.ProveedorEntity;


 
public interface ProveedoresRepository extends JpaRepository<ProveedorEntity, Long>{
    //podemos crear query personalizados
    @Query("select c from CategoriaEntity c where c.estado=1")
    List<ProveedorEntity> findAllCustom();
}
    

