package org.net16.ligas.whbackend.db.entity;

/**
 * @author Miroslav Ligas <miroslav.ligas@gmail.com>
 */
public class Customer extends BaseEntity<Integer>{
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
