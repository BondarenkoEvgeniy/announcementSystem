package com.senla.api.dao;

import com.senla.model.AbstractModel;

import java.util.List;

public interface IAbstractDao <T extends AbstractModel>{

    T getById(Long id);

    void save (T object);

    T update(T object);

    void delete(T object);

    List<T> getAll();

}
