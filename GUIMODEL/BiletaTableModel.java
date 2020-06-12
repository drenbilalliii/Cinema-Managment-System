/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Bileta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dren
 */
public class BiletaTableModel extends AbstractTableModel{
    
    List <Bileta> list;
     String [] cols = {"BiletaID" ,"Emri i klientit","Emri i salles","Emri ulses","Emri Ushqimit","Emri Filmit"};
    
    public BiletaTableModel(){}
    
    public BiletaTableModel(List<Bileta> list){
        this.list = list;
    }
    
    public void addList(List<Bileta> list){
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
    
    public Bileta getBileta(int index){
        return list.get(index);
    }
   

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bileta b = list.get(rowIndex);
       
        switch(columnIndex){
            case 0:
                return b.getBiletaID();
            case 1:
                return b.getKlientiID().getEmriMbiemri();
            case 2:
                return b.getSallaID().getEmriSalles();
            case 3:
                return b.getUlesejaID().getEmriUlses();
            case 4:
                return b.getUshqimiID();
                    
                
            case 5:
                return b.getStreamingFilmID().getEmriFilmit();
            default:
            
                
                return null;
        }
    }
    
}

    
    

