package org.net16.ligas.whbackend.db.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representing warehouses witch can sore items.
 *
 * @author Miroslav Ligas <miroslav.ligas@gmail.com>
 */
@Entity
@Table(name = "WAREHOUSE")
public class Warehouse extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "warehouse")
    private List<WarehouseItem> warehouseItems;


    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WarehouseItem> getWarehouseItems() {
        return warehouseItems;
    }

    public void setWarehouseItems(List<WarehouseItem> warehouseItems) {
        this.warehouseItems = warehouseItems;
    }


}
