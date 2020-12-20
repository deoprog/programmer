package br.com.mobitbrasil.interview.db;

import javax.ejb.Local;

@Local
public interface CrudService<T> {
    T save(T entity);
    T update(T entity);
    void delete(Long id);
    T findById(Long id);
}
