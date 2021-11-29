package com.senla.dao;

import com.senla.model.AbstractModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
public abstract class AbstractDao <T extends AbstractModel>{

    @Autowired
    protected SessionFactory sessionFactory;

    public T getById(Long id) {
        return getCurrentSession().find( getClazz(), id );
    }

    public void save(T entity){
        getCurrentSession().persist( entity );
    }

    public void delete(T entity) {
        getCurrentSession().remove( entity );
    }

    public T update(T entity) {
        return (T) getCurrentSession().merge( entity );
    }

    @Transactional
    public List<T> getAll( ) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getClazz());
        Root<T> root = query.from(getClazz());
        CriteriaQuery<T> all = query.select(root);
        return getCurrentSession().createQuery(all).getResultList();
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected abstract Class<T> getClazz();

}

