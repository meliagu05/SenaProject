
package sena_project;

import Controller.CustomerController;
import Controller.MenuController;
import Controller.OrderController;
import Controller.ProductController;
import Controller.TableController;
import Model.Customer;
import Model.CustomerLogic;
import Model.Order;
import Model.OrderLogic;
import Model.Product;
import Model.ProductLogic;
import Model.Table;
import Model.TableLogic;
import View.VCustomer;
import View.VMenu;
import View.VOrders;
import View.VProducts;
import View.VTables;

public class Main {

    
    public static void main(String[] args) {
                
        Customer customer = new Customer();
        CustomerLogic customerLogic = new CustomerLogic();
        VCustomer frmCustomer = new VCustomer();
        CustomerController ctrlCustomer = new CustomerController(customer, frmCustomer, customerLogic);
        
        Order order = new Order();
        OrderLogic orderLogic = new OrderLogic();
        VOrders frmOrders = new VOrders();
        OrderController ctrlOrder = new OrderController(order, frmOrders, orderLogic);
        
        Product product = new Product();
        ProductLogic productLogic = new ProductLogic();
        VProducts frmProducts = new VProducts();
        ProductController ctrlProduct = new ProductController(product, frmProducts, productLogic);
        
        Table table = new Table();
        TableLogic tableLogic = new TableLogic();
        VTables frmTable = new VTables();
        TableController ctrlTable = new TableController(table, frmTable, tableLogic);
        
        VMenu frmMenu = new VMenu();
        MenuController ctrlMenu = new MenuController(frmMenu, frmCustomer, frmOrders, frmProducts, frmTable);
        
        ctrlMenu.start();
        frmMenu.setVisible(true);
        
    }
    
}
