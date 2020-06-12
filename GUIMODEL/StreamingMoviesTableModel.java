/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.StreamingFilmat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dren
 */
public class StreamingMoviesTableModel extends AbstractTableModel{
    
    //per konstumator...
    
      List <StreamingFilmat> list;
    String [] cols = {"Emri Filmit" ,"Ora Fillimit","Ora mbarimit","Data"};
    
    public StreamingMoviesTableModel(){}
    
    public StreamingMoviesTableModel(List<StreamingFilmat> list){
        this.list = list;
    }
    
    public void addList(List<StreamingFilmat> list){
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
    
    public StreamingFilmat getStreamingFilmat(int index){
        return list.get(index);
    }
   

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StreamingFilmat sf = list.get(rowIndex);
        switch(columnIndex){
            case 0: sf.getStreamingFilmID();
                return sf.getFilmiID().getEmriFilmit();
            case 1:
                return getTimeToString(sf.getOraFillimit());
            case 2:
                return getTimeToString(sf.getOraMbarimit());
            case 3:
                return getDateToString(sf.getDataFilmit());
            default:
            
                
                return null;
        }
    }
    
    public String getTimeToString(Date d){
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        return dateFormat.format(d);
    }
    
    public String getDateToString(Date d){
        DateFormat dateFormat = new SimpleDateFormat("EEEE");
        return dateFormat.format(d);
    }
}

    



