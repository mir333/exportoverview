package org.net16.ligas.whbackend.db.entity;

import javax.persistence.*;

/**
 * This entity represents items stored in warehouses
 * and holds the amount of products stored.
 *
 * @author Miroslav Ligas <miroslav.ligas@gmail.com>
 */
@Entity
@Table(name = "WAREHOUSE_ITEM")
public class WarehouseItem extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private int productCount;

    @ManyToOne
    private Product productItem;

    @ManyToOne
    private Warehouse warehouse;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Product getProductItem() {
        return productItem;
    }

    public void setProductItem(Product productItem) {
        this.productItem = productItem;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
