/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIInternalFrame;

import BLL.StreamingFilmat;
import BLL.Filmi;
import DAL.FilmiException;
import DAL.FilmiRepository;
import DAL.StreamingFilmatRepository;
import GUIMODEL.FilmiComboBoxModel;
import GUIMODEL.StreamingMoviesTableModelForAdmin;
import gid.Dashboard;
import gid.StreamingForm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
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
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Dren
 */
public class StreamingFormReal extends javax.swing.JInternalFrame {

    /**
     * Creates new form StreamingFormReal
     */
    
    StreamingFilmatRepository streamingFilmatRepository = new StreamingFilmatRepository();
    StreamingMoviesTableModelForAdmin streamingTableModel = new StreamingMoviesTableModelForAdmin();
   
    
    FilmiComboBoxModel filmiComboBoxModel = new FilmiComboBoxModel();
    FilmiRepository filmiRepository = new FilmiRepository();
    
    
    public StreamingFormReal() {
        initComponents();
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        loadComboBox();
        loadTable();
        loadFirstPage();
        renderComboBox();
        tabelaSelectedIndexChange();
        setBackground(new Color(0,0,0,0));
        tableStreaming.getTableHeader().setFont(new Font("Seqoe UI", Font.BOLD,12));
        tableStreaming.getTableHeader().setOpaque(false);
        tableStreaming.getTableHeader().setBackground(new Color(54,33,89));
        tableStreaming.getTableHeader().setForeground(new Color(255,255,255));
        tableStreaming.setRowHeight(25);
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
        try {
            List<StreamingFilmat> lista = streamingFilmatRepository.findAll();
            streamingTableModel.addList(lista);
            tableStreaming.setModel(streamingTableModel);
            streamingTableModel.fireTableDataChanged();
        } catch (FilmiException ex) {
            Logger.getLogger(StreamingFormReal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
       private void tabelaSelectedIndexChange(){
        final ListSelectionModel rowSM = tableStreaming.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    return;
                }
                
                ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if(selectedIndex > -1){
                    StreamingFilmat s = streamingTableModel.getStreamingFilmat(selectedIndex);
                   usernameTextField.setText(String.valueOf(s.getCmimi()));
                   jDateChooser1.setDate(s.getDataFilmit());
                   usernameTextField1.setText(getTimeToString(s.getOraFillimit()));
                   usernameTextField2.setText(getTimeToString(s.getOraMbarimit()));
                   filmiCmb.getModel().setSelectedItem(s.getFilmiID());
                }
            }
        });
    }

       public String getTimeToString(Date d){
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        return dateFormat.format(d);
    }
    
    public void loadComboBox(){
        List<Filmi> lista = filmiRepository.findAll();
        filmiComboBoxModel.addList(lista);
        filmiCmb.setModel(filmiComboBoxModel);
        filmiCmb.repaint();
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
        usernameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        filmiCmb = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        usernameTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        usernameTextField2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStreaming = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_price_20px_1.png")); // NOI18N
        jLabel4.setText("Cmimi");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_pay_date_20px.png")); // NOI18N
        jLabel15.setText("Data Filmit");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("$");

        filmiCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_movie_20px_1.png")); // NOI18N
        jLabel14.setText("Filmi");

        usernameTextField1.setBackground(new java.awt.Color(122, 72, 221));
        usernameTextField1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        usernameTextField1.setForeground(new java.awt.Color(255, 255, 255));
        usernameTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        usernameTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameTextField1KeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_clock_20px_1.png")); // NOI18N
        jLabel18.setText("Ora Fillmit");

        usernameTextField2.setBackground(new java.awt.Color(122, 72, 221));
        usernameTextField2.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        usernameTextField2.setForeground(new java.awt.Color(255, 255, 255));
        usernameTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        usernameTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameTextField2KeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_clock_20px_2.png")); // NOI18N
        jLabel19.setText("Ora Mbarimit");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(usernameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(usernameTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(filmiCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel14)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(usernameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(filmiCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(usernameTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, -1));

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
        jLabel13.setText("Reports");

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
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

        tableStreaming.setModel(new javax.swing.table.DefaultTableModel(
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
        tableStreaming.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableStreaming.setRowHeight(25);
        tableStreaming.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tableStreaming.setShowVerticalLines(false);
        tableStreaming.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableStreaming);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 780, 400));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_1_24px_9.png"))); // NOI18N
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, -1, 40));

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_3_24px_1.png")); // NOI18N
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, -1, 40));

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

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotot/icons8_search_24px_6.png"))); // NOI18N
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, 20));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_all_out_20px.png")); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 40, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconForInternalFrame/icons8_2_24px_3.png"))); // NOI18N
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 30, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextFieldKeyTyped

    }//GEN-LAST:event_usernameTextFieldKeyTyped

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        long cmimi = Long.parseLong(usernameTextField.getText());
        if(usernameTextField1.getText().length() ==0 || usernameTextField1.getText().length() ==0 || usernameTextField2.getText().length() == 0){
            JOptionPane.showMessageDialog(this,"Keni gabuar ne shkrimin e te dhenave per ushqim");
        }else{
            try{
                int row = tableStreaming.getSelectedRow();
                if(row == -1){
                    StreamingFilmat s = new StreamingFilmat();
                    s.setCmimi(cmimi);
                    s.setDataFilmit(jDateChooser1.getDate());
                    s.setOraFillimit(parseToTime(usernameTextField1.getText()));
                     s.setOraMbarimit(parseToTime(usernameTextField2.getText()));
                     s.setFilmiID((Filmi)filmiCmb.getSelectedItem());
                
                    streamingFilmatRepository.create(s);

                }else{
                    StreamingFilmat s = streamingTableModel.getStreamingFilmat(row);
                    s.setCmimi(cmimi);
                    s.setDataFilmit(jDateChooser1.getDate());
                    s.setOraFillimit(parseToTime(usernameTextField1.getText()));
                     s.setOraMbarimit(parseToTime(usernameTextField2.getText()));
                     s.setFilmiID((Filmi)filmiCmb.getSelectedItem());
                    streamingFilmatRepository.edit(s);
                }

                clear();
                loadFirstPage();
            } catch (FilmiException ex) {
                Logger.getLogger(StreamingFormReal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jLabel1MouseClicked

    
    private void clear(){
            
        usernameTextField.setText("");
        jDateChooser1.setDate(null);
        usernameTextField1.setText("");
        usernameTextField2.setText("");
        filmiCmb.setSelectedIndex(-1);
    }
    
     private Date parseToTime(String ora){
       
        try {
            SimpleDateFormat date1 = new SimpleDateFormat("hh:mm:ss");
            Date date = null;
            
            date = date1.parse(ora);
            
            return date;
            
            
            
        } catch (ParseException ex) {
            Logger.getLogger(StreamingForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        int row = tableStreaming.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Yes", "No"};
            int i = JOptionPane.showOptionDialog(this, "Are you sure?", "Delete", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                try {
                    StreamingFilmat s = streamingTableModel.getStreamingFilmat(row);
                    streamingFilmatRepository.delete(s);
                    loadFirstPage();
                    clear();
                } catch (FilmiException ex) {
                    Logger.getLogger(StreamingFormReal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nuk eshte selektuar asgje per te fshire.");
        }

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        clear();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked

        //
    }//GEN-LAST:event_jLabel8MouseClicked

    private void usernameTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextField1KeyTyped

    private void usernameTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextField2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextField2KeyTyped

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        loadFirstPage();

    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered

    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited

    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked

        loadThirdPage();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        String streaming = jTextField1.getText();
        TableRowSorter trs = new TableRowSorter(streamingTableModel);
        tableStreaming.setRowSorter(trs);
        
        trs.setRowFilter(RowFilter.regexFilter(streaming));
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
      
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Java e pare",streamingFilmatRepository.countFirstWeek());
        pieDataset.setValue("Java e dyte", streamingFilmatRepository.countSecondWeek());
        pieDataset.setValue("Java e trete", streamingFilmatRepository.countThirdWeek());
        JFreeChart chart = ChartFactory.createPieChart3D(null, pieDataset);
        PiePlot p= (PiePlot)chart.getPlot();
        ChartFrame chartFrame = new ChartFrame("D", chart);
        chart.getPlot().setBackgroundPaint(new Color(255,255,255));
        chartFrame.setSize(800,400);
        chartFrame.setVisible(true);
        
    

    
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        loadTable();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        /*
            Paraqitja e emrit te filmit jo vetem FilmiID ,StreamingID  ,Cmimi si edhe dataFIlmit;
            query..
            select t1.StreamingFilmID,t1.DataFilmit,t1.Cmimi,t2.EmriFilmit from Streaming_Filmat t1
                inner join Filmi t2
                            on t1.FilmiID = t2.FilmiID
        */
        try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               String url = "jdbc:sqlserver://localhost:1433;DatabaseName=FilmixDataStore";
               Connection connection = DriverManager.getConnection(url, "DrenBilalli", "Dren1234");
              
               JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Admin\\Desktop\\Filmix\\src\\gid\\Raportet\\StreamingFilmatReport.jrxml"
                       + "");

               Map<String, Object> params = new HashMap<>();
                    JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                                JasperPrint jasperPrint = JasperFillManager.fillReport(jreport, params, connection);
                                JasperViewer.viewReport(jasperPrint);
          } catch (JRException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PerdoruesiFormReal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jLabel12MouseClicked


      public void loadFirstPage(){
        List<StreamingFilmat> list = streamingFilmatRepository.fetchSomeValues(0,14);
        streamingTableModel.addList(list);
           tableStreaming.setModel(streamingTableModel);
           streamingTableModel.fireTableDataChanged();
    }
    public void loadSecondPage(){
        List<StreamingFilmat> list = streamingFilmatRepository.fetchSomeValues(14,14);
        streamingTableModel.addList(list);
           tableStreaming.setModel(streamingTableModel);
           streamingTableModel.fireTableDataChanged();
    }
    public void loadThirdPage(){
        List<StreamingFilmat> list = streamingFilmatRepository.fetchSomeValues(28,14);
        streamingTableModel.addList(list);
           tableStreaming.setModel(streamingTableModel);
           streamingTableModel.fireTableDataChanged();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox filmiCmb;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JTable tableStreaming;
    public javax.swing.JTextField usernameTextField;
    public javax.swing.JTextField usernameTextField1;
    public javax.swing.JTextField usernameTextField2;
    // End of variables declaration//GEN-END:variables
}
