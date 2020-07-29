package gov.naco.soch.shared.mapper;

import java.util.List;
import java.util.Set;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 */

public interface EntityMapper <D, E> {

    E toEntity(D dto);

    D toDto(E entity);
    
    List<E> toEntity(List<D> dto);
    
    List<D> toDto(List<E> entity);

    Set<E> toEntity(Set<D> dto);
    
    Set<D> toDto(Set<E> entity);
}
