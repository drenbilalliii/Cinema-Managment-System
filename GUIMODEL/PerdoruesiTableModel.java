/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Perdoruesi;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Dren
 */
public class PerdoruesiTableModel extends AbstractTableModel{
    
      
      List <Perdoruesi> list;
    String [] cols = {"PerdoruesiID" ,"Username","Password","Roli ID"};
    
    public PerdoruesiTableModel(){}
    
    public PerdoruesiTableModel(List<Perdoruesi> list){
        this.list = list;
    }
    
    public void addList(List<Perdoruesi> list){
        this.list = list;
    }
    
    @Override
    public String getColumnName(int col){
        return cols[col];
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    
    public void remove(int row){
        list.remove(row);
    }
    
    public Perdoruesi getPerdoruesi(int index){
        return list.get(index);
    }
   

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Perdoruesi p = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getPerdoruesiID();
            case 1:
                return p.getUsername();
            case 2:
                return p.getPasswordi();
            case 3:
                return p.getRoliID();
         
            default:
            
                
                return null;
        }
    }
    

}
    

