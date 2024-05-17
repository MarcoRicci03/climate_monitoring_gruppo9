/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package climate_monitoring;

import classi.JCoordinate;
import classi.JLuogo;
import classi.ParserCSV;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

        jPanel1 = new javax.swing.JPanel();
        labelId = new javax.swing.JLabel();
        btnCercaGeonameId = new javax.swing.JButton();
        txtGeoname_id = new javax.swing.JTextField();
        labelCitta = new javax.swing.JLabel();
        txtCitta = new javax.swing.JTextField();
        labelCodiceNazione = new javax.swing.JLabel();
        txtCodNazione = new javax.swing.JTextField();
        labelNazione = new javax.swing.JLabel();
        btnAggiungi = new javax.swing.JButton();
        txtCoordinate = new javax.swing.JTextField();
        labelCordinate = new javax.swing.JLabel();
        cmbCodNazione = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(177, 212, 224));

        labelId.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelId.setText("Geoname_id: ");

        btnCercaGeonameId.setBackground(new java.awt.Color(177, 212, 224));
        btnCercaGeonameId.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCercaGeonameId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search2.png"))); // NOI18N
        btnCercaGeonameId.setText("Cerca qui");
        btnCercaGeonameId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaGeonameIdActionPerformed(evt);
            }
        });

        txtGeoname_id.setBackground(new java.awt.Color(177, 212, 224));
        txtGeoname_id.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        labelCitta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelCitta.setText("Città:");

        txtCitta.setBackground(new java.awt.Color(177, 212, 224));
        txtCitta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        labelCodiceNazione.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelCodiceNazione.setText("Codice nazione:");

        txtCodNazione.setEditable(false);
        txtCodNazione.setBackground(new java.awt.Color(177, 212, 224));
        txtCodNazione.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        labelNazione.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelNazione.setText("Nazione:");

        btnAggiungi.setBackground(new java.awt.Color(177, 212, 224));
        btnAggiungi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAggiungi.setText("Aggiungi");
        btnAggiungi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiActionPerformed(evt);
            }
        });

        txtCoordinate.setBackground(new java.awt.Color(177, 212, 224));
        txtCoordinate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtCoordinate.setForeground(new java.awt.Color(153, 153, 153));
        txtCoordinate.setText("Latitudine, Longitudine");
        txtCoordinate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCoordinateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCoordinateKeyReleased(evt);
            }
        });

        labelCordinate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelCordinate.setText("Coordinate:");

        cmbCodNazione.setBackground(new java.awt.Color(177, 212, 224));
        cmbCodNazione.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cmbCodNazione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));
        cmbCodNazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCodNazioneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAggiungi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelCodiceNazione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelCordinate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelNazione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(labelCitta, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtGeoname_id, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCercaGeonameId, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCoordinate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbCodNazione, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCitta, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCodNazione, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(labelId, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCercaGeonameId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGeoname_id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCitta, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(labelCitta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodNazione, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(labelCodiceNazione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCodNazione, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(labelNazione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCoordinate, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(labelCordinate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        if (JCoordinate.sonoCoordinate(txtCoordinate.getText())) {
            try {
                if (!txtCoordinate.getText().isBlank() && !txtGeoname_id.getText().isBlank() && !txtCitta.getText().isBlank() && !txtCodNazione.getText().isBlank() && cmbCodNazione.getSelectedIndex() > 0) {
                    JLuogo l = new JLuogo(Integer.parseInt(txtGeoname_id.getText()), txtCitta.getText(), txtCodNazione.getText(), ar.get(cmbCodNazione.getSelectedIndex() - 1)[0], new JCoordinate(Float.parseFloat(txtCoordinate.getText().split(",")[0]), Float.parseFloat(txtCoordinate.getText().split(",")[1])));
                    if (ParserCSV.creaStazione(txtGeoname_id.getText(), txtCitta.getText(), txtCodNazione.getText(), ar.get(cmbCodNazione.getSelectedIndex() - 1)[0], txtCoordinate.getText())) {
                        registrazione.luogoNuovo = l;
                        JOptionPane.showMessageDialog(null, "Stazione: " + txtCitta.getText() + " aggiunta", "Info", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "La stazione "+ txtCitta.getText() +", con Geoname_id:" + txtGeoname_id.getText() + " è gia stata creata", "Errore", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Compila tutti i valori.", "Errore", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Controllare di aver inserito correttamente il geoname_id e le coordinate. (latitudine, longitudine)", "Errore", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Coordinate non valide. (latitudine, longitudine)", "Errore", JOptionPane.INFORMATION_MESSAGE);
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
     * Quando premuto un tasto mentre si sta scrivendo nella casella testuale
     * delle coordinate viene richiamato questo metodo che permette di gestire
     * il watermark (filigrana).
     */
    private void txtCoordinateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCoordinateKeyPressed
        // TODO add your handling code here:
        if (txtCoordinate.getForeground() != Color.BLACK && txtCoordinate.getText().equals("Latitudine, Longitudine")) {
            txtCoordinate.setText("");
        }
        txtCoordinate.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtCoordinateKeyPressed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        txtCoordinate.setCaretPosition(0);
    }//GEN-LAST:event_formWindowGainedFocus

    /**
     * Quando rilasciato un tasto mentre si sta scrivendo nella casella testuale
     * delle coordinate viene richiamato questo metodo che permette di gestire
     * il watermark (filigrana).
     */
    private void txtCoordinateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCoordinateKeyReleased
        // TODO add your handling code here:
        if (txtCoordinate.getText().isEmpty()) {
            txtCoordinate.setText("Latitudine, Longitudine");
            txtCoordinate.setCaretPosition(0);
            txtCoordinate.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtCoordinateKeyReleased

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCitta;
    private javax.swing.JLabel labelCodiceNazione;
    private javax.swing.JLabel labelCordinate;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNazione;
    private javax.swing.JTextField txtCitta;
    private javax.swing.JTextField txtCodNazione;
    private javax.swing.JTextField txtCoordinate;
    private javax.swing.JTextField txtGeoname_id;
    // End of variables declaration//GEN-END:variables
}
