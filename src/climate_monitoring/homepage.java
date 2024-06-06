package climate_monitoring;

import classi.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Classe che crea e gestisce la finestra homepage visibile da tutti, permette
 * di visualizzare aree d'interesse e stazioni in una tabella e cercarle in base
 * al nome e alle coordinate.
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class homepage extends javax.swing.JFrame implements WindowListener {

    /**
     * Oggetto condiviso contenente i dati utilizzati dall'applicazione.
     */
    private DatiCondivisi dc;
    /**
     * Oggetto remoto utilizzato per la comunicazione RMI.
     */
    private UnicastRemoteObject remoteObject;

    /**
     * Disegna la tabella utilizzando i dati forniti nella lista.
     *
     * @param al lista di array di stringhe contenente i dati da inserire nella tabella.
     * @return true se la tabella è stata riempita con successo, false se non sono stati trovati risultati.
     */
    public boolean drawTable(List<String[]> al) {
        tableRisultati.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome", "Tipo"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        if (!al.isEmpty()) {

            for (int i = 0; i < al.size(); i++) {
                model.addRow(al.get(i));
            }
            tableRisultati.setModel((TableModel) model);
            //    TableColumn col = tableRisultati.getColumnModel().getColumn(0);
            //    col.setMinWidth(0);
            //    col.setMaxWidth(0);
            //    col.setPreferredWidth(0);

            tableRisultati.removeColumn(tableRisultati.getColumnModel().getColumn(0));

            return true;

        } else {
            String[] p = {"", ""};
            model.addRow(p);
            tableRisultati.setModel((TableModel) model);
            return false;
        }

    }

    /**
     * Inizializza la tabella caricando i dati dalle aree di interesse e dalle stazioni.
     */
    public void initTable() {
        try {
            List<String[]> al = new ArrayList<>();
            ArrayList<JAreaInteresse> aree = dc.gestore_db.loadAree_interesse(null, null, -1, null, -1);
            for (JAreaInteresse area : aree) {
                String[] elements = {String.valueOf(area.getId_area()) + ";" + area.getGeoname_id(), area.toString().split(",")[1], "Area Interesse"};
                al.add(elements);
            }
            ArrayList<JStazione> stazioni = dc.gestore_db.loadStazioni(null, null, null, -1);
            for (JStazione stazione : stazioni) {
                String[] elements = {String.valueOf(stazione.getGeoname_id()), stazione.getNome(), "Stazione"};
                al.add(elements);
            }
            drawTable(al);
        } catch (RemoteException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Costruttore della classe homepage.
     * Inizializza i componenti, carica i dati nella tabella e centra la finestra sullo schermo.
     *
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    public homepage() throws RemoteException {
        this.dc = DatiCondivisi.getInstance();
        this.remoteObject = new RemoteObjectImpl();
        initComponents();
        initTable();    // inizializzo la tabella
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
    }

    /**
     * Questo metodo viene chiamato all'interno del costruttore per inizializzare il modulo.
     * ATTENZIONE: non modificare questo codice. Il contenuto di questo metodo è sempre
     * rigenerato dall'Editor di Form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnCerca = new javax.swing.JButton();
        txtCerca = new javax.swing.JTextField();
        btnAccedi = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRisultati = new javax.swing.JTable();
        txtCercaLon = new javax.swing.JTextField();
        txtCercaLat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(96, 108, 56));
        setForeground(java.awt.Color.white);

        jPanel2.setBackground(new java.awt.Color(177, 212, 224));

        btnCerca.setBackground(new java.awt.Color(177, 212, 224));
        btnCerca.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search.png"))); // NOI18N
        btnCerca.setText("Cerca");
        btnCerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaActionPerformed(evt);
            }
        });

        txtCerca.setBackground(new java.awt.Color(177, 212, 224));
        txtCerca.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtCerca.setActionCommand("null");
        txtCerca.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca per nome area o nome utente"));
        txtCerca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCercaKeyReleased(evt);
            }
        });

        btnAccedi.setBackground(new java.awt.Color(177, 212, 224));
        btnAccedi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAccedi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user.png"))); // NOI18N
        btnAccedi.setText("Accedi o Registrati");
        btnAccedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccediActionPerformed(evt);
            }
        });

        btnReload.setBackground(new java.awt.Color(177, 212, 224));
        btnReload.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/sync.png"))); // NOI18N
        btnReload.setText("Visualizza città disponibili");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tableRisultati.setBackground(new java.awt.Color(177, 212, 224));
        tableRisultati.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tableRisultati.setGridColor(new java.awt.Color(177, 212, 224));
        tableRisultati.setRowHeight(25);
        tableRisultati.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableRisultati.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableRisultati.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRisultatiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRisultati);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                                .addContainerGap())
        );

        txtCercaLon.setBackground(new java.awt.Color(177, 212, 224));
        txtCercaLon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtCercaLon.setBorder(javax.swing.BorderFactory.createTitledBorder("Longitudine"));

        txtCercaLat.setBackground(new java.awt.Color(177, 212, 224));
        txtCercaLat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtCercaLat.setBorder(javax.swing.BorderFactory.createTitledBorder("Latitudine"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnReload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCerca, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCercaLat, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                .addGap(12, 12, 12)
                                                .addComponent(txtCercaLon, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCerca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAccedi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnCerca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnReload, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCerca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                        .addComponent(txtCercaLon, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAccedi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCercaLat, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1229, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 665, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Gestisce l'evento di clic sul pulsante "Accedi o Registrati".
     * Apre la finestra di login e nasconde la finestra attuale.
     *
     * @param evt l'evento generato dal clic sul pulsante.
     */
    private void btnAccediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccediActionPerformed
        login l = new login(this);
        l.addWindowListener(this);
        l.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnAccediActionPerformed

    /**
     * Gestisce l'evento di clic sul pulsante "Cerca".
     * Esegue la ricerca in base al nome o alle coordinate fornite e aggiorna la tabella con i risultati.
     *
     * @param evt l'evento generato dal clic sul pulsante.
     */
    private void btnCercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaActionPerformed
        String testoDaCercare = "";
        List<String[]> al = new ArrayList<>();
        if (!txtCerca.getText().equals("") && (txtCercaLat.getText().equals("") && txtCercaLon.getText().equals(""))) {
            //cerco per nome
            al = searchName(txtCerca.getText());
        } else if (!txtCerca.getText().equals("") && (!txtCercaLat.getText().equals("") || !txtCercaLon.getText().equals(""))) {
            //errore
            JOptionPane.showMessageDialog(null, "Compilare solo un campo tra la ricerca per nome e ricerca per coordinate.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtCercaLat.getText().equals("") || txtCercaLon.getText().equals("")) {
            //errore
            JOptionPane.showMessageDialog(null, "Inserire entrambe le coordinate per la ricerca.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                testoDaCercare = txtCercaLat.getText() + "," + txtCercaLon.getText();
                //cerco per coordinate
                if (JCoordinate.sonoCoordinate(testoDaCercare)) {
                    List<JAreaInteresse> list_aree_interesse = dc.gestore_db.loadAree_interesse(null, new JCoordinate(testoDaCercare), 20, null, -1);
                    for (JAreaInteresse area : list_aree_interesse) {
                        al.add(new String[]{area.getId_area() + ";" + area.getGeoname_id(), area.getNome(), "Area Interesse"});
                    }
                    List<JStazione> list_stazioni = dc.gestore_db.loadStazioni(null, null, new JCoordinate(testoDaCercare), 20);
                    for (JStazione stazione : list_stazioni) {
                        al.add(new String[] {stazione.getGeoname_id().toString(), stazione.getNome(), "Stazione"});
                    }
                } else {
                    //errore
                    JOptionPane.showMessageDialog(null, "Inserire delle coordinate valide.", "Errore", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        drawTable(al);
    }//GEN-LAST:event_btnCercaActionPerformed

    /**
     * Gestisce l'evento di clic sulla tabella dei risultati.
     * Apre la finestra di informazioni corrispondente all'elemento selezionato (Stazione o Area di Interesse).
     *
     * @param evt l'evento generato dal clic sulla tabella.
     */
    private void tableRisultatiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRisultatiMouseClicked
        if (!tableRisultati.getModel().getValueAt(tableRisultati.getSelectedRow(), 0).toString().equals("")) {
            String tipo = tableRisultati.getModel().getValueAt(tableRisultati.getSelectedRow(), 2).toString();
            String id = tableRisultati.getModel().getValueAt(tableRisultati.getSelectedRow(), 0).toString();
            String nome = tableRisultati.getModel().getValueAt(tableRisultati.getSelectedRow(), 1).toString();
            if (tipo.equals("Stazione")) {
                infoStazione infoStaz = new infoStazione(id, this);
                infoStaz.addWindowListener(this);
                infoStaz.setVisible(true);
                setVisible(false);

            } else if (tipo.equals("Area Interesse")) {
                try {
                    mostraPrevisioni mpFinestra = new mostraPrevisioni(Integer.parseInt(id.split(";")[0]), id.split(";")[1], false, this);
                    mpFinestra.addWindowListener(this);
                    mpFinestra.setVisible(true);
                    setVisible(false);
                } catch (IOException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_tableRisultatiMouseClicked

    /**
     * Gestisce l'evento di clic sul pulsante "Visualizza città disponibili".
     * Ricarica e inizializza la tabella con i dati aggiornati.
     *
     * @param evt l'evento generato dal clic sul pulsante.
     */
    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        initTable();
        txtCerca.setText("");
        txtCercaLat.setText("");
        txtCercaLon.setText("");
    }//GEN-LAST:event_btnReloadActionPerformed

    /**
     * Gestisce l'evento di rilascio di un tasto nel campo di testo di ricerca.
     * Effettua una chiamata al servizio web per i suggerimenti in base al testo inserito.
     *
     * @param evt l'evento generato dal rilascio di un tasto.
     */
    private void txtCercaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCercaKeyReleased
        if (txtCerca.getText().matches(".*[a-zA-Z0-9].*")) {
            //se è stato inserito un carattere o un numero allora fai la chiamata al servizio web per i suggeriment
            String testo = txtCerca.getText().toLowerCase();
            if (!testo.isEmpty()) {
                new Thread(() -> {
                    synchronized (this) {
                        drawTable(searchName(testo));
                    }
                }).start();
            }
        } else if (txtCerca.getText().isEmpty()) {
            initTable();
        }
    }//GEN-LAST:event_txtCercaKeyReleased

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
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new homepage().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccedi;
    private javax.swing.JButton btnCerca;
    private javax.swing.JButton btnReload;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRisultati;
    private javax.swing.JTextField txtCerca;
    private javax.swing.JTextField txtCercaLat;
    private javax.swing.JTextField txtCercaLon;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowClosing(WindowEvent e) {
        if (!this.isVisible()) {
            this.setVisible(true);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
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

    /**
     * Implementazione dell'oggetto remoto per la comunicazione con il servizio RMI.
     */
    private class RemoteObjectImpl extends UnicastRemoteObject {
        /**
         * Costruttore dell'oggetto remoto.
         * Configura la connessione con il registro RMI e cerca l'interfaccia del database remoto.
         *
         * @throws RemoteException se si verifica un problema di comunicazione remota.
         */
        protected RemoteObjectImpl() throws RemoteException {
            super();
            Registry r = LocateRegistry.getRegistry("localhost", 1234);
            try {
                dc.gestore_db = (DBInterface) r.lookup("GestoreClimateMonitoring");
            } catch (Exception ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Effettua la ricerca delle aree di interesse in base al nome fornito.
     *
     * @param testoDaCercare il testo da cercare nelle aree di interesse.
     * @return una lista di array di stringhe contenenti i dati delle aree di interesse trovate.
     */
    private List<String[]> searchName(String testoDaCercare) {
        ArrayList<JAreaInteresse> listaAree = null;
        ArrayList<JStazione> listaStazioni = null;
        List<String[]> al = new ArrayList<>();
        //cerco per nome
        try {
            listaAree = dc.gestore_db.loadAree_interesse(testoDaCercare, null, -1, null, -1);
            listaStazioni = dc.gestore_db.loadStazioni(null, testoDaCercare, null, -1);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        for (JAreaInteresse area : listaAree) {
            al.add(new String[]{area.getId_area() + ";" + area.getGeoname_id(), area.getNome(), "Area Interesse"});
        }
        for (JStazione stazione : listaStazioni) {
            al.add(new String[]{String.valueOf(stazione.getGeoname_id()), stazione.getNome(), "Stazione"});
        }
        return al;
    }
}
