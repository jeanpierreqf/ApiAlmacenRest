package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.apialmacen.entity.gestion.EntradaEntity;

@Repository
public interface EntradaRepository extends JpaRepository<EntradaEntity, Long>{
    @Query("select e from EntradaEntity e where e.estado=1")
    List<EntradaEntity> findAllCustom();
}
    

