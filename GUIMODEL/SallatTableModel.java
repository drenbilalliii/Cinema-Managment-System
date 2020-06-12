/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Sallat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dren
 */
public class SallatTableModel extends AbstractTableModel{
    
    //per konstumator...
    
      List <Sallat> list;
    String [] cols = {"Salla ID","Emri i salles","Kapaciteti"};
    
    public SallatTableModel(){}
    
    public SallatTableModel(List<Sallat> list){
        this.list = list;
    }
    
    public void addList(List<Sallat> list){
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
    
    public Sallat getSallat(int index){
        return list.get(index);
    }
   

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sallat sf = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return sf.getSallaID();
            case 1:
                return sf.getEmriSalles();
            case 2:
                return sf.getKapacitetiUlseve();
                
            default:
            
                
                return null;
        }
    }
}
    
 