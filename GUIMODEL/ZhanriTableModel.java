/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Klienti;
import BLL.Zhanri;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dren
 */
public class ZhanriTableModel  extends AbstractTableModel{
    
      
      List <Zhanri> list;
    String [] cols = {"Zhanri ID" ,"Lloji i Zhanrit"};
    
    public ZhanriTableModel(){}
    
    public ZhanriTableModel(List<Zhanri> list){
        this.list = list;
    }
    
    public void addList(List<Zhanri> list){
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
    
    public Zhanri getZhanri(int index){
        return list.get(index);
    }
   

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zhanri zh = list.get(rowIndex);
        switch(columnIndex){
            case 0:
               return zh.getZhanriID();
            case 1:
                return zh.getLloji();
            default:
            
                
                return null;
        }
    }
    

}
    


    
 
    

