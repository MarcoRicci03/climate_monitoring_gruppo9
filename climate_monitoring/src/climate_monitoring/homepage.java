/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package climate_monitoring;

import classi.JAreaInteresse;
import classi.JCoordinate;
import classi.JLuogo;
import classi.ParserCSV;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
     * Questa funzione disegna la tabella attraverso la lista passata come
     * parametro.
     *
     * @param al lista con i dati da inserire nella tabella.
     */
    public boolean drawTable(List<String[]> al) {
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
     * Questa funzione inizializza la tabella caricando in una lista le aree di
     * interesse leggendo il file "dati/areedinteresse.csv"
     *
     */
    public void initTable() {
        List<String[]> al = new ArrayList<>();
        ArrayList<JAreaInteresse> listaAree = ParserCSV.getAllAreeInteresse();
        for (JAreaInteresse area : listaAree) {
            String[] elements = {String.valueOf(area.getId_area()), area.toString().split(",")[1], "Area Interesse"};
            al.add(elements);
        }

        drawTable(al);
    }

    /**
     * Costruttore della pagina mettendo la finestra al centro dello schermo
     *
     */
    public homepage() {
        initComponents();
        initTable();    // inizializzo la tabella

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
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
     * Metodo richiamato alla pressione del pulsante Accedi o Registrati, apre
     * la pagina di login.
     *
     */
    private void btnAccediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccediActionPerformed
        //Apro la pagina di login
        login l = new login();
        l.addWindowListener(this);
        l.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnAccediActionPerformed

    /**
     * Metodo richiamato quando viene premuto il pulsante cerca, si controlla
     * quale campo é stato compilato (per nome o per coordinate) e si cerca in
     * base ad esso.
     *
     */
    private void btnCercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaActionPerformed
        //cerca area interesse
        String testoDaCercare = "";
        List<String[]> al = new ArrayList<>();

        if (!txtCerca.getText().equals("") && (txtCercaLat.getText().equals("") && txtCercaLon.getText().equals(""))) {
            testoDaCercare = txtCerca.getText();
            //cerco per nome
            ArrayList<JAreaInteresse> listaAree = ParserCSV.cercaPerArea(testoDaCercare);

            for (JAreaInteresse prev : listaAree) {
                String[] elements = {prev.getId_area().toString(), prev.toString().split(",")[1], "Area Interesse"};
                al.add(elements);
            }

            ArrayList<JLuogo> listStazioni = ParserCSV.cercaPerStazione(testoDaCercare, null, null);
            for (JLuogo l : listStazioni) {
                String[] elements = {l.getGeoname_id().toString(), l.getNome(), "Stazione metereologica"};
                al.add(elements);
            }
        } else if (!txtCerca.getText().equals("") && (!txtCercaLat.getText().equals("") || !txtCercaLon.getText().equals(""))) {
            //errore
            JOptionPane.showMessageDialog(null, "Compilare solo un campo tra la ricerca per e ricerca per coordinate.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtCercaLat.getText().equals("") || txtCercaLon.getText().equals("")) {
            //errore
            JOptionPane.showMessageDialog(null, "Inserire entrambe le coordinate per la ricerca.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        } else {
            testoDaCercare = txtCercaLat.getText() + "," + txtCercaLon.getText();
            //cerco per coordinate
            if (JCoordinate.sonoCoordinate(testoDaCercare)) {
                ArrayList<JLuogo> listStazioni = ParserCSV.cercaPerStazione(null, new JCoordinate(testoDaCercare), 20);
                for (JLuogo l : listStazioni) {
                    String[] elements = {l.getGeoname_id().toString(), l.getNome(), "Stazione metereologica"};
                    al.add(elements);
                }
            } else {
                //errore
                JOptionPane.showMessageDialog(null, "Inserire delle coordinate valide.", "Errore", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        drawTable(al);
    }//GEN-LAST:event_btnCercaActionPerformed

    /**
     * Apre la pagina della stazione o area d'interesse selezionata nella
     * tabella.
     *
     */
    private void tableRisultatiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRisultatiMouseClicked
        if (!tableRisultati.getModel().getValueAt(tableRisultati.getSelectedRow(), 0).toString().equals("")) {
            int id = Integer.parseInt(tableRisultati.getModel().getValueAt(tableRisultati.getSelectedRow(), 0).toString());
            if (id > 100000) {
                infoStazione infoStaz = new infoStazione(id);
                infoStaz.addWindowListener(this);
                infoStaz.setVisible(true);
                setVisible(false);

            } else {
                try {
                    mostraPrevisioni mpFinestra = new mostraPrevisioni(id, -1);
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
     * Ricarica la tabella con le aree di interesse
     *
     */
    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        // TODO add your handling code here:
        initTable();
    }//GEN-LAST:event_btnReloadActionPerformed

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
                new homepage().setVisible(true);
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
        setVisible(true);
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
}
