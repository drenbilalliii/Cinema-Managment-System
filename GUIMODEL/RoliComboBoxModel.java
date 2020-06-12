/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Perdoruesi;
import BLL.Roli;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Dren
 */
public class RoliComboBoxModel extends AbstractListModel<Roli> implements ComboBoxModel<Roli>{
    List<Roli> list;
    Roli selectedItem;
    
    
    
    public RoliComboBoxModel() {
    }

    public RoliComboBoxModel(List<Roli> list) {
        this.list = list;
    }
    
    public void addList(List<Roli> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Roli getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Roli)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}

