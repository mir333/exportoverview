package org.net16.ligas.whbackend.db.exceptions;

import java.io.Serializable;

/**
 *
 * @author Miroslav Ligas <miroslav.ligas@gmail.com>
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class clazz, Serializable id) {
        super("Entity " + clazz.getName() + " with id " + id + " does not exist.");
    }
}
