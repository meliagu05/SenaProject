
package Controller;

import Model.Product;
import Model.ProductLogic;
import View.VProducts;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ProductController implements ActionListener {
    
    private Product product;
    private VProducts frmProduct;
    private ProductLogic productLogic;

    public ProductController(Product product, VProducts frmProduct, ProductLogic productLogic) {
        this.product = product;
        this.frmProduct = frmProduct;
        this.productLogic = productLogic;
        this.frmProduct.btn_add.addActionListener(this);
        this.frmProduct.btn_update.addActionListener(this);
        this.frmProduct.btn_delete.addActionListener(this);
        this.frmProduct.btn_searchs.addActionListener(this);
        this.frmProduct.btn_clean.addActionListener(this);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //BOTON AGREGAR
        
        if(e.getSource()==frmProduct.btn_add){
            product.setName(frmProduct.txt_name.getText());
            product.setDescription(frmProduct.txt_description.getText());
            product.setPrice(Float.parseFloat(frmProduct.txt_price.getText()));
            
            if(productLogic.add(product)){
                JOptionPane.showMessageDialog(null, "Producto agregado");
                clean();
            } else{
                JOptionPane.showMessageDialog(null, "Error al agregar");
                clean();
            }
        }
        
        //BOTON MODIFICAR
        
         if(e.getSource()==frmProduct.btn_update){
            product.setId(Integer.parseInt(frmProduct.txt_id.getText()));
            product.setName(frmProduct.txt_name.getText());
            product.setDescription(frmProduct.txt_description.getText());
            product.setPrice(Float.parseFloat(frmProduct.txt_price.getText()));
            
            if(productLogic.update(product)){
                JOptionPane.showMessageDialog(null, "producto modificado");
                clean();
            } else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                clean();
            }
        }
         
         //BOTON ELIMINAR
        
         if(e.getSource()==frmProduct.btn_delete){
            product.setId(Integer.parseInt(frmProduct.txt_id.getText()));
                        
            if(productLogic.delete(product)){
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                clean();
            } else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                clean();
            }
        }
         
         //BOTON BUSCAR
        
         if(e.getSource()==frmProduct.btn_searchs){
            product.setId(Integer.parseInt(frmProduct.txt_id.getText()));
                        
            if(productLogic.searchs(product)){
                frmProduct.txt_id.setText(String.valueOf(product.getId()));
                frmProduct.txt_name.setText(product.getName());
                frmProduct.txt_description.setText(product.getDescription());
                frmProduct.txt_price.setText(String.valueOf(product.getPrice()));
            } else{
                JOptionPane.showMessageDialog(null, "Error al buscar");
                clean();
            }
        }
         
         //BOTON LIMPIAR
         
         if(e.getSource()==frmProduct.btn_clean){
             clean();
         }
    }
    
    public void clean(){
        frmProduct.txt_id.setText(null);
        frmProduct.txt_name.setText(null);
        frmProduct.txt_description.setText(null);
        frmProduct.txt_price.setText(null);
    }
     
    
}
