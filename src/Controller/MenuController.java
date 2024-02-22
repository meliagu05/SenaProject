
package Controller;

import View.VCustomer;
import View.VMenu;
import View.VOrders;
import View.VProducts;
import View.VTables;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    
    private VMenu frmMenu;
    private VCustomer frmCustomer;
    private VOrders frmOrder;
    private VProducts frmProduct;
    private VTables frmTable;

    public MenuController(VMenu frmMenu, VCustomer frmCustomer, VOrders frmOrder, VProducts frmProduct, VTables frmTable) {
        
        this.frmMenu = frmMenu;
        this.frmCustomer = frmCustomer;
        this.frmOrder = frmOrder;
        this.frmProduct = frmProduct;
        this.frmTable = frmTable;
        this.frmMenu.customers_mod.addActionListener(this);
        this.frmMenu.order_mod.addActionListener(this);
        this.frmMenu.product_mod.addActionListener(this);
        this.frmMenu.eaterytable_mod.addActionListener(this);
        this.frmMenu.logout.addActionListener(this);
    }
    
    public void start(){
        
        frmCustomer.setTitle("Clientes");
        frmOrder.setTitle("Pedidos");
        frmProduct.setTitle("Productos");
        frmTable.setTitle("Mesas");
        frmMenu.setTitle("Menú");
        frmCustomer.setLocationRelativeTo(null);
        frmOrder.setLocationRelativeTo(null);
        frmProduct.setLocationRelativeTo(null);
        frmTable.setLocationRelativeTo(null);
        frmMenu.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == frmMenu.customers_mod){
            frmCustomer.setVisible(true);
            frmMenu.dispose();
        }
        
        if(e.getSource() == frmMenu.order_mod){
            frmOrder.setVisible(true);
            frmMenu.dispose();
        }
        
        if(e.getSource() == frmMenu.product_mod){
            frmProduct.setVisible(true);
            frmMenu.dispose();
        }
        
        if(e.getSource() == frmMenu.eaterytable_mod){
            frmTable.setVisible(true);
            frmMenu.dispose();
        }
        
        if(e.getSource() == frmMenu.logout){
            System.exit(0);
        }
        
    }
    
    
    
}
