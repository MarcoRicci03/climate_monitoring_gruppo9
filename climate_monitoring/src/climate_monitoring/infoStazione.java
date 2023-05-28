/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package climate_monitoring;

import classi.JAreaInteresse;
import classi.JLuogo;
import classi.JPrevisioni;
import classi.ParserCSV;
import static classi.ParserCSV.getAreeInteresse;
import static classi.ParserCSV.creaListaStazioni;
import static classi.ParserCSV.getStazione;
import static climate_monitoring.mostraPrevisioni.id;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author marco
 */
public class infoStazione extends javax.swing.JFrame {

    /**
     * Creates new form infoStazione
     */
    public infoStazione(int id) {
        try {
            initComponents();
            ArrayList<JAreaInteresse> listaAree = getAreeInteresse(id);
            JLuogo stazione = getStazione(id);
            lblStazione.setText(stazione.getNome());
            txtGeoname.setText(stazione.getGeoname_id().toString());
            txtCodiceNazione.setText(stazione.getCountry_code());
            txtNazione.setText(stazione.getNazione());
            txtCoordinate.setText(stazione.getCoordinate().getLon().toString() + ", " + stazione.getCoordinate().getLat().toString());
            ArrayList<String[]> listInfo = new ArrayList<String[]>();
            
            String[] columns = {"Id area", "Area d'interesse"};
            drawTable(listaAree, columns, stazione);
            
        } catch (IOException ex) {
            Logger.getLogger(infoStazione.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        InfoTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        lblStazione = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtGeoname = new javax.swing.JTextField();
        txtCodiceNazione = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNazione = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCoordinate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        InfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        InfoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InfoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(InfoTable);

        btnBack.setText("Indietro");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblStazione.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        lblStazione.setText("jLabel1");

        jLabel1.setText("Geoname_id:");

        txtGeoname.setEditable(false);

        txtCodiceNazione.setEditable(false);

        jLabel2.setText("Codice nazione:");

        jLabel3.setText("Nazione:");

        txtNazione.setEditable(false);

        jLabel4.setText("Coordinate:");

        txtCoordinate.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lblStazione))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCoordinate, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtNazione)
                            .addComponent(txtCodiceNazione)
                            .addComponent(txtGeoname))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStazione)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGeoname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodiceNazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        homepage homePage = new homepage();
        homePage.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void InfoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InfoTableMouseClicked
        // TODO add your handling code here:
        int id = Integer.parseInt(InfoTable.getModel().getValueAt(InfoTable.getSelectedRow(), 1).toString());
        
        try {
            mostraPrevisioni mpFinestra = new mostraPrevisioni(id);
            mpFinestra.setVisible(true);
            setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_InfoTableMouseClicked

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
            java.util.logging.Logger.getLogger(infoStazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(infoStazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(infoStazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(infoStazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new infoStazione(id).setVisible(true);
            }
        });
    }
    
    private void drawTable(ArrayList<JAreaInteresse> list, String[] columns, JLuogo l) throws IOException {
        
        List<String[]> listAree = new ArrayList<>();
        Vector v = new Vector();
        
        for (JAreaInteresse ai : list) {
            String toParse = ai.toStringInfoStazione();
            String[] elements = toParse.split(",");
            listAree.add(elements);
        }
        
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        
        if (!listAree.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                model.addRow(listAree.get(i));
            }
        }
        
        InfoTable.setModel(
                (TableModel) model);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InfoTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStazione;
    private javax.swing.JTextField txtCodiceNazione;
    private javax.swing.JTextField txtCoordinate;
    private javax.swing.JTextField txtGeoname;
    private javax.swing.JTextField txtNazione;
    // End of variables declaration//GEN-END:variables

}
