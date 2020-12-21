package br.com.mobitbrasil.interview.db;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class JpaRepository<T> {

    @PersistenceContext(name = "programmer")
    private EntityManager em;

    private final Class<T> clazz;

    protected JpaRepository(Class<T> e) {
        clazz = e;
    }

    public T save(T entity) {
        try {
            this.em.persist(entity);
        } catch (Exception e) {
            Logger.getLogger(JpaRepository.class.getName()).log(Level.SEVERE, null, e);
            this.em.getTransaction().rollback();
        }
        return entity;
    }

    public T update(T entity) {
        return entity;
    }

    public void delete(Long id) {

    }

    public T findById(Long id) {
        System.err.println(clazz.getSimpleName() + " - " + id);
        return this.em.find(clazz, id);
    }

    public EntityManager getManager() {
        return em;
    }
}
