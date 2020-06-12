/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Klienti;
import BLL.Klienti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Dren
 */
public class KlientiComboBoxModel extends AbstractListModel<Klienti> implements ComboBoxModel<Klienti>{
    List<Klienti> list;
    Klienti selectedItem;
    
    
    
    public KlientiComboBoxModel() {
    }

    public KlientiComboBoxModel(List<Klienti> list) {
        this.list = list;
    }
    
    public void addList(List<Klienti> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Klienti getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Klienti)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}

