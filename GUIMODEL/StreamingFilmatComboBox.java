/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.StreamingFilmat;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Dren
 */
public class StreamingFilmatComboBox  extends AbstractListModel<StreamingFilmat> implements ComboBoxModel<StreamingFilmat>{
    List<StreamingFilmat> list;
    StreamingFilmat selectedItem;
    
    
    
    public StreamingFilmatComboBox() {
    }

    public StreamingFilmatComboBox(List<StreamingFilmat> list) {
        this.list = list;
    }
    
    public void addList(List<StreamingFilmat> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public StreamingFilmat getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(StreamingFilmat)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
 

