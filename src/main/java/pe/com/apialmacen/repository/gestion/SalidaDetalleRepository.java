package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.apialmacen.entity.gestion.SalidaDetalleEntity;

public interface SalidaDetalleRepository extends JpaRepository<SalidaDetalleEntity, Long>{
    
    //podemos crear query personalizados
    @Query("select c from SalidaDetalleEntity c where c.estado=1")
    List<SalidaDetalleEntity> findAllCustom();
}
