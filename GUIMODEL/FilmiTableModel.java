/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Filmi;
import BLL.Perdoruesi;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dren
 */
public class FilmiTableModel extends AbstractTableModel{
    
      List <Filmi> list;
    String [] cols = {"FilmiID" ,"Emri i filmit","Pershkrimi i filmit","Zhanri"};
    
    public FilmiTableModel(){}
    
    public FilmiTableModel(List<Filmi> list){
        this.list = list;
    }
    
    public void addList(List<Filmi> list){
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
    
    public Filmi getFilmi(int index){
        return list.get(index);
    }
   

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Filmi f = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return f.getFilmiID();
            case 1:
                return f.getEmriFilmit();
            case 2:
                return f.getPershkrimi();
            case 3:
                return f.getZhanriID();
            default:
            
                
                return null;
        }
    }
    
}

    