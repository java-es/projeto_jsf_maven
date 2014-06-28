package com.projetoJSF.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author wanderson
 */
public class HibernateDAO<T> implements InterfaceDAO<T>,Serializable{

    private static final long serialVersionUID  = 1L;
    private Class<T> classe;
    private Session session;

    public HibernateDAO(Class<T> classe, Session session) {
        super();
        this.classe = classe;
        this.session = session;
    }
            
    @Override
    public void save(T entity) {
        this.session.save(entity);
    }

    @Override
    public void update(T entity) {
        this.session.update(entity);
    }

    @Override
    public void remove(T entity) {
        this.session.delete(entity);
    }

    @Override
    public void merge(T entity) {
        this.session.merge(entity);
    }

    @Override
    public T getEntity(Serializable id) {
        T entity = (T) this.session.get(this.classe, id);
        return entity;
    }

    @Override
    public T getEntityByDetachedCriteria(DetachedCriteria criteria) {
         T entity = (T) criteria.getExecutableCriteria(session).uniqueResult();
         return entity;
    }

    @Override
    public List<T> getEntities() {
        List<T> entities = (List<T>) this.session.createCriteria(this.classe).list();
        
        return entities;
    }

    @Override
    public List<T> getListByDetachedCriteria(DetachedCriteria criteria) {
       List<T> entities = (List<T>) criteria.getExecutableCriteria(this.session);
        return entities;
    }
    
}
