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
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author marco
 */
public class homepage extends javax.swing.JFrame implements WindowListener {

    /**
     * Questa funzione disegna la tabella attraverso la lista passata come
     * parametro.
     */
    public boolean drawTable(List<String[]> al) {
        if (!al.isEmpty()) {

            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome", "Tipo"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };

            for (int i = 0; i < al.size(); i++) {
                model.addRow(al.get(i));
                System.out.println(al.get(i)[0]);
            }
            tableRisultati.setModel((TableModel) model);
        //    TableColumn col = tableRisultati.getColumnModel().getColumn(0);
        //    col.setMinWidth(0);
        //    col.setMaxWidth(0);
        //    col.setPreferredWidth(0);
            tableRisultati.removeColumn(tableRisultati.getColumnModel().getColumn(0));
            return true;

        } else {
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

    public homepage() {
        initComponents();
        initTable();    // inizializzo la tabella
        
        
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);


        // tableRisultati.getModel().getValueAt(tableRisultati.getSelectedRow(),0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAccedi = new javax.swing.JButton();
        txtCerca = new javax.swing.JTextField();
        btnCerca = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRisultati = new javax.swing.JTable();
        btnReload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAccedi.setText("Accedi o Registrati");
        btnAccedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccediActionPerformed(evt);
            }
        });

        btnCerca.setText("Cerca");
        btnCerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnReload.setText("Visualizza città disponibili");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnReload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAccedi))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtCerca, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerca)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccedi)
                    .addComponent(btnReload))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCerca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccediActionPerformed
        //Apro la pagina di login
        login l = new login();
        l.addWindowListener(this);
        l.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnAccediActionPerformed

    private void btnCercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaActionPerformed
        //cerca area interesse
        String testoDaCercare = txtCerca.getText();
        List<String[]> al = new ArrayList<>();

        if (JCoordinate.sonoCoordinate(testoDaCercare)) {
            //cerco per coordinate
            ArrayList<JLuogo> listStazioni = ParserCSV.cercaPerStazione(null, new JCoordinate(testoDaCercare), 20);
            for (JLuogo l : listStazioni) {
                String[] elements = {l.getNome(), "Stazione metereologica"};
                al.add(elements);
            }
        } else if (!testoDaCercare.isBlank() && testoDaCercare != "") {

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
        }
        drawTable(al);
    }//GEN-LAST:event_btnCercaActionPerformed

    private void tableRisultatiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRisultatiMouseClicked
        mostraPrevisioni mpFinestra;
        int id = Integer.parseInt( tableRisultati.getModel().getValueAt(tableRisultati.getSelectedRow(),0).toString() );
        System.out.println("pre: " + id);
        
         try {    
            mpFinestra = new mostraPrevisioni( id );
            mpFinestra.addWindowListener(this);
            mpFinestra.setVisible(true);
            setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        
//        int id = Integer.parseInt(tableRisultati.getModel().getValueAt(tableRisultati.getSelectedRow(), 0).toString());
//
//        mostraPrevisioni mpFinestra = new mostraPrevisioni();
//        mpFinestra.addWindowListener(this);
//        mpFinestra.setVisible(true);
//        setVisible(false);
//
//        mpFinestra.id = id;

    }//GEN-LAST:event_tableRisultatiMouseClicked

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRisultati;
    private javax.swing.JTextField txtCerca;
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
