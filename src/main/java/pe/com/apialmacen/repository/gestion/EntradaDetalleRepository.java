package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.apialmacen.entity.gestion.EntradaDetalleEntity;

public interface EntradaDetalleRepository extends JpaRepository<EntradaDetalleEntity, Long>{
    
    //podemos crear query personalizados
    @Query("select c from EntradaDetalleEntity c where c.estado=1")
    List<EntradaDetalleEntity> findAllCustom();
}