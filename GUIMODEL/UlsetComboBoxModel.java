/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Ulset;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Dren
 */
public class UlsetComboBoxModel extends AbstractListModel<Ulset> implements ComboBoxModel<Ulset>{
    List<Ulset> list;
    Ulset selectedItem;
    
    
    
    public UlsetComboBoxModel() {
    }

    public UlsetComboBoxModel(List<Ulset> list) {
        this.list = list;
    }
    
    public void addList(List<Ulset> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Ulset getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Ulset)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}

