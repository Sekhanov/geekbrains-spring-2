package com.skhanov.geekbrainsspring.persist.service;

import java.util.List;

/**
 * CrudService
 */
public interface CommonCrudInterface<E> {

    E findById(Long id);

    List<E> findAll();

    boolean save(E e);

    boolean deleteById(Long id);
}