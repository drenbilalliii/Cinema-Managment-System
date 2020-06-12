/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Pagesat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dren
 */
public class PagesatTableModel extends AbstractTableModel{
    
      
      List <Pagesat> list;
    String [] cols = {"Pagesa ID" ,"Bileta","Lloji i pageses","Shuma"};
    
    public PagesatTableModel(){}
    
    public PagesatTableModel(List<Pagesat> list){
        this.list = list;
    }
    
    public void addList(List<Pagesat> list){
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
    
    public Pagesat getPagesat(int index){
        return list.get(index);
    }
   

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pagesat p = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getPagesatID();
            case 1:
                return p.getBiletaID();
            case 2:
                return p.getMenyraPagesesID();
            case 3:
                return p.getShuma();
         
            default:
            
                
                return null;
        }
    }
    

}
    


    

