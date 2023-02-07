package pe.com.apialmacen.repository.gestion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
    @Query("select p from ProductoEntity p where p.estado=1")
    List<ProductoEntity> findAllCustom();
}