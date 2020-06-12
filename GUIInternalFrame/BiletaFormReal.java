/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIInternalFrame;

import BLL.Bileta;
import BLL.Klienti;
import BLL.Sallat;
import BLL.StreamingFilmat;
import BLL.Ulset;
import BLL.Ushqimi;
import DAL.BiletaRepository;
import DAL.FilmiException;
import DAL.KlientiRepository;
import DAL.PerdoruesiException;
import DAL.SallaRepository;
import DAL.ShitjeException;
import DAL.StreamingFilmatRepository;
import DAL.UlsetRepository;
import DAL.UshqimiRepository;
import GUIMODEL.BiletaTableModel;
import GUIMODEL.KlientiComboBoxModel;
import GUIMODEL.SallatComboBoxModel;
import GUIMODEL.StreamingFilmatComboBox;
import GUIMODEL.UlsetComboBoxModel;
import GUIMODEL.UshqimiComboBoxModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Dren
 */
public class BiletaFormReal extends javax.swing.JInternalFrame {

    /**
     * Creates new form BiletaFormReal
     */
    
    BiletaRepository biletaRepository = new BiletaRepository();
    BiletaTableModel biletaTableModel = new BiletaTableModel();
    SallatComboBoxModel sallaComboBoxModel = new SallatComboBoxModel();
    StreamingFilmatComboBox streamingFilmatComboBox = new StreamingFilmatComboBox();
    UlsetComboBoxModel ulsetComboBoxModel = new UlsetComboBoxModel();
    UshqimiComboBoxModel ushqimiComboBoxModel = new UshqimiComboBoxModel();
    SallaRepository sallaRepository = new SallaRepository();
    KlientiRepository klientiRepository = new KlientiRepository();
    KlientiComboBoxModel klientiComboBoxModel = new KlientiComboBoxModel();
    StreamingFilmatRepository streamingFilmatRepository = new StreamingFilmatRepository();
    UlsetRepository ulsetRepository = new UlsetRepository();
    UshqimiRepository ushqimiRepository = new UshqimiRepository();
    
            
    
    
    public BiletaFormReal() {
        initComponents();
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        tabelaSelectedIndexChange();
        loadComboBoxKlienti();
        loadComboBoxSalla();
        loadFirstPage();
        loadComboBoxStreaming();
        loadComboBoxUlset();
        loadComboBoxUshqimi();
        loadRenderComboBoxat();
        setBackground(new Color(0,0,0,0));
        tableBileta.getTableHeader().setFont(new Font("Seqoe UI", Font.BOLD,12));
        tableBileta.getTableHeader().setOpaque(false);
        tableBileta.getTableHeader().setBackground(new Color(54,33,89));
        tableBileta.getTableHeader().setForeground(new Color(255,255,255));
        tableBileta.setRowHeight(25);
    }
    
      public void loadTable(){
          List<Bileta> lista = biletaRepository.findAll();
          biletaTableModel.addList(lista);
          tableBileta.setModel(biletaTableModel);
          biletaTableModel.fireTableDataChanged();
    
    }
      
         private void tabelaSelectedIndexChange(){
        final ListSelectionModel rowSM = tableBileta.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    return;
                }
                
                ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if(selectedIndex > -1){
                    Bileta b = biletaTableModel.getBileta(selectedIndex);
                    klientiCmb.getModel().setSelectedItem(b.getKlientiID());
                    sallaCmb.getModel().setSelectedItem(b.getSallaID());
                    streamingCmb.getModel().setSelectedItem(b.getStreamingFilmID());
                    ulsetCmb.getModel().setSelectedItem(b.getUlesejaID());
                    ushqimiCmb.getModel().setSelectedItem(b.getUshqimiID());
                }
            }
        });
    }
        
    public void loadComboBoxSalla(){
        try {
            List<Sallat> lista = sallaRepository.findAll();
            sallaComboBoxModel.addList(lista);
            sallaCmb.setModel(sallaComboBoxModel);
            sallaCmb.repaint();
        } catch (FilmiException ex) {
            Logger.getLogger(BiletaFormReal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void loadComboBoxKlienti(){
        try {
            List<Klienti> lista =klientiRepository.findAll();
            klientiComboBoxModel.addList(lista);
            klientiCmb.setModel(klientiComboBoxModel);
            klientiCmb.repaint();
        } catch (PerdoruesiException ex) {
            Logger.getLogger(BiletaFormReal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void loadComboBoxStreaming(){
        try {
            List<StreamingFilmat> lista = streamingFilmatRepository.findAll();
            streamingFilmatComboBox.addList(lista);
            streamingCmb.setModel(streamingFilmatComboBox);
            streamingCmb.repaint();
        } catch (FilmiException ex) {
            Logger.getLogger(BiletaFormReal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void loadComboBoxUlset(){
        try {
            List<Ulset> lista = ulsetRepository.findAll();
            ulsetComboBoxModel.addList(lista);
            ulsetCmb.setModel(ulsetComboBoxModel);
            ulsetCmb.repaint();
        } catch (FilmiException ex) {
            Logger.getLogger(BiletaFormReal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void loadComboBoxUshqimi(){
        List<Ushqimi> lista = ushqimiRepository.findAll();
        ushqimiComboBoxModel.addList(lista);
        ushqimiCmb.setModel(ushqimiComboBoxModel);
        ushqimiCmb.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        klientiCmb = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        sallaCmb = new javax.swing.JComboBox();
        streamingCmb = new javax.swing.JComboBox();
        ulsetCmb = new javax.swing.JComboBox();
        ushqimiCmb = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBileta = new javax.swing.JTable();
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
        firstPageIcon = new javax.swing.JLabel();
        secondPageIcon = new javax.swing.JLabel();
        allPageIcon = new javax.swing.JLabel();
        klientiSearch = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(122, 72, 221));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_client_management_20px_1.png")); // NOI18N
        jLabel4.setText("Klienti");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_curtains_20px.png")); // NOI18N
        jLabel15.setText("Salla");

        klientiCmb.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        klientiCmb.setForeground(new java.awt.Color(255, 255, 255));
        klientiCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_kawaii_french_fries_20px.png")); // NOI18N
        jLabel14.setText("Ushqimi");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_tv_show_20px.png")); // NOI18N
        jLabel18.setText("Streaming");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_aircraft_seat_aisle_20px.png")); // NOI18N
        jLabel19.setText("Uleseja");

        sallaCmb.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        sallaCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        streamingCmb.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        streamingCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ulsetCmb.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        ulsetCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ushqimiCmb.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        ushqimiCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(klientiCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(sallaCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(streamingCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(ulsetCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(ushqimiCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(klientiCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(streamingCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ulsetCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sallaCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ushqimiCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, -1));

        tableBileta.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBileta.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableBileta.setRowHeight(25);
        tableBileta.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tableBileta.setShowVerticalLines(false);
        tableBileta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableBileta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 780, 400));

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel10)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 780, 80));

        firstPageIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_1_24px_9.png"))); // NOI18N
        firstPageIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstPageIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                firstPageIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                firstPageIconMouseExited(evt);
            }
        });
        getContentPane().add(firstPageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, 40));

        secondPageIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_2_24px_3.png"))); // NOI18N
        secondPageIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                secondPageIconMouseClicked(evt);
            }
        });
        getContentPane().add(secondPageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 30, 40));

        allPageIcon.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        allPageIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_all_out_20px.png")); // NOI18N
        allPageIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allPageIconMouseClicked(evt);
            }
        });
        getContentPane().add(allPageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 40, -1));

        klientiSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                klientiSearchKeyTyped(evt);
            }
        });
        getContentPane().add(klientiSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 130, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotot/icons8_search_24px_6.png"))); // NOI18N
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, 20));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(122, 72, 221));
        jLabel17.setText("Search:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

            if(klientiCmb.getSelectedItem() == null || sallaCmb.getSelectedItem() == null || 
                    streamingCmb.getSelectedItem() == null || ulsetCmb.getSelectedItem() == null){
                JOptionPane.showMessageDialog(this, "Vlerat null nuk lejohen");
            }else{
        
        
                       try{
                     int row = tableBileta.getSelectedRow();
                                if(row == -1){
                                        Bileta b = new Bileta();
                                        b.setKlientiID((Klienti) klientiCmb.getSelectedItem());
                                        b.setSallaID((Sallat)sallaCmb.getSelectedItem());
                                        b.setStreamingFilmID((StreamingFilmat)streamingCmb.getSelectedItem());
                                        b.setUlesejaID((Ulset)ulsetCmb.getSelectedItem());
                                        b.setUshqimiID((Ushqimi)ushqimiCmb.getSelectedItem());
                                        
                                        biletaRepository.create(b);
                    
                                    }else{
                                        Bileta b = biletaTableModel.getBileta(row);
                                         b.setKlientiID((Klienti) klientiCmb.getSelectedItem());
                                        b.setSallaID((Sallat)sallaCmb.getSelectedItem());
                                        b.setStreamingFilmID((StreamingFilmat)streamingCmb.getSelectedItem());
                                        b.setUlesejaID((Ulset)ulsetCmb.getSelectedItem());
                                        b.setUshqimiID((Ushqimi)ushqimiCmb.getSelectedItem());
                                        biletaRepository.edit(b);
                                    }
                
                                clear();
                                loadFirstPage();
                            } catch (ShitjeException ex) {
                                JOptionPane.showMessageDialog(this,"Ka ndodhur nje gabim!");
                                Logger.getLogger(UshqimiFormReal.class.getName()).log(Level.SEVERE, null, ex);
                            }}
                    
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

                int row = tableBileta.getSelectedRow();
                if (row != -1) {
                        Object[] ob = {"Yes", "No"};
                        int i = JOptionPane.showOptionDialog(this, "Are you sure?", "Delete", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                        if (i == 0) {
                                Bileta b = biletaTableModel.getBileta(row);
                                biletaRepository.remove(b);
                                loadFirstPage();
                                clear();
                            }
                    } else {
                        JOptionPane.showMessageDialog(this, "Nuk eshte selektuar asgje per te fshire.");
                    }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        clear();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
            JOptionPane.showMessageDialog(this, "Nuk eshte e disponueshme");
        //
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
       //charts....................
        //gjetja e salles me  se shumti her qe eshte perdorur ne bilet dhe me se paku spo di qka tjeter..
        try {
            String rezultati [] = biletaRepository.maxSalla();
            String rezultatiMin [] = biletaRepository.minSalla();
            
            Integer sallaIDMax = Integer.parseInt(rezultati[0]);
            Integer sallaIDMin = Integer.parseInt(rezultatiMin[0]);
            
            Sallat sallat = sallaRepository.findById(sallaIDMax);
            Integer numrimax = Integer.parseInt(rezultati[1]);
           
            Sallat sallatmin = sallaRepository.findById(sallaIDMin);
            Integer numriMin = Integer.parseInt(rezultatiMin[1]);
            
            DefaultPieDataset pieDataset = new DefaultPieDataset();
            
            pieDataset.setValue(sallat.getEmriSalles(),sallaIDMax);
            pieDataset.setValue(sallatmin.getEmriSalles(),sallaIDMin);
            
            JFreeChart chart = ChartFactory.createPieChart3D("Maksimumi dhe Minimumi i sallave qe eshte perdorur ne Streaming",pieDataset, true,true,true);
           
            PiePlot p= (PiePlot)chart.getPlot();
           
            // p.setForegroundAlpha(TOP_ALIGNMENT);
            ChartFrame frame = new ChartFrame("kmmk",chart);
            
            frame.setVisible(true);
           
            frame.setSize(800, 400);
            } catch (PerdoruesiException ex) {
            Logger.getLogger(BiletaFormReal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FilmiException ex) {
            Logger.getLogger(BiletaFormReal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
       
        /*
         Query per mundesimin e gjenerimit te raportit
        select t1.BiletaID,t2.FilmiID,t3.EmriMbiemri,t4.EmriUlses,t2.DataFilmit,t5.EmriSalles from Bileta t1
        inner join Streaming_Filmat t2
            on t1.StreamingFilmID = t2.StreamingFilmID
                inner join Klienti t3
            on t1.KlientiID = t3.KlientiID
                inner join Ulset t4
                        on t1.UlesejaID = t4.UlesejaID
                    inner join Sallat t5
                on t1.SallaID = t5.SallaID
        */
                 try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               String url = "jdbc:sqlserver://localhost:1433;DatabaseName=FilmixDataStore";
               Connection connection = DriverManager.getConnection(url, "DrenBilalli", "Dren1234");
              
               JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Admin\\Desktop\\Filmix\\src\\gid\\Raportet\\BiletaRaport.jrxml"
                       + "");

               Map<String, Object> params = new HashMap<>();
                    JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                                JasperPrint jasperPrint = JasperFillManager.fillReport(jreport, params, connection);
                                JasperViewer.viewReport(jasperPrint);
          } catch (JRException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PerdoruesiFormReal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void firstPageIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstPageIconMouseClicked
        loadFirstPage();
    }//GEN-LAST:event_firstPageIconMouseClicked

    private void firstPageIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstPageIconMouseEntered

    }//GEN-LAST:event_firstPageIconMouseEntered

    private void firstPageIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstPageIconMouseExited

    }//GEN-LAST:event_firstPageIconMouseExited

    private void secondPageIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secondPageIconMouseClicked

        loadSecondPage();
    }//GEN-LAST:event_secondPageIconMouseClicked

    private void allPageIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allPageIconMouseClicked
        loadTable();
    }//GEN-LAST:event_allPageIconMouseClicked

    private void klientiSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_klientiSearchKeyTyped
        String bileta = klientiSearch.getText();
        TableRowSorter trs = new TableRowSorter(biletaTableModel);
        tableBileta.setRowSorter(trs);

        trs.setRowFilter(RowFilter.regexFilter(bileta));
    }//GEN-LAST:event_klientiSearchKeyTyped

    
    
    public void clear(){
        klientiCmb.setSelectedIndex(-1);
        sallaCmb.setSelectedIndex(-1);
        streamingCmb.setSelectedIndex(-1);
        ulsetCmb.setSelectedIndex(-1);
        ushqimiCmb.setSelectedIndex(-1);
    }

      public void loadFirstPage(){
        List<Bileta> list = biletaRepository.fetchSomeValues(0,14);
        biletaTableModel.addList(list);
           tableBileta.setModel(biletaTableModel);
           biletaTableModel.fireTableDataChanged();
    }
    public void loadSecondPage(){
        List<Bileta> list = biletaRepository.fetchSomeValues(14,14);
        biletaTableModel.addList(list);
           tableBileta.setModel(biletaTableModel);
           biletaTableModel.fireTableDataChanged();
    }
    
    public void loadRenderComboBoxat(){
       Component [] components = jPanel2.getComponents();
       
       for(Component component : components){
           if(component instanceof JComboBox){
               ((JComboBox)component).setRenderer(new ColorRenderer(((JComboBox)component).getRenderer()));
               ((JComboBox)component).setForeground(new Color(122,72,221));
           }
       }
       
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel allPageIcon;
    private javax.swing.JLabel firstPageIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JComboBox klientiCmb;
    private javax.swing.JTextField klientiSearch;
    private javax.swing.JComboBox sallaCmb;
    private javax.swing.JLabel secondPageIcon;
    private javax.swing.JComboBox streamingCmb;
    private javax.swing.JTable tableBileta;
    private javax.swing.JComboBox ulsetCmb;
    private javax.swing.JComboBox ushqimiCmb;
    // End of variables declaration//GEN-END:variables

    
    class ColorRenderer extends DefaultListCellRenderer {

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

 }




