package org.net16.ligas.whbackend.db.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author xligas
 */

public abstract class Document extends BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Temporal(value = TemporalType.DATE)
    private Date createDate;

    @Temporal(value = TemporalType.DATE)
    private Date editDate;

    private int docNumber;

    private boolean archived;

    @ManyToOne
    private Customer client;

//    @OneToMany(mappedBy = "document")
//    private List<> documentLine;


}
