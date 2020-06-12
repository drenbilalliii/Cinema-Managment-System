/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Klienti;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dren
 */
public class KlientiTableModel extends AbstractTableModel{
    
      
      List <Klienti> list;
    String [] cols = {"KlientiID" ,"Emri dhe Mbiemri"};
    
    public KlientiTableModel(){}
    
    public KlientiTableModel(List<Klienti> list){
        this.list = list;
    }
    
    public void addList(List<Klienti> list){
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
    
    public Klienti getKlienti(int index){
        return list.get(index);
    }
   

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klienti p = list.get(rowIndex);
        switch(columnIndex){
            case 0:
               return p.getKlientiID();
            case 1:
                return p.getEmriMbiemri();
            default:
            
                
                return null;
        }
    }
    

}
    


    
