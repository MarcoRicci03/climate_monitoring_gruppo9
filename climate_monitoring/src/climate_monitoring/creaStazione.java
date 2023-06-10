/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package climate_monitoring;

import classi.JCoordinate;
import classi.JLuogo;
import classi.ParserCSV;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.css.CSSValue;

/**
 * Classe che crea e gestisce la finestra creaStazione, da cui si può aggiungere
 * una nuovo centro metereologico nella lista di quelli già presenti
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class creaStazione extends javax.swing.JFrame {

    private ArrayList<String[]> ar;

    /**
     * Crea la pagina "creaStazione" mettendo la finestra al centro dello
     * schermo e inserendo il combobox con tutte le nazioni inserite nel file
     * apposito.
     */
    public creaStazione() {
        try {
            initComponents();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            int x = (screenSize.width - this.getWidth()) / 2;
            int y = (screenSize.height - this.getHeight()) / 2;
            this.setLocation(x, y);
            ar = ParserCSV.getNazioni();
            for (String[] s : ar) {
                cmbCodNazione.addItem(s[1]);
            }
        } catch (IOException ex) {
            Logger.getLogger(creaStazione.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCercaGeonameId = new javax.swing.JButton();
        txtGeoname_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCitta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodNazione = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAggiungi = new javax.swing.JButton();
        txtCoordinate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbCodNazione = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Geoname_id: ");

        btnCercaGeonameId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search.png"))); // NOI18N
        btnCercaGeonameId.setText("Cerca qui");
        btnCercaGeonameId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaGeonameIdActionPerformed(evt);
            }
        });

        jLabel2.setText("Città:");

        jLabel3.setText("Codice nazione:");

        txtCodNazione.setEditable(false);

        jLabel4.setText("Nazione:");

        btnAggiungi.setText("Aggiungi");
        btnAggiungi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiActionPerformed(evt);
            }
        });

        jLabel5.setText("Coordinate:");

        cmbCodNazione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));
        cmbCodNazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCodNazioneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAggiungi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtGeoname_id, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCercaGeonameId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCitta)
                            .addComponent(txtCoordinate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbCodNazione, javax.swing.GroupLayout.Alignment.TRAILING, 0, 267, Short.MAX_VALUE)
                            .addComponent(txtCodNazione, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCercaGeonameId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGeoname_id, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCitta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodNazione, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCodNazione, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCoordinate, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAggiungi, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Quando viene premuto il pulsante "Cerca qui" si viene rimandati al link
     * "https://www.geonames.org/" in modo da poter cercare la cittá della
     * stazione metereologica, con le relative coordinate e geoname_id.
     */
    private void btnCercaGeonameIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaGeonameIdActionPerformed
        try {
            // TODO add your handling code here:
            Desktop.getDesktop().browse(new URI("https://www.geonames.org/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(creaStazione.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(creaStazione.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCercaGeonameIdActionPerformed

    /**
     * Quando tutti i dati sono stati inseriti e viene premuto il pulsante
     * "Aggiungi" viene appunto aggiunta al file la nuova stazione
     * metereologica.
     */
    private void btnAggiungiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiungiActionPerformed
        // TODO add your handling code here:
        if (!txtGeoname_id.getText().isBlank() && !txtCitta.getText().isBlank() && !txtCodNazione.getText().isBlank() && cmbCodNazione.getSelectedIndex() > 0 && txtCoordinate.getText().isBlank()) {
            JLuogo l = new JLuogo(Integer.parseInt(txtGeoname_id.getText()), txtCitta.getText(), txtCodNazione.getText(), ar.get(cmbCodNazione.getSelectedIndex() - 1)[0], new JCoordinate(Float.parseFloat(txtCoordinate.getText().split(",")[0]), Float.parseFloat(txtCoordinate.getText().split(",")[1])));
            ParserCSV.creaStazione(txtGeoname_id.getText(), txtCitta.getText(), txtCodNazione.getText(), ar.get(cmbCodNazione.getSelectedIndex() - 1)[0], txtCoordinate.getText());
            registrazione.luogoNuovo = l;
        }

    }//GEN-LAST:event_btnAggiungiActionPerformed

    /**
     * Quando viene selezionata una nazione dal combobox viene scritto il codice
     * nazione nella casella di testo apposita.
     */
    private void cmbCodNazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCodNazioneActionPerformed
        // TODO add your handling code here:
        if (cmbCodNazione.getSelectedIndex() > 0) {
            txtCodNazione.setText(ar.get(cmbCodNazione.getSelectedIndex() - 1)[0]);
        }
    }//GEN-LAST:event_cmbCodNazioneActionPerformed

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
            java.util.logging.Logger.getLogger(creaStazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(creaStazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(creaStazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(creaStazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new creaStazione().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAggiungi;
    private javax.swing.JButton btnCercaGeonameId;
    private javax.swing.JComboBox<String> cmbCodNazione;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCitta;
    private javax.swing.JTextField txtCodNazione;
    private javax.swing.JTextField txtCoordinate;
    private javax.swing.JTextField txtGeoname_id;
    // End of variables declaration//GEN-END:variables
}
