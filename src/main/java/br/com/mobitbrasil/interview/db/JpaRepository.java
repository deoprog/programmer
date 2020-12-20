package br.com.mobitbrasil.interview.db;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class JpaRepository<T> implements CrudService<T> {

    @PersistenceContext(name = "programmer")
    private EntityManager em;

    private final Class<T> klass;

    public JpaRepository() {
        this.klass = getGenericTypeClass();
    }

    private Class<T> getGenericTypeClass() {
        Type genericSuperClass = getClass().getGenericSuperclass();

        ParameterizedType parametrizedType = null;
        while (parametrizedType == null) {
            if ((genericSuperClass instanceof ParameterizedType)) {
                parametrizedType = (ParameterizedType) genericSuperClass;
            } else {
                genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
            }
        }

        return (Class<T>) parametrizedType.getActualTypeArguments()[0];
    }

    @Override
    public T save(T entity) {
        try {
            this.em.persist(entity);
        } catch (Exception e) {
            Logger.getLogger(JpaRepository.class.getName()).log(Level.SEVERE, null, e);
            this.em.getTransaction().rollback();
        }
        return entity;
    }

    @Override
    public T update(T entity) {
        return entity;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public T findById(Long id) {
        return this.em.find(this.klass, id);
    }

    public EntityManager getManager() {
        return em;
    }
}
