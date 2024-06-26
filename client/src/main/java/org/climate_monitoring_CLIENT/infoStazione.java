/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.climate_monitoring_CLIENT;

import classi.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Classe che crea e gestisce la finestra infoStazione visibile da tutti,
 * permette di visualizzare le informazioni di una stazione metereologica.
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class infoStazione extends javax.swing.JFrame implements WindowListener {

    /**
     * Codice identificativo della stazione selezionata nella home_page.
     */
    private static String id;

    /**
     * La finestra precedente che ha aperto questa finestra.
     */
    private Object prevPage;

    /**
     * Crea una nuova pagina infoStazione
     *
     * @param id       codice identificativo della stazione selezionata nella home_page.
     * @param prevPage la finestra precedente che ha aperto questa finestra.
     */
    public infoStazione(String id, Object prevPage) {
        this.id = id;
        this.prevPage = prevPage;
        try {
            initComponents();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            int x = (screenSize.width - this.getWidth()) / 2;
            int y = (screenSize.height - this.getHeight()) / 2;
            this.setLocation(x, y);
            ArrayList<JAreaInteresse> listaAree = null;
            JStazione stazione = null;
            try {
                listaAree = DatiCondivisi.getInstance().gestore_db.loadAree_interesse(null, null, -1, id, -1);
                stazione = DatiCondivisi.getInstance().gestore_db.loadStazioni(id, null, null, -1).get(0);
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Server non raggiungibile", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            lblStazione.setText(stazione.getNome());
            txtGeoname.setText(stazione.getGeoname_id().toString());
            txtCodiceNazione.setText(stazione.getCountry_code());
            txtNazione.setText(stazione.getNazione());
            txtCoordinate.setText(stazione.getCoordinate().getLat().toString() + ", " + stazione.getCoordinate().getLon().toString());
            String[] columns = {"Id area", "Area d'interesse"};
            drawTable(listaAree, columns);
        } catch (IOException ex) {
            Logger.getLogger(infoStazione.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Questo metodo viene chiamato all'interno del costruttore per inizializzare il modulo.
     * ATTENZIONE: non modificare questo codice. Il contenuto di questo metodo è sempre
     * rigenerato dall'Editor di Form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(177, 212, 224));

        InfoTable.setBackground(new java.awt.Color(177, 212, 224));
        InfoTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        InfoTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String[]{
                        "Title 1", "Title 2"
                }
        ));
        InfoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InfoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(InfoTable);

        btnBack.setBackground(new java.awt.Color(177, 212, 224));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setText("Indietro");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblStazione.setBackground(new java.awt.Color(177, 212, 224));
        lblStazione.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        lblStazione.setText("jLabel1");

        jLabel1.setBackground(new java.awt.Color(177, 212, 224));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Geoname_id:");

        txtGeoname.setEditable(false);
        txtGeoname.setBackground(new java.awt.Color(177, 212, 224));
        txtGeoname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtCodiceNazione.setEditable(false);
        txtCodiceNazione.setBackground(new java.awt.Color(177, 212, 224));
        txtCodiceNazione.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(177, 212, 224));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Codice nazione:");

        jLabel3.setBackground(new java.awt.Color(177, 212, 224));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nazione:");

        txtNazione.setEditable(false);
        txtNazione.setBackground(new java.awt.Color(177, 212, 224));
        txtNazione.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel4.setBackground(new java.awt.Color(177, 212, 224));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Coordinate:");

        txtCoordinate.setEditable(false);
        txtCoordinate.setBackground(new java.awt.Color(177, 212, 224));
        txtCoordinate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblStazione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnBack)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel4))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtGeoname)
                                                                        .addComponent(txtCodiceNazione)
                                                                        .addComponent(txtNazione)
                                                                        .addComponent(txtCoordinate))))
                                                .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblStazione)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtGeoname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCodiceNazione, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNazione, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCoordinate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 549, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 409, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Questo metodo viene richiamato quando premuto il pulsante Indietro e
     * permette appunto di tornare alla schermata precedente.
     *
     * @param evt l'evento generato dal clic sul pulsante.
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (prevPage instanceof homepage) {
            ((homepage) prevPage).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Quanto viene cliccata una riga sulla tabella viene richiamato questo
     * metodo che apre una nuova finestra con le previsioni per l'area selezionata.
     *
     * @param evt l'evento generato dal clic sulla tabella.
     */
    private void InfoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InfoTableMouseClicked
        int idArea = Integer.parseInt(InfoTable.getModel().getValueAt(InfoTable.getSelectedRow(), 0).toString());
        mostraPrevisioni mpFinestra = new mostraPrevisioni(idArea, id, true, this);
        mpFinestra.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_InfoTableMouseClicked

    /**
     * Azione eseguita quando la finestra viene chiusa.
     * Se la pagina precedente è un'istanza della classe homepage, la rende visibile.
     *
     * @param evt l'evento di chiusura della finestra.
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (prevPage instanceof homepage) {
            ((homepage) prevPage).setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * Il metodo drawTable permette di creare e riempire la tabella con i dati
     * passati per parametro.
     *
     * @param list    Lista con tutti i dati da inserire.
     * @param columns Intestazioni delle colonne.
     * @throws IOException se si verifica un errore di input/output.
     */
    private void drawTable(ArrayList<JAreaInteresse> list, String[] columns) throws IOException {
        List<String[]> listAree = new ArrayList<>();
        for (JAreaInteresse ai : list) {
            String[] elements = ai.toStringInfoStazione().split(",");
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStazione;
    private javax.swing.JTextField txtCodiceNazione;
    private javax.swing.JTextField txtCoordinate;
    private javax.swing.JTextField txtGeoname;
    private javax.swing.JTextField txtNazione;
    // End of variables declaration//GEN-END:variables

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
