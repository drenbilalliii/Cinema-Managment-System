/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Ulset;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dren
 */
public class UlsetTableModel extends AbstractTableModel{
    
      
      List <Ulset> list;
    String [] cols = {"Ulseja ID" ,"Emri Ulses","Salla"};
    
    public UlsetTableModel(){}
    
    public UlsetTableModel(List<Ulset> list){
        this.list = list;
    }
    
    public void addList(List<Ulset> list){
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
    
    public Ulset getUlset(int index){
        return list.get(index);
    }
   

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ulset p = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getUlesejaID();
            case 1:
                return p.getEmriUlses();
            case 2:
                return p.getSallaID();
       
            default:
            
                
                return null;
        }
    }
    

}
    

