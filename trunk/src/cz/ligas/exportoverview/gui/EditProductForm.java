/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

    private int productId;

    public EditProductForm(int id) {
        productId=id;
        Products prod = ProductOps.getProductById(id);
        tProductCodeIn.setText(prod.getProductCode());
        tProductDescIn.setText(prod.getProductDes());
        tProductNameIn.setText(prod.getProductName());
        mProductPriceIn.setText(prod.getProductPrice() + "");
        categoryComboBox.setSelectedItem(prod.getProductCategoryId());
    }

    @Override
    public void saveProduct() {
        Products p = new Products();
        p.setId(productId);
        p.setProductCode(tProductCodeIn.getText());
        p.setProductName(tProductNameIn.getText());
        p.setProductPrice(Float.parseFloat(mProductPriceIn.getText()));
        p.setProductDes(tProductDescIn.getText());
        p.setProductCategoryId((ProductCategory) categoryComboBox.getSelectedItem());
        //overenie vyplnenia
        try {
            ProductOps.editProduct(p);
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
}
