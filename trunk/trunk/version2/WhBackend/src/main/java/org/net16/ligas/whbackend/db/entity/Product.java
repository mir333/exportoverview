package org.net16.ligas.whbackend.db.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Miroslav Ligas <miroslav.ligas@gmail.com>
 */
@Entity
@Table(name="PRODUCT")
public class Product extends BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable=false,unique=true)
    private String code;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private BigDecimal defaultPrice;

    private String description;

    private boolean archived;

    @ManyToOne
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "productItem",fetch = FetchType.LAZY)
    private List<WarehouseItem> warehouseItems;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(BigDecimal defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<WarehouseItem> getWarehouseItems() {
        return warehouseItems;
    }

    public void setWarehouseItems(List<WarehouseItem> warehouseItems) {
        this.warehouseItems = warehouseItems;
    }
}
