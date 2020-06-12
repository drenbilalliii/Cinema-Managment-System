/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Sallat;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Dren
 */
public class SallatComboBoxModel extends AbstractListModel<Sallat> implements ComboBoxModel<Sallat>{
    List<Sallat> list;
    Sallat selectedItem;
    
    
    
    public SallatComboBoxModel() {
    }

    public SallatComboBoxModel(List<Sallat> list) {
        this.list = list;
    }
    
    public void addList(List<Sallat> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Sallat getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Sallat)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}

