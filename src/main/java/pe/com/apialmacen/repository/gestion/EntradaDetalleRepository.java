package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.apialmacen.entity.gestion.EntradaDetalleEntity;
import pe.com.apialmacen.repository.generic.GenericoRepository;

public interface EntradaDetalleRepository extends GenericoRepository<EntradaDetalleEntity, Long>{
    
    //podemos crear query personalizados
    @Query("select ed from EntradaDetalleEntity ed where ed.estado=1")
    List<EntradaDetalleEntity> findAllCustom();
}
