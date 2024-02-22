
package Controller;

import Model.Order;
import Model.OrderLogic;
import View.VOrders;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class OrderController implements ActionListener {
    
    private Order order;
    private VOrders frmOrder;
    private OrderLogic orderLogic;

    public OrderController(Order order, VOrders frmOrder, OrderLogic orderLogic) {
        this.order = order;
        this.frmOrder = frmOrder;
        this.orderLogic = orderLogic;
        this.frmOrder.btn_add.addActionListener(this);
        this.frmOrder.btn_update.addActionListener(this);
        this.frmOrder.btn_delete.addActionListener(this);
        this.frmOrder.btn_searchs.addActionListener(this);
        this.frmOrder.btn_clean.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //BOTON AGREGAR
        
        if(e.getSource()==frmOrder.btn_add){
            order.setDate(frmOrder.txt_date.getText());
            order.setObservations(frmOrder.txt_observations.getText());
            order.setPrice(Float.parseFloat(frmOrder.txt_price.getText()));
            order.setStatus(Byte.parseByte(frmOrder.txt_status.getText()));
            order.setIdClient(Integer.parseInt(frmOrder.txt_idCliente.getText()));
            order.setIdTable(Integer.parseInt(frmOrder.txt_idMesa.getText()));
            
            if(orderLogic.add(order)){
                JOptionPane.showMessageDialog(null, "Pedido agregago");
                clean();
            } else{
                JOptionPane.showMessageDialog(null, "Error al agregar");
                clean();
            }
        }
        
        //BOTON MODIFICAR
        
         if(e.getSource()==frmOrder.btn_update){
            order.setId(Integer.parseInt(frmOrder.txt_id.getText()));
            order.setDate(frmOrder.txt_date.getText());
            order.setObservations(frmOrder.txt_observations.getText());
            order.setPrice(Float.parseFloat(frmOrder.txt_price.getText()));
            order.setStatus(Byte.parseByte(frmOrder.txt_status.getText()));
            order.setIdClient(Integer.parseInt(frmOrder.txt_idCliente.getText()));
            order.setIdTable(Integer.parseInt(frmOrder.txt_idMesa.getText()));
            
            if(orderLogic.update(order)){
                JOptionPane.showMessageDialog(null, "Pedido modificado");
                clean();
            } else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                clean();
            }
        }
         
         //BOTON ELIMINAR
        
         if(e.getSource()==frmOrder.btn_delete){
            order.setId(Integer.parseInt(frmOrder.txt_id.getText()));
                        
            if(orderLogic.delete(order)){
                JOptionPane.showMessageDialog(null, "Pedido eliminado");
                clean();
            } else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                clean();
            }
        }
         
         //BOTON BUSCAR
        
         if(e.getSource()==frmOrder.btn_searchs){
            order.setId(Integer.parseInt(frmOrder.txt_id.getText()));
                        
            if(orderLogic.searchs(order)){
                frmOrder.txt_id.setText(String.valueOf(order.getId()));
                frmOrder.txt_date.setText(order.getDate());
                frmOrder.txt_observations.setText(order.getObservations());
                frmOrder.txt_price.setText(String.valueOf(order.getPrice()));
                frmOrder.txt_status.setText(String.valueOf(order.getStatus()));
                frmOrder.txt_idCliente.setText(String.valueOf(order.getIdClient()));
                frmOrder.txt_idMesa.setText(String.valueOf(order.getIdTable()));
            } else{
                JOptionPane.showMessageDialog(null, "Error al buscar");
                clean();
            }
        }
         
         //BOTON LIMPIAR
         
         if(e.getSource()==frmOrder.btn_clean){
             clean();
         }
    }
    
    public void clean(){
        frmOrder.txt_id.setText(null);
        frmOrder.txt_date.setText(null);
        frmOrder.txt_observations.setText(null);
        frmOrder.txt_price.setText(null);
        frmOrder.txt_status.setText(null);
        frmOrder.txt_idCliente.setText(null);
        frmOrder.txt_idMesa.setText(null);
    }
     
}
