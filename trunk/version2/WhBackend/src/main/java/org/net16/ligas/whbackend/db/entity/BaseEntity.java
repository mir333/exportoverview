package org.net16.ligas.whbackend.db.entity;

import java.io.Serializable;

/**
 * @author Miroslav Ligas <miroslav.ligas@gmail.com>
 */
public abstract class BaseEntity<T> implements Serializable, Identifiable<T> {

    public abstract T getId();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getId() == null) {
            return false;
        }
        if (!getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }
        return getId().equals(getClass().cast(obj).getId());
    }

    @Override
    public int hashCode() {
        return getId() == null ? 0 : getId().hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[id=" + getId() + "]";
    }

}
