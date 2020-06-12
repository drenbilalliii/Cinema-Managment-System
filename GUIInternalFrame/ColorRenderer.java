/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIInternalFrame;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Dren
 */
public class ColorRenderer extends DefaultListCellRenderer {

  private ListCellRenderer defaultRenderer;

  public ColorRenderer(ListCellRenderer defaultRenderer) {
    this.defaultRenderer = defaultRenderer;
  }

  @Override
  public Component getListCellRendererComponent(JList list, Object value,
      int index, boolean isSelected, boolean cellHasFocus) {
    Component c = defaultRenderer.getListCellRendererComponent(list, value,
        index, isSelected, cellHasFocus);
   
    if (c instanceof JLabel) {
      if (isSelected) {
        c.setBackground(new Color(54,33,89));
      } else {
        c.setBackground(Color.WHITE);
          
      }
    } else {
      c.setBackground(Color.WHITE);
      c = super.getListCellRendererComponent(list, value, index, isSelected,
          cellHasFocus);
    }
    return c;
  }
}

 


