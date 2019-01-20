package org.csystem.service;

import java.util.Optional;

public interface IService<T, ID> {
    Iterable<T> findAll();
    Optional<T> findById(ID id);
    <E extends T> E save(E e);
}
