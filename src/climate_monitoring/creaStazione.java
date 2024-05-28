/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package climate_monitoring;

import classi.*;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

    private ArrayList<JNazione> arrayNazioni;
    private DatiCondivisi dc;
    private String[] columns = {"Geoname id", "Città", "Codice Naz.", "Nazione", "Latitudine", "Longitudine"};
    List<String[]> listStazioni;

    /**
     * Crea la pagina "creaStazione" mettendo la finestra al centro dello
     * schermo e inserendo il combobox con tutte le nazioni inserite nel file
     * apposito.
     */
    public creaStazione() {
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        StazioneTable = new JTable(model);

        this.dc = DatiCondivisi.getInstance();
        initComponents();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
        try {
            dc.nazioni = dc.gestore_db.loadNazioni();
            arrayNazioni = dc.nazioni;
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        for (JNazione nazione : arrayNazioni) {
            cmbCodNazione.addItem(nazione.getNome_nazione());
        }
        StazioneTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
        jScrollPane2 = new javax.swing.JScrollPane();
        StazioneTable = new javax.swing.JTable();

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
        txtCitta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCittaKeyReleased(evt);
            }
        });

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
        cmbCodNazione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"-----"}));
        cmbCodNazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCodNazioneActionPerformed(evt);
            }
        });

        StazioneTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null}
                },
                new String[]{"Geoname id", "Città", "Codice Naz.", "Nazione", "Latitudine", "Longitudine"}
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        StazioneTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StazioneTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(StazioneTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addComponent(btnAggiungi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(labelCodiceNazione, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                                        .addComponent(labelId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(labelNazione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(labelCordinate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(24, 24, 24)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtCoordinate)
                                                        .addComponent(txtCodNazione)
                                                        .addComponent(txtGeoname_id)
                                                        .addComponent(cmbCodNazione, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(labelCitta, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                                .addComponent(txtCitta, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCercaGeonameId, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCercaGeonameId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCitta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelCitta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtGeoname_id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtCodNazione, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelCodiceNazione, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbCodNazione)
                                        .addComponent(labelNazione, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelCordinate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 583, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 465, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
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
        if (JCoordinate.sonoCoordinate(txtCoordinate.getText())) {
            try {
                if (!txtCoordinate.getText().isBlank() && !txtGeoname_id.getText().isBlank() && !txtCitta.getText().isBlank() && !txtCodNazione.getText().isBlank() && cmbCodNazione.getSelectedIndex() > 0) {
                    JStazione l = new JStazione(Integer.parseInt(txtGeoname_id.getText()), txtCitta.getText(), txtCodNazione.getText(), arrayNazioni.get(cmbCodNazione.getSelectedIndex() - 1).getNome_nazione(), new JCoordinate(Float.parseFloat(txtCoordinate.getText().split(",")[0]), Float.parseFloat(txtCoordinate.getText().split(",")[1])));
                    if (dc.gestore_db.AddStazione(txtGeoname_id.getText(), txtCitta.getText(), txtCodNazione.getText(), new JCoordinate(txtCoordinate.getText()))) {
                        registrazione.luogoNuovo = l;
                        JOptionPane.showMessageDialog(null, "Stazione: " + txtCitta.getText() + " aggiunta", "Info", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "La stazione " + txtCitta.getText() + ", con Geoname_id:" + txtGeoname_id.getText() + " è gia stata creata", "Errore", JOptionPane.INFORMATION_MESSAGE);
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
        if (cmbCodNazione.getSelectedIndex() > 0) {
            txtCodNazione.setText(arrayNazioni.get(cmbCodNazione.getSelectedIndex() - 1).getCountry_code());
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

    private void txtCittaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCittaKeyReleased
        if (txtCitta.getText().matches(".*[a-zA-Z0-9].*")) {
            //se è stato inserito un carattere o un numero allora fai la chiamata al servizio web per i suggeriment
            String testo = txtCitta.getText().toLowerCase();
            if (!testo.isEmpty()) {
                new Thread(() -> {
                    synchronized (this) {
                        try {
                            ArrayList<JStazione> arraySuggerimenti = dc.gestore_db.getStationGeonameIdfromWS(testo);
                            if (arraySuggerimenti.size() > 0) {
                                drawTable(arraySuggerimenti);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();
            }
        }
    }//GEN-LAST:event_txtCittaKeyReleased

    private synchronized void drawTable(ArrayList<JStazione> arraySuggerimenti) {
        listStazioni = new ArrayList<>();
        Vector v = new Vector();

        for (JStazione stazione : arraySuggerimenti) {
            String toParse = stazione.toStringCsv();
            String[] elements = toParse.split(",");
            listStazioni.add(elements);
        }

        DefaultTableModel model = (DefaultTableModel) StazioneTable.getModel();
        model.setRowCount(0);
        if (!listStazioni.isEmpty()) {
            for (int i = 0; i < arraySuggerimenti.size(); i++) {
                model.addRow(listStazioni.get(i));
            }
        }
        StazioneTable.setModel(model);
    }

    private void StazioneTableMouseClicked(java.awt.event.MouseEvent evt) {
        if (StazioneTable.getModel().getRowCount() > 0) {
            if (StazioneTable.getSelectedColumn() >= 0) {
                txtGeoname_id.setText(listStazioni.get(StazioneTable.getSelectedRow())[0]);
                txtCitta.setText(listStazioni.get(StazioneTable.getSelectedRow())[1]);
                txtCodNazione.setText(listStazioni.get(StazioneTable.getSelectedRow())[2]);
                cmbCodNazione.getModel().setSelectedItem(listStazioni.get(StazioneTable.getSelectedRow())[3]);
                String lat = listStazioni.get(StazioneTable.getSelectedRow())[4];
                String lon = listStazioni.get(StazioneTable.getSelectedRow())[5];
                txtCoordinate.setText(lat + ", " + lon);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StazioneTable;
    private javax.swing.JButton btnAggiungi;
    private javax.swing.JButton btnCercaGeonameId;
    private javax.swing.JComboBox<String> cmbCodNazione;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
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
