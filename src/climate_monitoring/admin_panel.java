/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package climate_monitoring;

import classi.DatiCondivisi;
import classi.JAreaInteresse;
import classi.JPrevisioni;
import classi.JUser;
import classi.ParserCSV;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
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
    //private Vector v = new Vector();
    private List<String[]> listaPrev;

    /**
     * Crea la pagina "pannello di controllo admin", inizializzando i valori
     * come la posizione della finestra, quale utente ha fatto l'accesso e
     * recupera tutte le aree d'interesse collegate alla stazione metereologica
     * riferita all'utente.
     *
     * @param userLoggato Oggetto che contiene l'utente che ha compiuto
     *                    l'accesso
     */
    public admin_panel(JUser userLoggato) throws RemoteException {
        initComponents();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);

        user = userLoggato;

        loadAreeInteresse();

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

        // manipulate date
        c.add(Calendar.DATE, 14);

        // convert calendar to date
        Date dateTwoWeekAfter = c.getTime();

        datePickerData.setDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        datePickerData.setSelectableDateRange(new Date(), dateTwoWeekAfter);
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
        btnModificaPrevisioni = new javax.swing.JButton();

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        noteVento.setBackground(new java.awt.Color(177, 212, 224));
        noteVento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        noteUmidita.setBackground(new java.awt.Color(177, 212, 224));
        noteUmidita.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        noteMGhiacciai.setBackground(new java.awt.Color(177, 212, 224));
        noteMGhiacciai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        noteTemperatura.setBackground(new java.awt.Color(177, 212, 224));
        noteTemperatura.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        notePressione.setBackground(new java.awt.Color(177, 212, 224));
        notePressione.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        notePrecipitazioni.setBackground(new java.awt.Color(177, 212, 224));
        notePrecipitazioni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        noteAGhiacciai.setBackground(new java.awt.Color(177, 212, 224));
        noteAGhiacciai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnModificaPrevisioni.setBackground(new java.awt.Color(177, 212, 224));
        btnModificaPrevisioni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModificaPrevisioni.setText("Modifica previsioni");
        btnModificaPrevisioni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaPrevisioniActionPerformed(evt);
            }
        });

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
                                .addComponent(noteTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AreaParametriLayout.createSequentialGroup()
                                        .addComponent(cmbUmidita, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(noteUmidita, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(AreaParametriLayout.createSequentialGroup()
                                        .addComponent(cmbVento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(noteVento, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(AreaParametriLayout.createSequentialGroup()
                                        .addComponent(cmbPressione, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(notePressione, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAggiungiPrevisioni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(AreaParametriLayout.createSequentialGroup()
                                        .addComponent(btnModificaPrevisioni, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(330, Short.MAX_VALUE))
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
                .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AreaParametriLayout.createSequentialGroup()
                        .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbVento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noteVento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelVento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelUmidita)
                            .addComponent(cmbUmidita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noteUmidita, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPressione)
                            .addComponent(cmbPressione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notePressione, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(AreaParametriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noteTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTemperatura))
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
                            .addComponent(noteMGhiacciai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AreaParametriLayout.createSequentialGroup()
                        .addComponent(btnAggiungiPrevisioni)
                        .addGap(26, 26, 26)
                        .addComponent(btnModificaPrevisioni)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
        String areaDiInteresse = txtNomeArea.getText();

        if (!areaDiInteresse.isBlank()) {
            // Controllo se è già stata inserita la seguente area di interesse
            boolean exist_area;
            try {
                exist_area = DatiCondivisi.getInstance().gestore_db.checkAreaInteresse(areaDiInteresse, user.getGeoname_id());
                if (exist_area) {
                    JOptionPane.showMessageDialog(null, "L'area di interesse è già stata aggiunta in precedenza", "Errore", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } catch (RemoteException ex) {
                Logger.getLogger(admin_panel.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }

            try {
                var result = DatiCondivisi.getInstance().gestore_db.AddAreaInteresse(areaDiInteresse, user.getGeoname_id());
                if (!result) {
                    JOptionPane.showMessageDialog(null, "Errore durante l'aggiunta dell'area di interesse", "Errore", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                loadAreeInteresse();
            } catch (RemoteException ex) {
                Logger.getLogger(admin_panel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else
            JOptionPane.showMessageDialog(null, "Compilare il valore", "Errore", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAggiungiAreaActionPerformed

    /**
     * Questo metodo viene richiamato quando selezionata un'area d'interesse
     * dalla lista, viene semplicemente richiamato il metodo per aggiornare la
     * tabella delle previsioni.
     */
    private void listAreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAreeMouseClicked
        aggiornaTabella();

        datePickerData.setDate( new Date() );
        
        cmbVento.setSelectedIndex(0);
        cmbUmidita.setSelectedIndex(0);
        cmbPressione.setSelectedIndex(0);
        cmbTemperatura.setSelectedIndex(0);
        cmbPrecipitazioni.setSelectedIndex(0);
        cmbGhiacciai.setSelectedIndex(0);
        cmbMassaGhiacciai.setSelectedIndex(0);

        noteVento.setText("");
        noteUmidita.setText("");
        notePressione.setText("");
        noteTemperatura.setText("");
        notePrecipitazioni.setText("");
        noteAGhiacciai.setText("");
        noteMGhiacciai.setText("");
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
        if (!txtAreaSelezionata.getText().isEmpty()) {
            Date date = datePickerData.getDate();

            int id = Integer.parseInt(txtIdCentro.getText());
            String vVento = cmbVento.getItemAt(cmbVento.getSelectedIndex());
            String pUmidita = cmbUmidita.getItemAt(cmbUmidita.getSelectedIndex());
            String pressione = cmbPressione.getItemAt(cmbPressione.getSelectedIndex());
            String temperatura = cmbTemperatura.getItemAt(cmbTemperatura.getSelectedIndex());
            String precipitazioni = cmbPrecipitazioni.getItemAt(cmbPrecipitazioni.getSelectedIndex());
            String aGhiacciai = cmbGhiacciai.getItemAt(cmbGhiacciai.getSelectedIndex());
            String mGhiacciai = cmbMassaGhiacciai.getItemAt(cmbMassaGhiacciai.getSelectedIndex());

            String nVento = noteVento.getText().isEmpty() ? " " : noteVento.getText();
            String nUmidita = noteUmidita.getText().isEmpty() ? " " : noteUmidita.getText();
            String nPRessione = notePressione.getText().isEmpty() ? " " : notePressione.getText();
            String nTemperatura = noteTemperatura.getText().isEmpty() ? " " : noteTemperatura.getText();
            String nPrecipitazioni = notePrecipitazioni.getText().isEmpty() ? " " : notePrecipitazioni.getText();
            String nAGhiacciai = noteAGhiacciai.getText().isEmpty() ? " " : noteAGhiacciai.getText();
            String nMGhiacciai = noteMGhiacciai.getText().isEmpty() ? " " : noteMGhiacciai.getText();

            var id_area = user.getId_areaSelezionata();
            Integer username = Integer.valueOf(user.getId());
            var result = false;
            try {
                result = DatiCondivisi.getInstance().gestore_db.AddPrevisione(date, id_area, id, username, vVento, pUmidita, pressione, temperatura, precipitazioni, aGhiacciai, mGhiacciai, nVento, nUmidita, nPRessione, nTemperatura, nPrecipitazioni, nAGhiacciai, nMGhiacciai);
            } catch (RemoteException ex) {
                Logger.getLogger(admin_panel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!result) {
                JOptionPane.showMessageDialog(null, "Errore durante l'aggiunta della previsione", "Errore", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            aggiornaTabella();
            cmbVento.setSelectedIndex(0);
            cmbUmidita.setSelectedIndex(0);
            cmbPressione.setSelectedIndex(0);
            cmbTemperatura.setSelectedIndex(0);
            cmbPrecipitazioni.setSelectedIndex(0);
            cmbGhiacciai.setSelectedIndex(0);
            cmbMassaGhiacciai.setSelectedIndex(0);

            noteVento.setText("");
            noteUmidita.setText("");
            notePressione.setText("");
            noteTemperatura.setText("");
            notePrecipitazioni.setText("");
            noteAGhiacciai.setText("");
            noteMGhiacciai.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Seleziona un'area d'interesse.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAggiungiPrevisioniActionPerformed

    /**
     * Metodo che prende la nota associata alla variabile di una previsione e la
     * imposta sul txtAreaNoteLettura
     *
     * @param evt
     */
    private void jTabellaPrevisioniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabellaPrevisioniMouseClicked
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        if (jTabellaPrevisioni.getSelectedColumn() >= 2)
            txtAreaNoteLettura.setText(listaPrev.get(jTabellaPrevisioni.getSelectedRow())[jTabellaPrevisioni.getSelectedColumn() + 7]);
        else
            txtAreaNoteLettura.setText("");
        if(jTabellaPrevisioni.getSelectedRow()>=0){
            try {
                datePickerData.setDate(formatter.parse(listaPrev.get(jTabellaPrevisioni.getSelectedRow())[0]));
                txtIdCentro.setText(listaPrev.get(jTabellaPrevisioni.getSelectedRow())[1]);
                noteVento.setText(listaPrev.get(jTabellaPrevisioni.getSelectedRow())[9]);
                noteUmidita.setText(listaPrev.get(jTabellaPrevisioni.getSelectedRow())[10]);
                notePressione.setText(listaPrev.get(jTabellaPrevisioni.getSelectedRow())[11]);
                noteTemperatura.setText(listaPrev.get(jTabellaPrevisioni.getSelectedRow())[12]);
                notePrecipitazioni.setText(listaPrev.get(jTabellaPrevisioni.getSelectedRow())[13]);
                noteAGhiacciai.setText(listaPrev.get(jTabellaPrevisioni.getSelectedRow())[14]);
                noteMGhiacciai.setText(listaPrev.get(jTabellaPrevisioni.getSelectedRow())[15]);
                
                cmbVento.setSelectedIndex( Integer.parseInt( listaPrev.get(jTabellaPrevisioni.getSelectedRow())[2] ) -1 );
                cmbUmidita.setSelectedIndex( Integer.parseInt( listaPrev.get(jTabellaPrevisioni.getSelectedRow())[3] ) -1 );
                cmbPressione.setSelectedIndex( Integer.parseInt( listaPrev.get(jTabellaPrevisioni.getSelectedRow())[4] ) -1 );
                cmbTemperatura.setSelectedIndex( Integer.parseInt( listaPrev.get(jTabellaPrevisioni.getSelectedRow())[5] ) -1 );
                cmbPrecipitazioni.setSelectedIndex( Integer.parseInt( listaPrev.get(jTabellaPrevisioni.getSelectedRow())[6] ) -1 );
                cmbGhiacciai.setSelectedIndex( Integer.parseInt( listaPrev.get(jTabellaPrevisioni.getSelectedRow())[7] ) -1 );
                cmbMassaGhiacciai.setSelectedIndex( Integer.parseInt( listaPrev.get(jTabellaPrevisioni.getSelectedRow())[8] ) -1 );
            } catch (ParseException ex) {
                Logger.getLogger(admin_panel.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        }
    }//GEN-LAST:event_jTabellaPrevisioniMouseClicked

    private void btnModificaPrevisioniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaPrevisioniActionPerformed
        // TODO add your handling code here:
        
        if (!txtAreaSelezionata.getText().isEmpty()) {
            Date date = datePickerData.getDate();

            int id = Integer.parseInt(txtIdCentro.getText());
            
            String vVento = cmbVento.getItemAt(cmbVento.getSelectedIndex());
            String pUmidita = cmbUmidita.getItemAt(cmbUmidita.getSelectedIndex());
            String pressione = cmbPressione.getItemAt(cmbPressione.getSelectedIndex());
            String temperatura = cmbTemperatura.getItemAt(cmbTemperatura.getSelectedIndex());
            String precipitazioni = cmbPrecipitazioni.getItemAt(cmbPrecipitazioni.getSelectedIndex());
            String aGhiacciai = cmbGhiacciai.getItemAt(cmbGhiacciai.getSelectedIndex());
            String mGhiacciai = cmbMassaGhiacciai.getItemAt(cmbMassaGhiacciai.getSelectedIndex());

            String nVento = noteVento.getText().isEmpty() ? " " : noteVento.getText();
            String nUmidita = noteUmidita.getText().isEmpty() ? " " : noteUmidita.getText();
            String nPRessione = notePressione.getText().isEmpty() ? " " : notePressione.getText();
            String nTemperatura = noteTemperatura.getText().isEmpty() ? " " : noteTemperatura.getText();
            String nPrecipitazioni = notePrecipitazioni.getText().isEmpty() ? " " : notePrecipitazioni.getText();
            String nAGhiacciai = noteAGhiacciai.getText().isEmpty() ? " " : noteAGhiacciai.getText();
            String nMGhiacciai = noteMGhiacciai.getText().isEmpty() ? " " : noteMGhiacciai.getText();

            var id_area = user.getId_areaSelezionata();
            Integer username = Integer.valueOf(user.getId());
            var result = false;
            try {
                result = DatiCondivisi.getInstance().gestore_db.editPrevisione(date, id_area, id, username, vVento, pUmidita, pressione, temperatura, precipitazioni, aGhiacciai, mGhiacciai, nVento, nUmidita, nPRessione, nTemperatura, nPrecipitazioni, nAGhiacciai, nMGhiacciai);
            } catch (RemoteException ex) {
                Logger.getLogger(admin_panel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!result) {
                JOptionPane.showMessageDialog(null, "Errore durante l'aggiunta della previsione", "Errore", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            
            
            aggiornaTabella();
            cmbVento.setSelectedIndex(0);
            cmbUmidita.setSelectedIndex(0);
            cmbPressione.setSelectedIndex(0);
            cmbTemperatura.setSelectedIndex(0);
            cmbPrecipitazioni.setSelectedIndex(0);
            cmbGhiacciai.setSelectedIndex(0);
            cmbMassaGhiacciai.setSelectedIndex(0);

            noteVento.setText("");
            noteUmidita.setText("");
            notePressione.setText("");
            noteTemperatura.setText("");
            notePrecipitazioni.setText("");
            noteAGhiacciai.setText("");
            noteMGhiacciai.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Seleziona un'area d'interesse.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnModificaPrevisioniActionPerformed

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

            ArrayList<JPrevisioni> list = DatiCondivisi.getInstance().gestore_db.loadPrevisioni(user.getGeoname_id(), idAreaInteresse, false, null);

            listaPrev = new ArrayList<>();
            for (JPrevisioni prev : list) {
                String[] elements = prev.toString().split(",", -1);
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
            jTabellaPrevisioni.getTableHeader().setReorderingAllowed(false);
        } catch (IOException ex) {
            Logger.getLogger(admin_panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AreaInteresse;
    private javax.swing.JPanel AreaParametri;
    private javax.swing.JButton btnAggiungiArea;
    private javax.swing.JButton btnAggiungiPrevisioni;
    private javax.swing.JButton btnModificaPrevisioni;
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

    private void loadAreeInteresse() throws RemoteException {
        Vector v = new Vector();
        
        ArrayList<JAreaInteresse> list = DatiCondivisi.getInstance().gestore_db.loadAree_interesse(null, null, -1, user.getGeoname_id(), -1);
        if (list != null && !list.isEmpty()) {
            for (JAreaInteresse a : list) {
                v.add(a.toStringList());
            }
            listAree.setListData(v);
        }
    }
}
