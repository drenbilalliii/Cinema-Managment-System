/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIInternalFrame;

import BLL.Perdoruesi;
import BLL.Roli;
import DAL.PerdoruesiException;
import DAL.PerdoruesiRepository;
import DAL.RoliRepository;
import GUIMODEL.PerdoruesiTableModel;
import GUIMODEL.RoliComboBoxModel;
import com.sun.glass.events.KeyEvent;
import gid.Dashboard;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
public class PerdoruesiFormReal extends javax.swing.JInternalFrame {

    /**
     * Creates new form PerdoruesiFormReal
     */
    
     RoliComboBoxModel roliComboBoxModel = new RoliComboBoxModel();
    PerdoruesiRepository perdoruesiRepository = new PerdoruesiRepository();
    PerdoruesiTableModel perdoruesiTableModel = new PerdoruesiTableModel();
    RoliRepository roliRepository = new RoliRepository();
    
    
    public PerdoruesiFormReal() {
        initComponents();
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        loadFirstPage();
        loadComboBox();
        renderComboBox();
        tabelaSelectedIndexChange();
        setBackground(new Color(0,0,0,0));
        tablePerdorues.getTableHeader().setFont(new Font("Seqoe UI", Font.BOLD,12));
        tablePerdorues.getTableHeader().setOpaque(false);
        tablePerdorues.getTableHeader().setBackground(new Color(54,33,89));
        tablePerdorues.getTableHeader().setForeground(new Color(255,255,255));
        tablePerdorues.setRowHeight(25);
        
        
    }
    
    public void renderComboBox(){
        Component [] components = jPanel2.getComponents();
       
       for(Component component : components){
           if(component instanceof JComboBox){
               ((JComboBox)component).setRenderer(new ColorRenderer(((JComboBox)component).getRenderer()));
               ((JComboBox)component).setForeground(new Color(122,72,221));
           }
       }
       
    }
    
    public void loadTable(){
           List<Perdoruesi> lista = perdoruesiRepository.findAll();
           perdoruesiTableModel.addList(lista);
           tablePerdorues.setModel(perdoruesiTableModel);
           perdoruesiTableModel.fireTableDataChanged();
    
    }
    private void tabelaSelectedIndexChange(){
        final ListSelectionModel rowSM = tablePerdorues.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    return;
                }
                
                ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if(selectedIndex > -1){
                    Perdoruesi p = perdoruesiTableModel.getPerdoruesi(selectedIndex);
                   usernameTextField.setText(p.getUsername());
                    passwordTextField.setText(p.getPasswordi());
                    roliCmb.getModel().setSelectedItem(p.getRoliID());
                }
            }
        });
    }
    
    
       public void loadComboBox(){
         try{
         List<Roli> lista = roliRepository.findAll();
         roliComboBoxModel.addList(lista);
         roliCmb.setModel(roliComboBoxModel);
         roliCmb.repaint();
         
         }catch(PerdoruesiException e){
             e.printStackTrace();
         }
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPanel2 = new javax.swing.JPanel();
        usernameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        roliCmb = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePerdorues = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(180, 180, 180));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_create_50px_1.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Create");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_delete_file_47px_1.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Delete");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_erase_47px_1.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("  Clear");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_fantasy_47px_2.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("File Magic");

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_chart_47px_1.png")); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(" Chart");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_book_47px_1.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Raports");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel12)
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9)
                        .addComponent(jLabel11)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 780, 80));

        jPanel2.setBackground(new java.awt.Color(122, 72, 221));

        usernameTextField.setBackground(new java.awt.Color(122, 72, 221));
        usernameTextField.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        usernameTextField.setForeground(new java.awt.Color(255, 255, 255));
        usernameTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        usernameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameTextFieldKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_female_profile_20px.png")); // NOI18N
        jLabel4.setText("Username");

        passwordTextField.setBackground(new java.awt.Color(122, 72, 221));
        passwordTextField.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        passwordTextField.setForeground(new java.awt.Color(255, 255, 255));
        passwordTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_password_20px_1.png")); // NOI18N
        jLabel14.setText("Password");

        roliCmb.setBackground(new java.awt.Color(214, 75, 75));
        roliCmb.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        roliCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roliCmb.setSelectedItem("Zgjedh Rolin");
        roliCmb.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        roliCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roliCmb.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_admin_settings_male_20px.png")); // NOI18N
        jLabel15.setText("Roli");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gid/passwordSeen.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(roliCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roliCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, -1));

        tablePerdorues.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePerdorues.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablePerdorues.setRowHeight(25);
        tablePerdorues.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tablePerdorues.setShowVerticalLines(false);
        tablePerdorues.getTableHeader().setReorderingAllowed(false);
        tablePerdorues.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablePerdoruesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablePerdorues);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 780, 400));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(122, 72, 221));
        jLabel17.setText("Search:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, 20));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 130, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotot/icons8_search_24px_6.png"))); // NOI18N
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, 20));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_1_24px_9.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, -1, 40));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_2_24px_3.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 30, 40));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_all_out_20px.png")); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 40, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextFieldKeyTyped

    }//GEN-LAST:event_usernameTextFieldKeyTyped

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

    public void clear(){
        usernameTextField.setText("");
        passwordTextField.setText("");
        roliCmb.setSelectedIndex(-1);
    }
        
    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        passwordTextField.setEchoChar((char)0);
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        passwordTextField.setEchoChar('*');
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
      
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
            loadFirstPage();
        
    
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
       
        loadSecondPage();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       
    }//GEN-LAST:event_formInternalFrameOpened

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        clear();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        int row = tablePerdorues.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Yes", "No"};
            int i = JOptionPane.showOptionDialog(this, "Are you sure?", "Delete", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                Perdoruesi p = perdoruesiTableModel.getPerdoruesi(row);
                perdoruesiRepository.remove(p);

                loadFirstPage();
                clear();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nuk eshte selektuar asgje per te fshire.");
        }

    }//GEN-LAST:event_jLabel3MouseClicked

    //me shtyp delete me fshi rreshtin e selektuar
    
   
    
    
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        if(usernameTextField.getText().equals("") || passwordTextField.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Ju lutem shenoni vlera ne input");
        }else{
            try{
                int row = tablePerdorues.getSelectedRow();
                if(row == -1){
                    Perdoruesi p = new Perdoruesi();
                    p.setUsername(usernameTextField.getText());
                    p.setPasswordi(passwordTextField.getText());
                    p.setRoliID((Roli)roliCmb.getSelectedItem());

                    perdoruesiRepository.create(p);

                }else{
                    Perdoruesi p = perdoruesiTableModel.getPerdoruesi(row);
                    p.setUsername(usernameTextField.getText());
                    p.setPasswordi(passwordTextField.getText());
                    p.setRoliID((Roli)roliCmb.getSelectedItem());
                    perdoruesiRepository.edit(p);
                }

                clear();
                loadFirstPage();
            }catch(PerdoruesiException ex){
                JOptionPane.showMessageDialog(this, "E dhena ekziston!");
            }
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
                JFileChooser fc=new JFileChooser();
        FileReader fr;
        BufferedReader br;
        String leximRreshti = null;
        int countPerdorues = 0;
        PerdoruesiRepository perdoruesiRepository = new PerdoruesiRepository();
        int i=fc.showOpenDialog(this);
        
        if(i==JFileChooser.APPROVE_OPTION){
            File f=fc.getSelectedFile();
            try{
                fr = new FileReader(f);
                br = new BufferedReader(fr);

                //read it
                while((leximRreshti = br.readLine())!=null){
                    countPerdorues++;
                    Perdoruesi p = new Perdoruesi();
                    String[] arguments = leximRreshti.split("-");
                    String username = arguments[0];
                    String password = arguments[1];
                    Integer rolInteger = Integer.parseInt(arguments[2]);
                    p.setUsername(username);
                    p.setPasswordi(password);
                    p.setRoliID(new Roli(rolInteger));
                    perdoruesiRepository.create(p);
                    loadFirstPage();
                   

                }
                 JOptionPane.showMessageDialog(this, "U shtuan : " + countPerdorues);

            }catch(IOException e){
            }  catch (PerdoruesiException ex) {
                Logger.getLogger(PerdoruesiFormReal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
       
         try {
             DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
             
             int result []  = perdoruesiRepository.countPersonelAdminandWorker();
             
             categoryDataset.setValue(result[0],"Numri","Administrator");
             categoryDataset.setValue(result[1],"Marks","Punetor");
             
             
             JFreeChart chart = ChartFactory.createBarChart3D("Numri i llogarive te perdoruesve","Lloji i perdoruesit","Numri", categoryDataset,PlotOrientation.VERTICAL,false,true,false);
             
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
         String perdoruesi = jTextField1.getText();
        TableRowSorter trs = new TableRowSorter(perdoruesiTableModel);
        tablePerdorues.setRowSorter(trs);
        
        trs.setRowFilter(RowFilter.regexFilter(perdoruesi));
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
       //
         try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               String url = "jdbc:sqlserver://localhost:1433;DatabaseName=FilmixDataStore";
               Connection connection = DriverManager.getConnection(url, "DrenBilalli", "Dren1234");
              
               JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Admin\\Desktop\\Filmix\\src\\gid\\Raportet\\PerdoruesiRaport.jrxml"
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

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        loadTable();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void tablePerdoruesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablePerdoruesKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_DELETE){
             int row = tablePerdorues.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Yes", "No"};
            int i = JOptionPane.showOptionDialog(this, "Are you sure?", "Delete", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                Perdoruesi p = perdoruesiTableModel.getPerdoruesi(row);
                perdoruesiRepository.remove(p);

                loadFirstPage();
                clear();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nuk eshte selektuar asgje per te fshire.");
        }
        }
        
    }//GEN-LAST:event_tablePerdoruesKeyPressed
//pagination
    public void loadFirstPage(){
        List<Perdoruesi> list = perdoruesiRepository.fetchSomeValues(0,14);
        perdoruesiTableModel.addList(list);
           tablePerdorues.setModel(perdoruesiTableModel);
           perdoruesiTableModel.fireTableDataChanged();
    }
    public void loadSecondPage(){
        List<Perdoruesi> list = perdoruesiRepository.fetchSomeValues(14,14);
        perdoruesiTableModel.addList(list);
           tablePerdorues.setModel(perdoruesiTableModel);
           perdoruesiTableModel.fireTableDataChanged();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JComboBox roliCmb;
    private javax.swing.JTable tablePerdorues;
    public javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
