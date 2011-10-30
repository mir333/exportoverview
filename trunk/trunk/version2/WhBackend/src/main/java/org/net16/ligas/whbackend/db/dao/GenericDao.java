package org.net16.ligas.whbackend.db.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Miroslav Ligas <miroslav.ligas@gmail.com>
 */
public interface GenericDao<T, ID extends Serializable> {

    T findById(ID id);

    List<T> findAll();

    List<T> findAll(boolean useCache);

    T save(T entity);

    void delete(T entity);

}
