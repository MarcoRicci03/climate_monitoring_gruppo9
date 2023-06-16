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
    private List<String[]> listaPrev;

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

        AreaInteresse = new javax.swing.JPanel();
        labelAreaInteresse = new javax.swing.JLabel();
        txtNomeArea = new javax.swing.JTextField();
        btnAggiungiArea = new javax.swing.JButton();
        labelIntestazioneIAreaInteresse = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAree = new javax.swing.JList<>();
        labelAreaSelezionata = new javax.swing.JLabel();
        txtAreaSelezionata = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabellaPrevisioni = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaNoteLettura = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        AreaParametri = new javax.swing.JPanel();
        labelData = new javax.swing.JLabel();
        labelIdCentro = new javax.swing.JLabel();
        txtIdCentro = new javax.swing.JTextField();
        labelVento = new javax.swing.JLabel();
        cmbVento = new javax.swing.JComboBox<>();
        labelUmidita = new javax.swing.JLabel();
        cmbUmidita = new javax.swing.JComboBox<>();
        labelPressione = new javax.swing.JLabel();
        cmbPressione = new javax.swing.JComboBox<>();
        labelTemperatura = new javax.swing.JLabel();
        cmbTemperatura = new javax.swing.JComboBox<>();
        labelPrecipitazioni = new javax.swing.JLabel();
        cmbPrecipitazioni = new javax.swing.JComboBox<>();
        labelAltitudine = new javax.swing.JLabel();
        cmbGhiacciai = new javax.swing.JComboBox<>();
        cmbMassaGhiacciai = new javax.swing.JComboBox<>();
        labelMassa = new javax.swing.JLabel();
        btnAggiungiPrevisioni = new javax.swing.JButton();
        datePickerData = new com.toedter.calendar.JDateChooser();
        labelAreaPrevisioneSelezionata = new javax.swing.JLabel();
        txtAreaPrevisioneSelezionata = new javax.swing.JTextField();
        noteVento = new javax.swing.JTextField();
        noteUmidita = new javax.swing.JTextField();
        noteMGhiacciai = new javax.swing.JTextField();
        noteTemperatura = new javax.swing.JTextField();
        notePressione = new javax.swing.JTextField();
        notePrecipitazioni = new javax.swing.JTextField();
        noteAGhiacciai = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        AreaInteresse.setBackground(new java.awt.Color(177, 212, 224));
        AreaInteresse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelAreaInteresse.setBackground(new java.awt.Color(177, 212, 224));
        labelAreaInteresse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAreaInteresse.setText("Nome:");

        txtNomeArea.setBackground(new java.awt.Color(177, 212, 224));
        txtNomeArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnAggiungiArea.setBackground(new java.awt.Color(177, 212, 224));
        btnAggiungiArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAggiungiArea.setText("Aggiungi");
        btnAggiungiArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiAreaActionPerformed(evt);
            }
        });

        labelIntestazioneIAreaInteresse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelIntestazioneIAreaInteresse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIntestazioneIAreaInteresse.setText("Aggiungi area d'interesse");

        javax.swing.GroupLayout AreaInteresseLayout = new javax.swing.GroupLayout(AreaInteresse);
        AreaInteresse.setLayout(AreaInteresseLayout);
        AreaInteresseLayout.setHorizontalGroup(
            AreaInteresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AreaInteresseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AreaInteresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAggiungiArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelIntestazioneIAreaInteresse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AreaInteresseLayout.createSequentialGroup()
                        .addComponent(labelAreaInteresse, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeArea, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AreaInteresseLayout.setVerticalGroup(
            AreaInteresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AreaInteresseLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(labelIntestazioneIAreaInteresse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AreaInteresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeArea, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAreaInteresse, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAggiungiArea, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(177, 212, 224));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        listAree.setBackground(new java.awt.Color(177, 212, 224));
        listAree.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        listAree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listAree);

        labelAreaSelezionata.setBackground(new java.awt.Color(177, 212, 224));
        labelAreaSelezionata.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAreaSelezionata.setText("Area selezionata:");

        txtAreaSelezionata.setEditable(false);
        txtAreaSelezionata.setBackground(new java.awt.Color(177, 212, 224));
        txtAreaSelezionata.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

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
        jTabellaPrevisioni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabellaPrevisioniMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabellaPrevisioni);

        txtAreaNoteLettura.setColumns(20);
        txtAreaNoteLettura.setRows(5);
        jScrollPane3.setViewportView(txtAreaNoteLettura);

        jLabel2.setText("Note");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1378, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelAreaSelezionata)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAreaSelezionata, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelAreaSelezionata)
                            .addComponent(txtAreaSelezionata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        AreaParametri.setBackground(new java.awt.Color(177, 212, 224));
        AreaParametri.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelData.setBackground(new java.awt.Color(177, 212, 224));
        labelData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelData.setText("Data di rilevazione:");

        labelIdCentro.setBackground(new java.awt.Color(177, 212, 224));
        labelIdCentro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelIdCentro.setText("Id centro:");

        txtIdCentro.setEditable(false);
        txtIdCentro.setBackground(new java.awt.Color(177, 212, 224));
        txtIdCentro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        labelVento.setBackground(new java.awt.Color(177, 212, 224));
        labelVento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelVento.setText("Vento:");

        cmbVento.setBackground(new java.awt.Color(177, 212, 224));
        cmbVento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbVento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        labelUmidita.setBackground(new java.awt.Color(177, 212, 224));
        labelUmidita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelUmidita.setText("Umidità:");

        cmbUmidita.setBackground(new java.awt.Color(177, 212, 224));
        cmbUmidita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbUmidita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        labelPressione.setBackground(new java.awt.Color(177, 212, 224));
        labelPressione.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPressione.setText("Pressione:");

        cmbPressione.setBackground(new java.awt.Color(177, 212, 224));
        cmbPressione.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbPressione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        labelTemperatura.setBackground(new java.awt.Color(177, 212, 224));
        labelTemperatura.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTemperatura.setText("Temperatura:");

        cmbTemperatura.setBackground(new java.awt.Color(177, 212, 224));
        cmbTemperatura.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbTemperatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        labelPrecipitazioni.setBackground(new java.awt.Color(177, 212, 224));
        labelPrecipitazioni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPrecipitazioni.setText("Precipitazioni:");

        cmbPrecipitazioni.setBackground(new java.awt.Color(177, 212, 224));
        cmbPrecipitazioni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbPrecipitazioni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        labelAltitudine.setBackground(new java.awt.Color(177, 212, 224));
        labelAltitudine.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAltitudine.setText("Altitudine Ghiacciai:");

        cmbGhiacciai.setBackground(new java.awt.Color(177, 212, 224));
        cmbGhiacciai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbGhiacciai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        cmbMassaGhiacciai.setBackground(new java.awt.Color(177, 212, 224));
        cmbMassaGhiacciai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbMassaGhiacciai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        labelMassa.setBackground(new java.awt.Color(177, 212, 224));
        labelMassa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelMassa.setText("Massa dei ghiacciai:");

        btnAggiungiPrevisioni.setBackground(new java.awt.Color(177, 212, 224));
        btnAggiungiPrevisioni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAggiungiPrevisioni.setText("Aggiungi previsioni");
        btnAggiungiPrevisioni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiPrevisioniActionPerformed(evt);
            }
        });

        datePickerData.setBackground(new java.awt.Color(177, 212, 224));
        datePickerData.setDateFormatString("dd/MM/yyyy");

        labelAreaPrevisioneSelezionata.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAreaPrevisioneSelezionata.setText("Aggiungi previsione per ");

        txtAreaPrevisioneSelezionata.setEditable(false);
        txtAreaPrevisioneSelezionata.setBackground(new java.awt.Color(177, 212, 224));
        txtAreaPrevisioneSelezionata.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout AreaParametriLayout = new javax.swing.GroupLayout(AreaParametri);
        AreaParametri.setLayout(AreaParametriLayout);
        AreaParametriLayout.setHorizontalGroup(
            AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AreaParametriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AreaParametriLayout.createSequentialGroup()
                        .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAltitudine)
                            .addComponent(labelPrecipitazioni)
                            .addComponent(labelMassa)
                            .addComponent(labelTemperatura))
                        .addGap(38, 38, 38)
                        .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AreaParametriLayout.createSequentialGroup()
                                .addComponent(cmbGhiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noteAGhiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AreaParametriLayout.createSequentialGroup()
                                .addComponent(cmbMassaGhiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noteMGhiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AreaParametriLayout.createSequentialGroup()
                                .addComponent(cmbPrecipitazioni, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(notePrecipitazioni, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AreaParametriLayout.createSequentialGroup()
                                .addComponent(cmbTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noteTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnAggiungiPrevisioni, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(AreaParametriLayout.createSequentialGroup()
                        .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelVento)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AreaParametriLayout.createSequentialGroup()
                                        .addComponent(labelUmidita)
                                        .addGap(114, 114, 114)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AreaParametriLayout.createSequentialGroup()
                                    .addComponent(labelPressione)
                                    .addGap(103, 103, 103)))
                            .addGroup(AreaParametriLayout.createSequentialGroup()
                                .addComponent(labelAreaPrevisioneSelezionata)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AreaParametriLayout.createSequentialGroup()
                                .addComponent(cmbUmidita, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noteUmidita, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AreaParametriLayout.createSequentialGroup()
                                .addComponent(cmbPressione, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(notePressione, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AreaParametriLayout.createSequentialGroup()
                                .addComponent(txtAreaPrevisioneSelezionata, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(labelIdCentro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datePickerData, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AreaParametriLayout.createSequentialGroup()
                                .addComponent(cmbVento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noteVento, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AreaParametriLayout.setVerticalGroup(
            AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AreaParametriLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelAreaPrevisioneSelezionata)
                        .addComponent(txtAreaPrevisioneSelezionata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelIdCentro)
                        .addComponent(txtIdCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelData)
                    .addComponent(datePickerData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVento)
                    .addComponent(cmbVento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noteVento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUmidita)
                    .addComponent(cmbUmidita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noteUmidita, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AreaParametriLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPressione)
                            .addComponent(cmbPressione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notePressione, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noteTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTemperatura)))
                    .addGroup(AreaParametriLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnAggiungiPrevisioni, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPrecipitazioni)
                    .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbPrecipitazioni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(notePrecipitazioni, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAltitudine)
                    .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbGhiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(noteAGhiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMassa)
                    .addComponent(cmbMassaGhiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noteMGhiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AreaInteresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AreaParametri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AreaParametri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AreaInteresse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            String nVento = noteVento.getText();
            String nUmidita = noteUmidita.getText();
            String nPressione = notePressione.getText();
            String nTemperatura = noteTemperatura.getText();
            String nPrecipitazioni = notePrecipitazioni.getText();
            String nAGhiacciai = noteAGhiacciai.getText();
            String nMGhiacciai = noteMGhiacciai.getText();

            JPrevisioni previsione = new JPrevisioni(txtData, id, user.getId_areaSelezionata(), user.getUsername(), 
                                                     valVento, valUmidita, valPressione, valTemperatura, valPrecipitazioni, valGhiacciai, valMassaGhiaccia, 
                                                     nVento,nUmidita, nPressione, nTemperatura, nPrecipitazioni, nAGhiacciai, nMGhiacciai);
            ParserCSV.aggiungiPrevisione(previsione);
            aggiornaTabella();
        } else {
            JOptionPane.showMessageDialog(null, "Seleziona un'area d'interesse.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAggiungiPrevisioniActionPerformed

    private void jTabellaPrevisioniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabellaPrevisioniMouseClicked
        String nota = listaPrev.get(jTabellaPrevisioni.getSelectedRow())[9];
        if (!nota.equals("vuoto")) {
            txtAreaNoteLettura.setText(nota);
        } else {
            txtAreaNoteLettura.setText("");
        }
    }//GEN-LAST:event_jTabellaPrevisioniMouseClicked
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

            listaPrev = new ArrayList<>();
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
    private javax.swing.JPanel AreaInteresse;
    private javax.swing.JPanel AreaParametri;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTabellaPrevisioni;
    private javax.swing.JLabel labelAltitudine;
    private javax.swing.JLabel labelAreaInteresse;
    private javax.swing.JLabel labelAreaPrevisioneSelezionata;
    private javax.swing.JLabel labelAreaSelezionata;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelIdCentro;
    private javax.swing.JLabel labelIntestazioneIAreaInteresse;
    private javax.swing.JLabel labelMassa;
    private javax.swing.JLabel labelPrecipitazioni;
    private javax.swing.JLabel labelPressione;
    private javax.swing.JLabel labelTemperatura;
    private javax.swing.JLabel labelUmidita;
    private javax.swing.JLabel labelVento;
    private javax.swing.JList<String> listAree;
    private javax.swing.JTextField noteAGhiacciai;
    private javax.swing.JTextField noteMGhiacciai;
    private javax.swing.JTextField notePrecipitazioni;
    private javax.swing.JTextField notePressione;
    private javax.swing.JTextField noteTemperatura;
    private javax.swing.JTextField noteUmidita;
    private javax.swing.JTextField noteVento;
    private javax.swing.JTextArea txtAreaNoteLettura;
    private javax.swing.JTextField txtAreaPrevisioneSelezionata;
    private javax.swing.JTextField txtAreaSelezionata;
    private javax.swing.JTextField txtIdCentro;
    private javax.swing.JTextField txtNomeArea;
    // End of variables declaration//GEN-END:variables
}
