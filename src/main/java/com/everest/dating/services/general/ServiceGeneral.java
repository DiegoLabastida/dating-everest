package com.everest.dating.services.general;

import java.util.Optional;

public interface ServiceGeneral<T> {

    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void deleteById(Long id);
}
