/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid;

import BLL.Bileta;
import BLL.Klienti;
import BLL.Sallat;
import BLL.StreamingFilmat;
import BLL.Ulset;
import BLL.Ushqimi;
import DAL.BiletaRepository;
import DAL.FilmiException;
import DAL.KlientiRepository;
import DAL.PagesatRepository;
import DAL.PerdoruesiException;
import DAL.SallaRepository;
import DAL.ShitjeException;
import DAL.StreamingFilmatRepository;
import DAL.UlsetRepository;
import DAL.UshqimiRepository;
import GUIMODEL.SallatComboBoxModel;
import GUIMODEL.StreamingFilmatComboBox;
import GUIMODEL.UlsetComboBoxModel;
import GUIMODEL.UshqimiComboBoxModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Dren
 */
public class AddTicketForm extends javax.swing.JFrame {

    /**
     * Creates new form AddTicketForm
     */
    
     KlientiRepository k = new KlientiRepository();
    BiletaRepository biletaRepository = new BiletaRepository();
    SallatComboBoxModel sallatComboBoxModel = new SallatComboBoxModel();
    SallaRepository sallaRepository = new SallaRepository();
    StreamingFilmatComboBox streamingFilmatComboBox = new StreamingFilmatComboBox();
    StreamingFilmatRepository streamingFilmatRepository = new StreamingFilmatRepository();
    UlsetRepository ulsetRepository = new UlsetRepository();
    UlsetComboBoxModel ulsetComboBoxModel = new UlsetComboBoxModel();
    PagesatRepository pagesatRepository = new PagesatRepository();
    UshqimiRepository ushqimiRepository = new UshqimiRepository();
    UshqimiComboBoxModel ushqimiComboBoxModel = new UshqimiComboBoxModel();
    
    public AddTicketForm() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setRendererForComboBox();
        loadComboBoxSallat();
        loadComboBoxStreaming();
        loadComboBoxUlset();
        loadComboBoxUshqimi();
     //   comboBoxHall.setRenderer(new ColorRenderer(comboBoxHall.getRenderer()));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelBookTicket = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        clientNameTF1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboBoxHall = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        comboBoxStreamingMovie1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        comboBoxSeat = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        foodcmb = new javax.swing.JComboBox();
        registerButton = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_ticket_100px_2.png")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelBookTicket.setBackground(new java.awt.Color(22, 96, 131));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_ticket_100px_2.png")); // NOI18N

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book a Ticket");

        clientNameTF1.setBackground(new java.awt.Color(22, 96, 131));
        clientNameTF1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        clientNameTF1.setForeground(new java.awt.Color(255, 255, 255));
        clientNameTF1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        clientNameTF1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                clientNameTF1clientNameTFKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_name_16px.png")); // NOI18N
        jLabel13.setText("Client Name");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_curtains_16px.png")); // NOI18N
        jLabel14.setText("Hall");

        comboBoxHall.setBackground(new java.awt.Color(214, 75, 75));
        comboBoxHall.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        comboBoxHall.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxHall.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxHall.setSelectedItem("Zgjedh Rolin");
        comboBoxHall.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        comboBoxHall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxHall.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_tv_16px.png")); // NOI18N
        jLabel15.setText("Streaming Movie");

        comboBoxStreamingMovie1.setBackground(new java.awt.Color(214, 75, 75));
        comboBoxStreamingMovie1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        comboBoxStreamingMovie1.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxStreamingMovie1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxStreamingMovie1.setSelectedItem("Zgjedh Rolin");
        comboBoxStreamingMovie1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        comboBoxStreamingMovie1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxStreamingMovie1.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_aircraft_seat_aisle_16px.png")); // NOI18N
        jLabel8.setText("Seat");

        comboBoxSeat.setBackground(new java.awt.Color(214, 75, 75));
        comboBoxSeat.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        comboBoxSeat.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxSeat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxSeat.setSelectedItem("Zgjedh Rolin");
        comboBoxSeat.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        comboBoxSeat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxSeat.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\AppData\\Local\\Temp\\icons8_kawaii_french_fries_16px.png")); // NOI18N
        jLabel9.setText("Food");

        foodcmb.setBackground(new java.awt.Color(214, 75, 75));
        foodcmb.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        foodcmb.setForeground(new java.awt.Color(255, 255, 255));
        foodcmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        foodcmb.setSelectedItem("Zgjedh Rolin");
        foodcmb.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        foodcmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        foodcmb.setOpaque(false);

        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotot/addMovie.png"))); // NOI18N
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerButtonMouseExited(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotot/icons8_previous_24px.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBookTicketLayout = new javax.swing.GroupLayout(panelBookTicket);
        panelBookTicket.setLayout(panelBookTicketLayout);
        panelBookTicketLayout.setHorizontalGroup(
            panelBookTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookTicketLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookTicketLayout.createSequentialGroup()
                .addGroup(panelBookTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBookTicketLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBookTicketLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(panelBookTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxSeat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(foodcmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookTicketLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboBoxStreamingMovie1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelBookTicketLayout.createSequentialGroup()
                                .addGroup(panelBookTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(clientNameTF1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(comboBoxHall, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(163, 163, 163))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookTicketLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBookTicketLayout.setVerticalGroup(
            panelBookTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookTicketLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(clientNameTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(comboBoxHall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(comboBoxStreamingMovie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(comboBoxSeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(foodcmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(registerButton)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBookTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBookTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientNameTF1clientNameTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clientNameTF1clientNameTFKeyTyped

    }//GEN-LAST:event_clientNameTF1clientNameTFKeyTyped
    //renderer for all combobox
    
        public void setRendererForComboBox(){
            
            Component [] conComponents = panelBookTicket.getComponents();
         //   int count = 0;
            for(Component component: conComponents){
                if(component instanceof JComboBox){
                   ((JComboBox)component).setRenderer(new ColorRenderer(((JComboBox)component).getRenderer()));
                  
                   ((JComboBox)component).setForeground(new Color(22,96,131));
                  
                }
               
                
               
                
                
        }
            //System.out.println(count);
        }
    
    
    
    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked

        Bileta b = new Bileta();
        Klienti klienti = new Klienti();

        try {
            String emrimbiemri = clientNameTF1.getText();

            StreamingFilmat selectedItem = (StreamingFilmat)streamingFilmatComboBox.getSelectedItem();
            Ushqimi selectedUshqim = (Ushqimi)foodcmb.getSelectedItem();
            String emriUshqimit = (foodcmb.getSelectedItem() == null) ? "Nuk ka zgjedhur" : foodcmb.getSelectedItem().toString();

            StreamingFilmat f = (StreamingFilmat)comboBoxStreamingMovie1.getSelectedItem();

            klienti.setEmriMbiemri(emrimbiemri);
            k.create(klienti);

            b.setKlientiID(klienti);
            b.setSallaID((Sallat)comboBoxHall.getSelectedItem());
            b.setStreamingFilmID(f);
            b.setUlesejaID((Ulset)comboBoxSeat.getSelectedItem());
            b.setUshqimiID((Ushqimi)foodcmb.getSelectedItem());

            long cmimi = (foodcmb.getSelectedItem()== null) ? f.getCmimi() : f.getCmimi() + selectedUshqim.getCmimi();

            biletaRepository.create(b);
            this.dispose();
            
            MenyraPagesesForm menyraPagesesForm = new MenyraPagesesForm(emrimbiemri,comboBoxSeat.getSelectedItem().toString(),comboBoxHall.getSelectedItem().toString(),cmimi,b,comboBoxStreamingMovie1.getSelectedItem().toString(),emriUshqimit);
            menyraPagesesForm.setVisible(true);
        } catch (PerdoruesiException ex) {
            Logger.getLogger(AddTicketForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ShitjeException ex) {
            Logger.getLogger(AddTicketForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_registerButtonMouseClicked

    private void registerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseEntered
        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotot/addMovieHover.png"))); // NOI18N
    }//GEN-LAST:event_registerButtonMouseEntered

    private void registerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseExited
        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotot/addMovie.png"))); // NOI18N
    }//GEN-LAST:event_registerButtonMouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

        this.dispose();
        Dashboard d = new Dashboard(Dashboard.getPerdoruesUsername());
        d.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
            for(double i = 0.0; i<1.0;i=i+ 0.1){
          String value = i+ "";
          float f = Float.valueOf(value);
          this.setOpacity(f);
          try{
              Thread.sleep(50);
          }catch(Exception e){
              e.printStackTrace();
          }
      }  
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddTicketForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTicketForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTicketForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTicketForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTicketForm().setVisible(true);
            }
        });
    }
    
      public void loadComboBoxUshqimi(){
        List<Ushqimi> lista = ushqimiRepository.findAll();
        ushqimiComboBoxModel.addList(lista);
        foodcmb.setModel(ushqimiComboBoxModel);
        foodcmb.repaint();
    }
    
    
    
     public void loadComboBoxStreaming(){
        try{
        List<StreamingFilmat> lista = streamingFilmatRepository.findAll();
        streamingFilmatComboBox.addList(lista);
        comboBoxStreamingMovie1.setModel(streamingFilmatComboBox);
        comboBoxStreamingMovie1.repaint();
        }catch(FilmiException e){
            
        }
    }
     
    public void loadComboBoxUlset(){
        try{
        List<Ulset> lista = ulsetRepository.findAll();
        ulsetComboBoxModel.addList(lista);
        comboBoxSeat.setModel(ulsetComboBoxModel);
        comboBoxSeat.repaint();
        }catch(FilmiException e){
            
        }
    }
    public void loadComboBoxSallat(){
        try{
        List<Sallat> lista = sallaRepository.findAll();
        sallatComboBoxModel.addList(lista);
        comboBoxHall.setModel(sallatComboBoxModel);
        comboBoxHall.repaint();
        }catch(FilmiException e){
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField clientNameTF1;
    private javax.swing.JComboBox comboBoxHall;
    private javax.swing.JComboBox comboBoxSeat;
    private javax.swing.JComboBox comboBoxStreamingMovie1;
    private javax.swing.JComboBox foodcmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelBookTicket;
    private javax.swing.JLabel registerButton;
    // End of variables declaration//GEN-END:variables
}


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
        c.setBackground(new Color(17,170,243));
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

