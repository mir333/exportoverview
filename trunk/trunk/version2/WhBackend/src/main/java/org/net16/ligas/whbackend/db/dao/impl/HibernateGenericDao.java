package org.net16.ligas.whbackend.db.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.net16.ligas.whbackend.db.dao.GenericDao;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author Miroslav Ligas <miroslav.ligas@gmail.com>
 */
public abstract class HibernateGenericDao<T, ID extends Serializable> implements GenericDao<T, ID> {

    private static final Log log = LogFactory.getLog(HibernateGenericDao.class);

    protected final Class<T> clazz;
    protected HibernateTemplate template;

    public HibernateGenericDao() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public HibernateGenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void delete(T entity) {
        template.delete(entity);
        log.debug(entity + " deleted.");
    }

    @Override
    public List<T> findAll() {
        return template.loadAll(clazz);
    }

    @Override
    public List<T> findAll(final boolean useCache) {
        return template.executeFind(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria crit = session.createCriteria(clazz);
                crit.setCacheable(useCache);
                return crit.list();
            }
        });
    }

    @Override
    public T findById(ID id) {
        T entity = (T) template.get(clazz, id);
        if (entity == null) {
            throw new EntityNotFoundException(clazz, id);
        }
        return entity;
    }

    public T save(T entity) {
        template.saveOrUpdate(entity);
        log.debug(entity + " saved.");
        return entity;
    }


}
