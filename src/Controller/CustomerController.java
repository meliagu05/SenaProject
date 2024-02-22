
package Controller;

import Model.Customer;
import Model.CustomerLogic;
import View.VCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CustomerController implements ActionListener {
    
    private Customer customer;
    private VCustomer frmCustomer;
    private CustomerLogic customerLogic;

    public CustomerController(Customer customer, VCustomer frmCustomer, CustomerLogic customerLogic) {
        
        this.customer = customer;
        this.frmCustomer = frmCustomer;
        this.customerLogic = customerLogic;
        this.frmCustomer.btn_add.addActionListener(this);
        this.frmCustomer.btn_update.addActionListener(this);
        this.frmCustomer.btn_delete.addActionListener(this);
        this.frmCustomer.btn_searchs.addActionListener(this);
        this.frmCustomer.btn_clean.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //BOTON AGREGAR
        
        if(e.getSource()==frmCustomer.btn_add){
            customer.setName(frmCustomer.txt_name.getText());
            customer.setSurname(frmCustomer.txt_surname.getText());
            customer.setIdentificationDocument(frmCustomer.txt_document.getText());
            customer.setPhone(frmCustomer.txt_phone.getText());
            customer.setBirthdate(frmCustomer.txt_birthdate.getText());
            customer.setEmail(frmCustomer.txt_email.getText());
            
            if(customerLogic.add(customer)){
                JOptionPane.showMessageDialog(null, "Cliente agregado");
                clean();
            } else{
                JOptionPane.showMessageDialog(null, "Error al agregar");
                clean();
            }
        }
        
        //BOTON MODIFICAR
        
         if(e.getSource()==frmCustomer.btn_update){
            customer.setId(Integer.parseInt(frmCustomer.txt_id.getText()));
            customer.setName(frmCustomer.txt_name.getText());
            customer.setSurname(frmCustomer.txt_surname.getText());
            customer.setIdentificationDocument(frmCustomer.txt_document.getText());
            customer.setPhone(frmCustomer.txt_phone.getText());
            customer.setBirthdate(frmCustomer.txt_birthdate.getText());
            customer.setEmail(frmCustomer.txt_email.getText());
            
            if(customerLogic.update(customer)){
                JOptionPane.showMessageDialog(null, "Cliente modificado");
                clean();
            } else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                clean();
            }
        }
         
         //BOTON ELIMINAR
        
         if(e.getSource()==frmCustomer.btn_delete){
            customer.setId(Integer.parseInt(frmCustomer.txt_id.getText()));
                        
            if(customerLogic.delete(customer)){
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
                clean();
            } else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                clean();
            }
        }
         
         //BOTON BUSCAR
        
         if(e.getSource()==frmCustomer.btn_searchs){
            customer.setId(Integer.parseInt(frmCustomer.txt_id.getText()));
                        
            if(customerLogic.searchs(customer)){
                frmCustomer.txt_id.setText(String.valueOf(customer.getId()));
                frmCustomer.txt_name.setText(customer.getName());
                frmCustomer.txt_surname.setText(customer.getSurname());
                frmCustomer.txt_document.setText(customer.getIdentificationDocument());
                frmCustomer.txt_phone.setText(customer.getPhone());
                frmCustomer.txt_birthdate.setText(customer.getBirthdate());
                frmCustomer.txt_email.setText(customer.getEmail());
            } else{
                JOptionPane.showMessageDialog(null, "Error al buscar");
                clean();
            }
        }
         
         //BOTON LIMPIAR
         
         if(e.getSource()==frmCustomer.btn_clean){
             clean();
         }
    }
    
    public void clean(){
        frmCustomer.txt_id.setText(null);
        frmCustomer.txt_name.setText(null);
        frmCustomer.txt_surname.setText(null);
        frmCustomer.txt_document.setText(null);
        frmCustomer.txt_phone.setText(null);
        frmCustomer.txt_birthdate.setText(null);
        frmCustomer.txt_email.setText(null);
    }
    
    
    
}
