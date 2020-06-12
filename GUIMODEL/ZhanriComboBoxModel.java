/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.Zhanri;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Dren
 */
public class ZhanriComboBoxModel extends AbstractListModel<Zhanri> implements ComboBoxModel<Zhanri>{
    List<Zhanri> list;
    Zhanri selectedItem;
    
    
    
    public ZhanriComboBoxModel() {
    }

    public ZhanriComboBoxModel(List<Zhanri> list) {
        this.list = list;
    }
    
    public void addList(List<Zhanri> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Zhanri getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Zhanri)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}


