/**
 * 
 */
package com.waheed.spring.hibernate;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author abdul
 *
 */
public class DaoImpl {

    private SessionFactory sessionFactory;

    public DaoImpl() {
    }

    @Autowired
    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected <T> long createObject(T o) {
        return (Long) getSession().save(o);
    }

    protected Query createQuery(Class<?> tableClass, String queryString) {
        String queryStr1 = "from " + tableClass.getName();
        if (queryString != null) {
            queryStr1 += queryString;
        }
        Query query = getSession().createQuery(queryStr1);
        return query;
    }

    protected <T> void deleteObject(T o) {
        getSession().delete(o);
    }

    //GET OBJECT
    @SuppressWarnings("unchecked")
    protected <T> T getObject(Class<T> tableClass, long id) {
        Query query = getSession().createQuery(
                "from " + tableClass.getName() + " where id = :id");
        query.setParameter("id", id);
        return (T) query.uniqueResult();
    }

    //GET all EMployee
    @SuppressWarnings("unchecked")
    protected <T> Iterator<T> getObjects(Class<T> tableClass) {
        return createQuery(tableClass, null).iterate();
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * @return the sessionFactory
     */
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Update object and return merged hibernate entity object
     * 
     * @param o
     * @return
     */
    protected <T> T updateObject(T o) {
        Session s = getSession();
        @SuppressWarnings("unchecked")
        T mergedObject = (T) s.merge(o);
        s.update(mergedObject);
        return mergedObject;
    }
}
