package pe.com.apialmacen.mapper.generic;

import java.util.List;

public interface GenericoMapper <E, D> {

    D toDTO(E e);

    E toEntity(D d);

    List<D> toDTOs(List<E> e);

    List<E> toEntities(List<D> d);
}
