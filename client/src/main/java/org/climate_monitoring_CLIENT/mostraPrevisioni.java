/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.climate_monitoring_CLIENT;

import classi.JAreaInteresse;
import classi.JPrevisioni;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Classe che crea e gestisce la finestra mostraPrevisioni visibile da tutti,
 * permette di visualizzare le previsioni per una determinata area d'interesse.
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class mostraPrevisioni extends javax.swing.JFrame implements WindowListener {

    /**
     * Area di interesse per cui mostrare le previsioni.
     */
    private JAreaInteresse area;

    /**
     * Lista delle previsioni per l'area di interesse.
     */
    private ArrayList<JPrevisioni> list;

    /**
     * Indica se la finestra è stata aperta dalla finestra infoStazione.
     */
    private boolean fromStazione;

    /**
     * La finestra precedente che ha aperto questa finestra.
     */
    private Object paginaPrec;

    /**
     * Colonne della tabella delle previsioni.
     */
    private String[] columns = {"Vento", "Umidità", "Pressione", "Temperatura", "Precipitazione", "Altitudine Ghiacciai", "Massa Ghiacciai"};

    /**
     * Crea una nuova pagina mostraPrevisioni
     *
     * @param idArea       id dell'area d'interesse.
     * @param idStazione   id della stazione metereologica.
     * @param fromStazione indica se la finestra è stata aperta dalla finestra infoStazione.
     * @param paginaPrec   la finestra precedente che ha aperto questa finestra.
     */
    public mostraPrevisioni(int idArea, String idStazione, boolean fromStazione, Object paginaPrec) {
        initComponents();
        try {
            this.area = DatiCondivisi.getInstance().gestore_db.loadAree_interesse(null, null, -1, idStazione, idArea).get(0);
            this.fromStazione = fromStazione;
            this.paginaPrec = paginaPrec;
            lblTitle.setText("Previsioni: " + this.area.getNome());
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DATE, 14);
            Date dateTwoWeekAfter = c.getTime();
            jCalendar.setTodayButtonVisible(true);
            jCalendar.setSelectableDateRange(new Date(), dateTwoWeekAfter);
            list = DatiCondivisi.getInstance().gestore_db.loadPrevisioni(area.getGeoname_id(), area.getId_area(), false, new Date());
            drawTable(list);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            int x = (screenSize.width - this.getWidth()) / 2;
            int y = (screenSize.height - this.getHeight()) / 2;
            this.setLocation(x, y);
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Server non raggiungibile", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
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

        btnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jCalendar = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaPrevisioni = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNota = new javax.swing.JTextArea();

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
                new Object[][]{
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}
                },
                new String[]{
                        "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazione", "Altitudine ghiacciai", "Massa ghiacciai"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tabellaPrevisioni.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabellaPrevisioni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellaPrevisioniMouseClicked(evt);
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

        txtNota.setEditable(false);
        txtNota.setColumns(20);
        txtNota.setRows(5);
        jScrollPane2.setViewportView(txtNota);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(224, 224, 224)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnBack))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                                        .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnBack)
                                                .addGap(80, 80, 80))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblTitle)
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1201, Short.MAX_VALUE)
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

    /**
     * Metodo che gestisce il cambiamento della data selezionata e richiama il metodo drawTable
     *
     * @param evt evento di cambiamento della proprietà.
     */
    private void jCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarPropertyChange
        if (area != null) {
            try {
                list = DatiCondivisi.getInstance().gestore_db.loadPrevisioni(area.getGeoname_id(), area.getId_area(), false, jCalendar.getDate());
                if (list != null)
                    drawTable(list);
                txtNota.setText("");
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Server non raggiungibile", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }//GEN-LAST:event_jCalendarPropertyChange

    /**
     * Metodo che gestisce l'evento di clic sul pulsante Indietro.
     * Capisce se mostraPrevisioni è stato aperto da infoStazione o da homepage
     * e ritorna alla finestra precedente.
     *
     * @param evt l'evento generato dal clic sul pulsante.
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (fromStazione) {
            ((infoStazione) paginaPrec).setVisible(true);
            this.dispose();
        } else {
            ((homepage) paginaPrec).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Metodo che gestisce l'evento di chiusura della finestra.
     * Richiama il metodo btnBackActionPerformed per tornare alla finestra precedente.
     *
     * @param evt l'evento generato dalla chiusura della finestra.
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        btnBackActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing

    /**
     * Metodo che imposta le note della previsione selezionata sul campo txtNota.
     *
     * @param evt l'evento generato dal clic sulla tabella.
     */
    private void tabellaPrevisioniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaPrevisioniMouseClicked
        txtNota.setText(list.get(tabellaPrevisioni.getSelectedRow()).toString().split(",")[tabellaPrevisioni.getSelectedColumn() + 9]);
    }//GEN-LAST:event_tabellaPrevisioniMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup btnGroup;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tabellaPrevisioni;
    private javax.swing.JTextArea txtNota;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo che mostra le previsioni nella tabella in modo corretto.
     *
     * @param list lista delle previsioni create in base alla data precedentemente
     *             passata.
     * @throws IOException se si verifica un errore di input/output.
     */
    private void drawTable(ArrayList<JPrevisioni> list) throws IOException {
        tabellaPrevisioni.getTableHeader().setReorderingAllowed(false);
        List<String[]> listaPrev = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (JPrevisioni prev : list) {
                String[] elements = prev.toString().split(",");
                for (int i = 0; i < elements.length - 2; i++) {
                    elements[i] = elements[i + 2];
                }
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
                tabellaPrevisioni.setModel((TableModel) model);
            }
        } else {
            tabellaPrevisioni.setModel(new DefaultTableModel(columns, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            });
        }
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
