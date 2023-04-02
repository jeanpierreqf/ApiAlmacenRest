package pe.com.apialmacen.repository.gestion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.apialmacen.entity.gestion.ProductoEntity;
import pe.com.apialmacen.repository.generic.GenericoRepository;

@Repository
public interface ProductoRepository extends GenericoRepository<ProductoEntity, Long>{
    @Query("select p from ProductoEntity p where p.estado=1")
    List<ProductoEntity> findAllCustom();
}