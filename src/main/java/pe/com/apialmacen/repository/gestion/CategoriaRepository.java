package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.apialmacen.entity.gestion.CategoriaEntity;
import pe.com.apialmacen.repository.generic.GenericoRepository;



@Repository
public interface CategoriaRepository extends GenericoRepository<CategoriaEntity, Long>{
    //podemos crear query personalizados
    @Query("select c from CategoriaEntity c where c.estado=1")
    List<CategoriaEntity> findAllCustom();
}