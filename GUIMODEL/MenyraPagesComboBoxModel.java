/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMODEL;

import BLL.MenyraPageses;
import BLL.Zhanri;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Dren
 */
public class MenyraPagesComboBoxModel extends AbstractListModel<MenyraPageses> implements ComboBoxModel<MenyraPageses>{
    List<MenyraPageses> list;
    MenyraPageses selectedItem;
    
    
    
    public MenyraPagesComboBoxModel() {
    }

    public MenyraPagesComboBoxModel(List<MenyraPageses> list) {
        this.list = list;
    }
    
    public void addList(List<MenyraPageses> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public MenyraPageses getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(MenyraPageses)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}



    

