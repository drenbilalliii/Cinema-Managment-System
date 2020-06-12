/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Ushqimi;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dren
 */
public class UshqimiTableModel extends AbstractTableModel{
    
      
    List <Ushqimi> list;
    String [] cols = {"Ushqimi ID" ,"Emri Ushqimit","Cmimi"};
    
    public UshqimiTableModel(){}
    
    public UshqimiTableModel(List<Ushqimi> list){
        this.list = list;
    }
    
    public void addList(List<Ushqimi> list){
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
    
    public Ushqimi getUshqimi(int index){
        return list.get(index);
    }
   

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ushqimi p = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getUshqimiID();
            case 1:
                return p.getEmriUshqimit();
            case 2:
                return p.getCmimi();
       
            default:
            
                
                return null;
        }
    }
    

}
    

