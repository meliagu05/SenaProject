
package Controller;

import Model.Table;
import Model.TableLogic;
import View.VTables;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class TableController implements ActionListener{
    
    private Table table;
    private VTables frmTable;
    private TableLogic tableLogic;

    public TableController(Table table, VTables frmTable, TableLogic tableLogic) {
        this.table = table;
        this.frmTable = frmTable;
        this.tableLogic = tableLogic;
        this.frmTable.btn_add.addActionListener(this);
        this.frmTable.btn_update.addActionListener(this);
        this.frmTable.btn_delete.addActionListener(this);
        this.frmTable.btn_searchs.addActionListener(this);
        this.frmTable.btn_clean.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //BOTON AGREGAR
        
        if(e.getSource()==frmTable.btn_add){
            table.setNumber(Integer.parseInt(frmTable.txt_number.getText()));
            table.setCapacity(frmTable.txt_capacity.getText());
            table.setStatus(Byte.parseByte(frmTable.txt_status.getText()));
            
            if(tableLogic.add(table)){
                JOptionPane.showMessageDialog(null, "Mesa agregada");
                clean();
            } else{
                JOptionPane.showMessageDialog(null, "Error al agregar");
                clean();
            }
        }
        
        //BOTON MODIFICAR
        
         if(e.getSource()==frmTable.btn_update){
            table.setId(Integer.parseInt(frmTable.txt_id.getText()));
            table.setNumber(Integer.parseInt(frmTable.txt_number.getText()));
            table.setCapacity(frmTable.txt_capacity.getText());
            table.setStatus(Byte.parseByte(frmTable.txt_status.getText()));
            
            if(tableLogic.update(table)){
                JOptionPane.showMessageDialog(null, "Mesa modificada");
                clean();
            } else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                clean();
            }
        }
         
         //BOTON ELIMINAR
        
         if(e.getSource()==frmTable.btn_delete){
            table.setId(Integer.parseInt(frmTable.txt_id.getText()));
                        
            if(tableLogic.delete(table)){
                JOptionPane.showMessageDialog(null, "Mesa eliminada");
                clean();
            } else{
                JOptionPane.showMessageDialog(null, "No se puede eliminar el registro ya que existen pedidos relacionados con esta mesa");
                clean();
            }
        }
         
         //BOTON BUSCAR
        
         if(e.getSource()==frmTable.btn_searchs){
            table.setId(Integer.parseInt(frmTable.txt_id.getText()));
                        
            if(tableLogic.searchs(table)){
                frmTable.txt_id.setText(String.valueOf(table.getId()));
                frmTable.txt_number.setText(String.valueOf(table.getNumber()));
                frmTable.txt_capacity.setText(table.getCapacity());
                frmTable.txt_status.setText(String.valueOf(table.getStatus()));
            } else{
                JOptionPane.showMessageDialog(null, "Error al buscar");
                clean();
            }
        }
         
         //BOTON LIMPIAR
         
         if(e.getSource()==frmTable.btn_clean){
             clean();
         }
    }
    
    public void clean(){
        frmTable.txt_id.setText(null);
        frmTable.txt_number.setText(null);
        frmTable.txt_capacity.setText(null);
        frmTable.txt_status.setText(null);
    }
    
}
