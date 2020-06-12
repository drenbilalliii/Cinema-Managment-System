/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Ushqimi;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Dren
 */
public class UshqimiComboBoxModel extends AbstractListModel<Ushqimi> implements ComboBoxModel<Ushqimi>{
    List<Ushqimi> list;
    Ushqimi selectedItem;
    
    
    
    public UshqimiComboBoxModel() {
    }

    public UshqimiComboBoxModel(List<Ushqimi> list) {
        this.list = list;
    }
    
    public void addList(List<Ushqimi> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Ushqimi getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Ushqimi)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}

