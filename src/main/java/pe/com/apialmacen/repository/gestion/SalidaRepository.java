package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.apialmacen.entity.gestion.SalidaEntity;

public interface SalidaRepository extends JpaRepository<SalidaEntity, Long>{
    @Query("select sr from SalidaEntity sr where sr.estado=1")
    List<SalidaEntity> findAllCustom();
    
}
