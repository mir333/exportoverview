package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ProductOps;
import cz.ligas.exportoverview.db.ProductCategory;
import cz.ligas.exportoverview.db.Products;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miro
 */
public class EditProductForm extends ProductForm {


    public EditProductForm(java.awt.Frame parent) {
        super(parent);
    }

    @Override
    public void saveProduct() {
        Products p = new Products();
        try {
            p.setId(WarehouseForm.getInstance().getSelectedProductId());
            p.setProductCode(tProductCodeIn.getText());
            p.setProductName(tProductNameIn.getText());
            p.setProductPrice(MyParser.paresePrice(mProductPriceIn.getText()));
            p.setProductDes(tProductDescIn.getText());
            p.setProductCategoryId((ProductCategory) categoryComboBox.getSelectedItem());
            //overenie vyplnenia
            ProductOps.editProduct(p);
            this.dispose();
        } catch (javax.persistence.RollbackException sqlEx) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, sqlEx);
            MyUtilErrorClass.errorDialog("error.sql.rollback");
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void fill(){
        Products prod = ProductOps.getProductById(WarehouseForm.getInstance().getSelectedProductId());
        tProductCodeIn.setText(prod.getProductCode());
        tProductDescIn.setText(prod.getProductDes());
        tProductNameIn.setText(prod.getProductName());
        mProductPriceIn.setText(prod.getProductPrice() + "");
        categoryComboBox.setSelectedItem(prod.getProductCategoryId());
    }
}