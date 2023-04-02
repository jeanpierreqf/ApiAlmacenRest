package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.apialmacen.entity.gestion.EntradaEntity;
import pe.com.apialmacen.repository.generic.GenericoRepository;

@Repository
public interface EntradaRepository extends GenericoRepository<EntradaEntity, Long>{
    @Query("select e from EntradaEntity e where e.estado=1")
    List<EntradaEntity> findAllCustom();
}
    

