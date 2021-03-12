package com.codegym.product.service;

import java.util.Optional;

public interface IService<T> {
    Iterable<T> findAll();

    T findById(Long id);

    void save(T t);

    void delete(Long id);
}
