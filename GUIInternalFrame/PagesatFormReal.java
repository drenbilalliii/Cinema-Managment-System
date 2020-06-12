/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIInternalFrame;

import BLL.Bileta;
import BLL.MenyraPageses;
import BLL.Pagesat;
import DAL.BiletaRepository;
import DAL.KlientiRepository;
import DAL.MenyraPagesesRepository;
import DAL.PagesatRepository;
import DAL.PerdoruesiException;
import DAL.ShitjeException;
import GUIMODEL.BiletaComboBoxModel;
import GUIMODEL.MenyraPagesComboBoxModel;
import GUIMODEL.PagesatTableModel;
import gid.MenyraPagesesForm;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Dren
 */
public class PagesatFormReal extends javax.swing.JInternalFrame {

    /**
     * Creates new form PagesatFormReal
     */
    MenyraPagesesRepository menyraPagesesRepository = new MenyraPagesesRepository();
    MenyraPagesComboBoxModel menyraPagesesComboBoxModel = new MenyraPagesComboBoxModel();
    PagesatRepository pagesatRepository = new PagesatRepository();
    PagesatTableModel pagesatTableModel = new PagesatTableModel();
    BiletaRepository biletaRepository = new BiletaRepository();
    BiletaComboBoxModel biletaComboBoxModel = new BiletaComboBoxModel();
    KlientiRepository klientiRepository = new KlientiRepository();
    
    public PagesatFormReal() {
        initComponents();
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        loadFirstPage();
        loadComboBoxBilet();
        loadComboBoxPages();
        setRendererForComboBox();
        tabelaSelectedIndexChange();
         tablePagesat.getTableHeader().setFont(new Font("Seqoe UI", Font.BOLD,12));
        tablePagesat.getTableHeader().setOpaque(false);
        tablePagesat.getTableHeader().setBackground(new Color(54,33,89));
        tablePagesat.getTableHeader().setForeground(new Color(255,255,255));
        tablePagesat.setRowHeight(25);
    }
    
    
    
    
   public void loadTable(){
        try {
            List<Pagesat> lista = pagesatRepository.findAll();
            pagesatTableModel.addList(lista);
            tablePagesat.setModel(pagesatTableModel);
            pagesatTableModel.fireTableDataChanged();
        } catch (ShitjeException ex) {
            Logger.getLogger(PagesatFormReal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     private void tabelaSelectedIndexChange(){
        final ListSelectionModel rowSM = tablePagesat.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    return;
                }
                
                ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if(selectedIndex > -1){
                    Pagesat zh = pagesatTableModel.getPagesat(selectedIndex);
                    biletaCmb.getModel().setSelectedItem(zh.getBiletaID());
                    usernameTextField1.setText(String.valueOf(zh.getShuma()));
                    menyraPagesesCmb.getModel().setSelectedItem(zh.getMenyraPagesesID());
                    
                 
                }
            }
        });
    }
    
    public void loadComboBoxPages(){
        try {
            List<MenyraPageses> lista = menyraPagesesRepository.findAll();
            menyraPagesesComboBoxModel.addList(lista);
            menyraPagesesCmb.setModel(menyraPagesesComboBoxModel);
            menyraPagesesCmb.repaint();
        } catch (ShitjeException ex) {
            Logger.getLogger(MenyraPagesesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadComboBoxBilet(){
        List<Bileta> lista = biletaRepository.findAll();
        biletaComboBoxModel.addList(lista);
        biletaCmb.setModel(biletaComboBoxModel);
        biletaCmb.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelForPagesat = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        usernameTextField1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        biletaCmb = new javax.swing.JComboBox();
        menyraPagesesCmb = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePagesat = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelForPagesat.setBackground(new java.awt.Color(122, 72, 221));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_price_20px.png")); // NOI18N
        jLabel4.setText("Shuma");

        usernameTextField1.setBackground(new java.awt.Color(122, 72, 221));
        usernameTextField1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        usernameTextField1.setForeground(new java.awt.Color(255, 255, 255));
        usernameTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        usernameTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameTextField1KeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_ticket_20px_1.png")); // NOI18N
        jLabel15.setText("Bileta");

        biletaCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        menyraPagesesCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_card_payment_20px.png")); // NOI18N
        jLabel14.setText("Menyra Pageses");

        javax.swing.GroupLayout panelForPagesatLayout = new javax.swing.GroupLayout(panelForPagesat);
        panelForPagesat.setLayout(panelForPagesatLayout);
        panelForPagesatLayout.setHorizontalGroup(
            panelForPagesatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelForPagesatLayout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(panelForPagesatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(biletaCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(73, 73, 73)
                .addGroup(panelForPagesatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(66, 66, 66)
                .addGroup(panelForPagesatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menyraPagesesCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(146, 146, 146))
        );
        panelForPagesatLayout.setVerticalGroup(
            panelForPagesatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelForPagesatLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(panelForPagesatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelForPagesatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(biletaCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menyraPagesesCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        getContentPane().add(panelForPagesat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, -1));

        tablePagesat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePagesat.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablePagesat.setRowHeight(25);
        tablePagesat.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tablePagesat.setShowVerticalLines(false);
        tablePagesat.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablePagesat);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 780, 400));

        jPanel1.setBackground(new java.awt.Color(180, 180, 180));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_create_50px_1.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Create");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 57, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_delete_file_47px_1.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 3, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Delete");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 57, 47, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_erase_47px_1.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 3, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("  Clear");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 57, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_fantasy_47px_2.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 3, -1, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("File Magic");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 57, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_chart_47px_1.png")); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 3, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(" Chart");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 57, 47, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_book_47px_1.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 3, -1, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Raports");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 57, 62, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 780, 80));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 130, -1));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(122, 72, 221));
        jLabel17.setText("Search:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, 20));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotot/icons8_search_24px_6.png"))); // NOI18N
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, 20));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_1_24px_9.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, 40));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_2_24px_3.png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 30, 40));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_all_out_20px.png")); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 40, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextField1KeyTyped

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        if(usernameTextField1.getText().length() == 0){
            JOptionPane.showMessageDialog(this,"Mbushe input-in me vlera");
        }else{
             try{
                     int row = tablePagesat.getSelectedRow();
                                if(row == -1){
                                        Pagesat p = new Pagesat();
                                        
                                        p.setBiletaID((Bileta) biletaCmb.getSelectedItem());
                                        p.setMenyraPagesesID((MenyraPageses)menyraPagesesCmb.getSelectedItem());
                                        p.setShuma(Long.parseLong(usernameTextField1.getText()));
                                        pagesatRepository.create(p);
                    
                                    }else{
                                        Pagesat p = pagesatTableModel.getPagesat(row);
                                          p.setBiletaID((Bileta) biletaCmb.getSelectedItem());
                                        p.setMenyraPagesesID((MenyraPageses)menyraPagesesCmb.getSelectedItem());
                                        p.setShuma(Long.parseLong(usernameTextField1.getText()));
                                        pagesatRepository.edit(p);
                                    }
                
                                clear();
                                loadFirstPage();
                            } catch (ShitjeException ex) {
                                JOptionPane.showMessageDialog(this,"Ka ndodhur nje gabim!");
                                Logger.getLogger(UshqimiFormReal.class.getName()).log(Level.SEVERE, null, ex);
                            }
        }

    }//GEN-LAST:event_jLabel1MouseClicked

    
    public void renderColor(){
        Component [] components = panelForPagesat.getComponents();
       
       for(Component component : components){
           if(component instanceof JComboBox){
               ((JComboBox)component).setRenderer(new ColorRenderer(((JComboBox)component).getRenderer()));
               ((JComboBox)component).setForeground(new Color(122,72,221));
           }
       }
       
    
    }
    
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
      
        int row = tablePagesat.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Yes", "No"};
            int i = JOptionPane.showOptionDialog(this, "Are you sure?", "Delete", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                try {
                    Pagesat z = pagesatTableModel.getPagesat(row);
                    pagesatRepository.delete(z);

                    loadFirstPage();
                    clear();
                } catch (ShitjeException ex) {
                    Logger.getLogger(PagesatFormReal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nuk eshte selektuar asgje per te fshire.");
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        clear();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void clear(){
        usernameTextField1.setText("");
        menyraPagesesCmb.setSelectedItem(null);
        biletaCmb.getModel().setSelectedItem(null);
    }
    
    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
          JOptionPane.showMessageDialog(this,"Nuk eshte e disponueshme");
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        
          try {
             DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
             
             ArrayList<String> lista = pagesatRepository.treMusketieretPagesat();
           
             
             String emriPare = lista.get(0);
             int emriPareNumri = Integer.parseInt(lista.get(1));
             
             String emriDyte = lista.get(2);
             int emriDyteNumri = Integer.parseInt(lista.get(3));
             
             String emriTret = lista.get(4);
             int emriTretNumri = Integer.parseInt(lista.get(5));
             
         
             
             
             categoryDataset.setValue(emriPareNumri,"d",emriPare);
             categoryDataset.setValue(emriDyteNumri,"D",emriDyte);
             categoryDataset.setValue(emriTretNumri,"d",emriTret);
             
             
             JFreeChart chart = ChartFactory.createBarChart3D("Top 3 Pagesat","Pagesat","Shuma", categoryDataset,PlotOrientation.VERTICAL,false,true,false);
             
             CategoryPlot p = chart.getCategoryPlot();
             
             p.setRangeGridlinePaint(Color.BLACK);
             
             ChartFrame frame = new ChartFrame("d", chart);
             frame.setVisible(true);
             frame.setSize(800,400);
         } catch (PerdoruesiException ex) {
             Logger.getLogger(PerdoruesiFormReal.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        String pagesa = jTextField1.getText();
        TableRowSorter trs = new TableRowSorter(pagesatTableModel);
        tablePagesat.setRowSorter(trs);

        trs.setRowFilter(RowFilter.regexFilter(pagesa));
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
         try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               String url = "jdbc:sqlserver://localhost:1433;DatabaseName=FilmixDataStore";
               Connection connection = DriverManager.getConnection(url, "DrenBilalli", "Dren1234");
              
               JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Admin\\Desktop\\Filmix\\src\\gid\\Raportet\\PagesatRaportet.jrxml"
                       + "");

               Map<String, Object> params = new HashMap<String, Object>();
                    JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                                JasperPrint jasperPrint = JasperFillManager.fillReport(jreport, params, connection);
                                JasperViewer.viewReport(jasperPrint);
                             
          } catch (JRException ex) {
            Logger.getLogger(PerdoruesiFormReal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PerdoruesiFormReal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PerdoruesiFormReal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        loadFirstPage();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered

    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited

    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked

        loadSecondPage();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        loadTable();
    }//GEN-LAST:event_jLabel16MouseClicked

    
     public void setRendererForComboBox(){
            
            Component [] conComponents = panelForPagesat.getComponents();
         //   int count = 0;
            for(Component component: conComponents){
                if(component instanceof JComboBox){
                   ((JComboBox)component).setRenderer(new ColorRenderer(((JComboBox)component).getRenderer()));
                  
                   ((JComboBox)component).setForeground(new Color(22,96,131));
                  
                }
               
                
                
        }
          
        }
    
    
    
     public void loadFirstPage(){
        List<Pagesat> list = pagesatRepository.fetchSomeValues(0,14);
        pagesatTableModel.addList(list);
           tablePagesat.setModel(pagesatTableModel);
           pagesatTableModel.fireTableDataChanged();
    }
    public void loadSecondPage(){
        List<Pagesat> list = pagesatRepository.fetchSomeValues(14,14);
        pagesatTableModel.addList(list);
           tablePagesat.setModel(pagesatTableModel);
           pagesatTableModel.fireTableDataChanged();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox biletaCmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox menyraPagesesCmb;
    private javax.swing.JPanel panelForPagesat;
    private javax.swing.JTable tablePagesat;
    public javax.swing.JTextField usernameTextField1;
    // End of variables declaration//GEN-END:variables
}
