/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Perdoruesi;
import BLL.Roli;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dren
 */
public class RoliTableModel extends AbstractTableModel{
    
    
      List <Roli> list;
    String [] cols = {"Roli ID" ,"Lloji"};
    
    public RoliTableModel(){}
    
    public RoliTableModel(List<Roli> list){
        this.list = list;
    }
    
    public void addList(List<Roli> list){
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
    
    public Roli getRoli(int index){
        return list.get(index);
    }
   

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Roli r = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return r.getRoliID();
            case 1:
                return r.getLloji();
            case 2:
            default:
            
                
                return null;
        }
    }
    
}

    


