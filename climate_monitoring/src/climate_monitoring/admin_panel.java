/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package climate_monitoring;

import classi.JAreaInteresse;
import classi.JPrevisioni;
import classi.JUser;
import classi.ParserCSV;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Classe che crea e gestisce la finestra admin_panel riservata agli operatori
 * registrati da cui possono inserire una nuova stazione metereologica oppure
 * visionare ed aggiungere nuove previsioni
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class admin_panel extends javax.swing.JFrame {

    private static JUser user;
    private Vector v = new Vector();

    /**
     * Crea la pagina "pannello di controllo admin", inizializzando i valori
     * come la posizione della finestra, quale utente ha fatto l'accesso e
     * recupera tutte le aree d'interesse collegate alla stazione metereologica
     * riferita all'utente.
     *
     * @param userLoggato Oggetto che contiene l'utente che ha compiuto
     * l'accesso
     */
    public admin_panel(JUser userLoggato) {
        initComponents();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);

        user = userLoggato;

        ArrayList<JAreaInteresse> list = ParserCSV.getAreeInteresse(user.getGeoname_id());
        if (!list.isEmpty()) {
            for (JAreaInteresse a : list) {
                v.add(a.toStringList());
            }
            listAree.setListData(v);
        }
        datePickerData.setDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeArea = new javax.swing.JTextField();
        btnAggiungiArea = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAree = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        txtAreaSelezionata = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabellaPrevisioni = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdCentro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbVento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbUmidita = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbPressione = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbTemperatura = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbPrecipitazioni = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cmbGhiacciai = new javax.swing.JComboBox<>();
        cmbMassaGhiacciai = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnAggiungiPrevisioni = new javax.swing.JButton();
        datePickerData = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtAreaPrevisioneSelezionata = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Nome:");

        btnAggiungiArea.setText("Aggiungi");
        btnAggiungiArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAggiungiArea)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomeArea, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAggiungiArea)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        listAree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listAree);

        jLabel3.setText("Area selezionata:");

        txtAreaSelezionata.setEditable(false);

        jTabellaPrevisioni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data di rilevazione ", "Id centro", "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazione", "Altitudine Ghiacciai", "Massa Ghiacciai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTabellaPrevisioni);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAreaSelezionata, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtAreaSelezionata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Data di rilevazione:");

        jLabel6.setText("Id centro:");

        txtIdCentro.setEditable(false);

        jLabel7.setText("Vento:");

        cmbVento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel8.setText("Umidità:");

        cmbUmidita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel9.setText("Pressione:");

        cmbPressione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel10.setText("Temperatura:");

        cmbTemperatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel11.setText("Precipitazioni:");

        cmbPrecipitazioni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel12.setText("Altitudine Ghiacciai:");

        cmbGhiacciai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        cmbMassaGhiacciai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel13.setText("Massa dei ghiacciai:");

        btnAggiungiPrevisioni.setText("Aggiungi previsioni");
        btnAggiungiPrevisioni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiPrevisioniActionPerformed(evt);
            }
        });

        datePickerData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbPressione, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(datePickerData, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtIdCentro))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbVento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbUmidita, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbPrecipitazioni, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTemperatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGhiacciai, 0, 1, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMassaGhiacciai, 0, 49, Short.MAX_VALUE)
                        .addGap(134, 134, 134))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAggiungiPrevisioni)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(cmbMassaGhiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPrecipitazioni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbGhiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAggiungiPrevisioni, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7)
                                .addComponent(cmbVento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(datePickerData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtIdCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cmbUmidita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbPressione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Aggiungi previsione per ");

        jLabel1.setText("Aggiungi area d'interesse");

        txtAreaPrevisioneSelezionata.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAreaPrevisioneSelezionata, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAreaPrevisioneSelezionata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Questo metodo viene richiamato quando premuto il bottone "Aggiungi" nella
     * sezione per aggiungere una nuova area d'interesse, viene preso il nome
     * inserito, aggiunto al file e poi aggiunto alla lista.
     */
    private void btnAggiungiAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiungiAreaActionPerformed
        Integer id = ParserCSV.aggiungiAreaInteresse(user.getGeoname_id(), txtNomeArea.getText());
        String s = id + " " + txtNomeArea.getText();
        v.add(s);
        listAree.setListData(v);
    }//GEN-LAST:event_btnAggiungiAreaActionPerformed
    /**
     * Questo metodo viene richiamato quando selezionata un'area d'interesse
     * dalla lista, viene semplicemente richiamato il metodo per aggiornare la
     * tabella delle previsioni.
     */
    private void listAreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAreeMouseClicked
        aggiornaTabella();
    }//GEN-LAST:event_listAreeMouseClicked
    /**
     * Questo metodo viene richiamato quando premuto il bottone "Aggiungi
     * Previsione", vengono presi tutti i valori inseriti e salvati nelle
     * relative variabili per poi andare a creare l'oggetto JPrevisione ed
     * aggiungerlo al file delle previsioni, infine viene richiamata la funzione
     * "aggiornaTabella" per mostrare la nuova previsioni senza dover
     * aggiornarla manualmente.
     */
    private void btnAggiungiPrevisioniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiungiPrevisioniActionPerformed
        // TODO add your handling code here:
        if (!txtAreaSelezionata.getText().isEmpty()) {
            int valVento, valUmidita, valPressione, valTemperatura, valPrecipitazioni, valGhiacciai, valMassaGhiaccia;
            LocalDate ld = datePickerData.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String txtData = ld.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int id = Integer.parseInt(txtIdCentro.getText());
            valVento = Integer.parseInt(cmbVento.getItemAt(cmbVento.getSelectedIndex()));
            valUmidita = Integer.parseInt(cmbUmidita.getItemAt(cmbUmidita.getSelectedIndex()));
            valPressione = Integer.parseInt(cmbPressione.getItemAt(cmbPressione.getSelectedIndex()));
            valTemperatura = Integer.parseInt(cmbTemperatura.getItemAt(cmbTemperatura.getSelectedIndex()));
            valPrecipitazioni = Integer.parseInt(cmbPrecipitazioni.getItemAt(cmbPrecipitazioni.getSelectedIndex()));
            valGhiacciai = Integer.parseInt(cmbGhiacciai.getItemAt(cmbGhiacciai.getSelectedIndex()));
            valMassaGhiaccia = Integer.parseInt(cmbMassaGhiacciai.getItemAt(cmbMassaGhiacciai.getSelectedIndex()));
            JPrevisioni previsione = new JPrevisioni(txtData, id, user.getId_areaSelezionata(), user.getUsername(), valVento, valUmidita, valPressione, valTemperatura, valPrecipitazioni, valGhiacciai, valMassaGhiaccia);
            ParserCSV.aggiungiPrevisione(previsione);
            aggiornaTabella();
        } else {
            JOptionPane.showMessageDialog(null, "Seleziona un'area d'interesse.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAggiungiPrevisioniActionPerformed
    /**
     * Tramite questo metodo andiamo ad aggiornare la tabella delle previsioni
     * in base all'area d'interesse selezionata.
     */
    void aggiornaTabella() {
        try {
            // TODO add your handling code here:
            String[] data = listAree.getSelectedValue().split(" ", 2);
            int idAreaInteresse = Integer.parseInt(data[0]);
            user.setId_areaSelezionata(idAreaInteresse);
            txtAreaSelezionata.setText(data[1]);
            txtAreaPrevisioneSelezionata.setText(data[1]);
            txtIdCentro.setText(String.valueOf(user.getGeoname_id()));

            ArrayList<JPrevisioni> list = ParserCSV.creaListaPrevisioni(idAreaInteresse);

            List<String[]> listaPrev = new ArrayList<>();
            for (JPrevisioni prev : list) {
                String[] elements = prev.toString().split(",");
                listaPrev.add(elements);
            }

            DefaultTableModel model = new DefaultTableModel(new String[]{"Data di rilevazione", "Id centro", "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazione", "Altitudine Ghiacciai", "Massa Ghiacciai"
            }, 0) {
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
            jTabellaPrevisioni.setModel((TableModel) model);
        } catch (IOException ex) {
            Logger.getLogger(admin_panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(admin_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_panel(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAggiungiArea;
    private javax.swing.JButton btnAggiungiPrevisioni;
    private javax.swing.JComboBox<String> cmbGhiacciai;
    private javax.swing.JComboBox<String> cmbMassaGhiacciai;
    private javax.swing.JComboBox<String> cmbPrecipitazioni;
    private javax.swing.JComboBox<String> cmbPressione;
    private javax.swing.JComboBox<String> cmbTemperatura;
    private javax.swing.JComboBox<String> cmbUmidita;
    private javax.swing.JComboBox<String> cmbVento;
    private com.toedter.calendar.JDateChooser datePickerData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabellaPrevisioni;
    private javax.swing.JList<String> listAree;
    private javax.swing.JTextField txtAreaPrevisioneSelezionata;
    private javax.swing.JTextField txtAreaSelezionata;
    private javax.swing.JTextField txtIdCentro;
    private javax.swing.JTextField txtNomeArea;
    // End of variables declaration//GEN-END:variables
}
