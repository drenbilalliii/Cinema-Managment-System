/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Bileta;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Dren
 */
public class BiletaComboBoxModel extends AbstractListModel<Bileta> implements ComboBoxModel<Bileta>{
    List<Bileta> list;
    Bileta selectedItem;
    
    
    
    public BiletaComboBoxModel() {
    }

    public BiletaComboBoxModel(List<Bileta> list) {
        this.list = list;
    }
    
    public void addList(List<Bileta> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Bileta getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Bileta)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}


    

