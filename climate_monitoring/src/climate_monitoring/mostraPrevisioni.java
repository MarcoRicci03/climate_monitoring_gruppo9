/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package climate_monitoring;

import classi.JPrevisioni;
import classi.ParserCSV;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author marco
 */
public class mostraPrevisioni extends javax.swing.JFrame implements WindowListener {

    public static int id;
    public static int idStazione;

    /**
     * Creates new form mostraPrevisioni
     */
    public mostraPrevisioni(int id, int idStazione) throws IOException {
        initComponents();
        this.id = id;
        this.idStazione = idStazione;
        lblTitle.setText("Previsioni: " + ParserCSV.getNomeStazioneById(id));

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date currentDate = new Date();

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
        c.add(Calendar.DATE, 14);

        // convert calendar to date
        Date dateTwoWeekAfter = c.getTime();

        jCalendar.setTodayButtonVisible(true);
        jCalendar.setSelectableDateRange(new Date(), dateTwoWeekAfter);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String strData = sdf.format(new Date());
        ArrayList<JPrevisioni> list = ParserCSV.creaListaPrevisioniByDate(id, strData);
        String[] columns = {"Data di rilevazione", "Centro", "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazione", "Altitudine Ghiacciai", "Massa Ghiacciai"};

        drawTable(getListaAggregata(list, strData), columns);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jCalendar = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaPrevisioni = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(177, 212, 224));

        jCalendar.setBackground(new java.awt.Color(177, 212, 224));
        jCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarPropertyChange(evt);
            }
        });

        tabellaPrevisioni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazione", "Altitudine ghiacciai", "Massa ghiacciai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabellaPrevisioni);

        jLabel3.setBackground(new java.awt.Color(177, 212, 224));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Previsioni disponibili nei primi 14 giorni");

        lblTitle.setBackground(new java.awt.Color(177, 212, 224));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Previsioni");

        btnBack.setBackground(new java.awt.Color(177, 212, 224));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setText("Indietro");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblTitle))
                    .addComponent(btnBack))
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarPropertyChange
        try {
            // TODO add your handling code here:
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String strData = sdf.format(jCalendar.getDate());
            ArrayList<JPrevisioni> list = ParserCSV.creaListaPrevisioniByDate(id, strData);
            String[] columns = {"Data di rilevazione", "Centro", "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazione", "Altitudine Ghiacciai", "Massa Ghiacciai"};

            drawTable(getListaAggregata(list, strData), columns);

        } catch (IOException ex) {
            Logger.getLogger(mostraPrevisioni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCalendarPropertyChange

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        if (idStazione > -1) {
            infoStazione info = new infoStazione(idStazione);
            info.setVisible(true);
            setVisible(false);
        } else if (idStazione == -1) {
            homepage homePage = new homepage();
            homePage.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(mostraPrevisioni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mostraPrevisioni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mostraPrevisioni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mostraPrevisioni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new mostraPrevisioni(id, idStazione).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(mostraPrevisioni.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup btnGroup;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tabellaPrevisioni;
    // End of variables declaration//GEN-END:variables

    private void drawTable(ArrayList<JPrevisioni> list, String[] columns) throws IOException {

        List<String[]> listaPrev = new ArrayList<>();
        for (JPrevisioni prev : list) {
            String[] elements = prev.toString().split(",");
            elements[1] = ParserCSV.getNomeStazioneByGeonameId(Integer.parseInt(elements[1]));
            listaPrev.add(elements);
        }

        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                model.addRow(listaPrev.get(i));
            }
        }
        tabellaPrevisioni.setModel((TableModel) model);

    }

    private ArrayList<JPrevisioni> getListaAggregata(ArrayList<JPrevisioni> list, String strData) {
        int listSize = list.size();

        if (listSize > 0) {
            int vento = 0, umidita = 0, pressione = 0, temperatura = 0, precipitazioni = 0, altitudineGhiacc = 0, massaGhiacc = 0, id_centro = 0;

            JPrevisioni prev = new JPrevisioni();
            for (JPrevisioni previsione : list) {
                vento += previsione.getvVento();
                umidita += previsione.getpUmidita();
                pressione += previsione.getPressione();
                temperatura += previsione.getTemperatura();
                precipitazioni += previsione.getPrecipitazioni();
                altitudineGhiacc += previsione.getaGhiacciai();
                massaGhiacc += previsione.getmGhiacciai();
                id_centro = previsione.getId_centro();
            }

            vento /= listSize;
            umidita /= listSize;
            pressione /= listSize;
            temperatura /= listSize;
            precipitazioni /= listSize;
            altitudineGhiacc /= listSize;
            massaGhiacc /= listSize;

            list.clear();
            list.add(
                    new JPrevisioni(
                            strData,
                            id_centro,
                            id,
                            "",
                            vento,
                            umidita,
                            pressione,
                            temperatura,
                            precipitazioni,
                            altitudineGhiacc,
                            massaGhiacc)
            );
        }
        return list;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        setVisible(true);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
