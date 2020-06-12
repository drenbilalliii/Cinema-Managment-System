/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Ankesat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dren
 */
public class AnkesatTableModel extends AbstractTableModel{
    
      List <Ankesat> list;
    String [] cols = {"Ankesa ID","Data e Ankeses","Pershkrimi"};
    
    public AnkesatTableModel(){}
    
    public AnkesatTableModel(List<Ankesat> list){
        this.list = list;
    }
    
    public void addList(List<Ankesat> list){
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
    
    public Ankesat getAnkesat(int index){
        return list.get(index);
    }
   

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ankesat f = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return f.getAnkesaID();
            case 1:
                return getDateToString(f.getDataAnkseses());
            case 2:
                return f.getAnkesa();
            
            default:
            
                
                return null;
        }
    }
    
    public String getDateToString(Date d){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(d);
    }
}
   


    
   
