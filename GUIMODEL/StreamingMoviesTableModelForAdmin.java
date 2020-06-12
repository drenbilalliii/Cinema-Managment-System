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
public class StreamingMoviesTableModelForAdmin extends AbstractTableModel{
    
    //per konstumator...
    
      List <StreamingFilmat> list;
    String [] cols = {"StreamingID" ,"Filmi","Data Filmit ","Ora Fillimit","Ora mbarimit","Cmimi"};
    
    public StreamingMoviesTableModelForAdmin(){}
    
    public StreamingMoviesTableModelForAdmin(List<StreamingFilmat> list){
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
                return sf.getStreamingFilmID();
            case 1:
                return sf.getFilmiID();
            case 2:
                 return getDateToStringOther(sf.getDataFilmit());
            case 3:
                return getTimeToString(sf.getOraFillimit());
            case 4:
                return getTimeToString(sf.getOraMbarimit());
            case 5:
                return sf.getCmimi();
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
    public String getDateToStringOther(Date d){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(d);
    }
}

    



