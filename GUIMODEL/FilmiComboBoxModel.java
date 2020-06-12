/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Filmi;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Dren
 */
public class FilmiComboBoxModel extends AbstractListModel<Filmi> implements ComboBoxModel<Filmi>{
    List<Filmi> list;
    Filmi selectedItem;
    
    
    
    public FilmiComboBoxModel() {
    }

    public FilmiComboBoxModel(List<Filmi> list) {
        this.list = list;
    }
    
    public void addList(List<Filmi> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Filmi getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Filmi)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}

