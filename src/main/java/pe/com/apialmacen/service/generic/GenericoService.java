package pe.com.apialmacen.service.generic;

import java.util.List;
import java.util.Optional;

public interface GenericoService<T> {
    List<T> findAll();
    List<T> findAllCustom();
    T add(T t);
    T findById(Long id);
    T update(T t);
    T delete(T t);
    T enable(T t);
}
