/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package climate_monitoring;

import classi.JLuogo;
import classi.ParserCSV;
import engine.Engine;
import engine.Person;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class registrazione extends javax.swing.JFrame {

    public ArrayList<JLuogo> al;
    static JLuogo luogoNuovo;

    /**
     * Creates new form registrazione
     */
    public registrazione() {
        initComponents();
        //posizione centrata della finestra all'avvio
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
        //creazione della lista di tutte le stazioni metereologiche salvate sul file stazioni.csv, inserite poi
        //nel combobox per la selezione
        al = ParserCSV.creaListaStazioni();
        for (int i = 0; i < al.size(); i++) {
            cmbStazione.addItem(al.get(i).getNome());
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

        jPanel1 = new javax.swing.JPanel();
        btnRegistrazione = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtCognome = new javax.swing.JTextField();
        labelTxt = new javax.swing.JLabel();
        labelCognome = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        labelPasswordConferma = new javax.swing.JLabel();
        txtPassConferma = new javax.swing.JPasswordField();
        dataDiNascita = new javax.swing.JLabel();
        labelSesso = new javax.swing.JLabel();
        cmbSesso = new javax.swing.JComboBox<>();
        labelLuogoNascita = new javax.swing.JLabel();
        txtLuogoNascita = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbStazione = new javax.swing.JComboBox<>();
        btnCrea = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtIdOperatore = new javax.swing.JTextField();
        datePickerDataNascita = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(96, 108, 56));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(177, 212, 224));

        btnRegistrazione.setBackground(new java.awt.Color(177, 212, 224));
        btnRegistrazione.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        btnRegistrazione.setText("Registrati");
        btnRegistrazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrazioneActionPerformed(evt);
            }
        });

        txtNome.setBackground(new java.awt.Color(177, 212, 224));
        txtNome.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCognome.setBackground(new java.awt.Color(177, 212, 224));
        txtCognome.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtCognome.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labelTxt.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        labelTxt.setText("Nome:");

        labelCognome.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        labelCognome.setText("Cognome:");

        labelPassword.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        labelPassword.setText("Password:");

        txtPass.setBackground(new java.awt.Color(177, 212, 224));
        txtPass.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtPass.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labelPasswordConferma.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        labelPasswordConferma.setText("Conferma password:");

        txtPassConferma.setBackground(new java.awt.Color(177, 212, 224));
        txtPassConferma.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtPassConferma.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        dataDiNascita.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        dataDiNascita.setText("Data di nascita:");

        labelSesso.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        labelSesso.setText("Sesso:");

        cmbSesso.setBackground(new java.awt.Color(177, 212, 224));
        cmbSesso.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        cmbSesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        labelLuogoNascita.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        labelLuogoNascita.setText("Luogo di nascita:");

        txtLuogoNascita.setBackground(new java.awt.Color(177, 212, 224));
        txtLuogoNascita.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtLuogoNascita.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtLuogoNascita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuogoNascitaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel8.setText("Stazione meteorologica:");

        cmbStazione.setBackground(new java.awt.Color(177, 212, 224));
        cmbStazione.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        cmbStazione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));
        cmbStazione.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbStazioneMousePressed(evt);
            }
        });

        btnCrea.setBackground(new java.awt.Color(177, 212, 224));
        btnCrea.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        btnCrea.setText("Crea stazione");
        btnCrea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel9.setText("Id operatore:");

        txtIdOperatore.setBackground(new java.awt.Color(177, 212, 224));
        txtIdOperatore.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtIdOperatore.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        datePickerDataNascita.setBackground(new java.awt.Color(177, 212, 224));
        datePickerDataNascita.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCognome, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPasswordConferma, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataDiNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSesso, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelLuogoNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLuogoNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdOperatore, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCognome, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datePickerDataNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassConferma, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStazione, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSesso, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCrea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegistrazione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelCognome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPasswordConferma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassConferma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCognome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataDiNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerDataNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSesso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSesso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLuogoNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLuogoNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdOperatore, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrea, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStazione, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrazione, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo che permette la creazione di un utente controllando i valori passati nei parametri se correttamente impostati
     * @param evt 
     */
    private void btnRegistrazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrazioneActionPerformed
        // TODO add your handling code here:
        try {
            if (ParserCSV.checkCodiceOperatore(txtIdOperatore.getText())) { //controllo esistenza e correttezza del codice operatore
                //controlli per verificare che tutti i campi siano stati compilati
                if (!txtNome.getText().isEmpty() && !txtCognome.getText().isEmpty() && !datePickerDataNascita.getDate().toString().isEmpty()
                        && !txtLuogoNascita.getText().isEmpty() && !txtPass.getText().isEmpty() && !txtPassConferma.getText().isEmpty()) {
                    if (txtPass.getText().equals(txtPassConferma.getText())) {
                        //crezione oggetto persona per il codice fiscale
                        Person p = new Person();
                        p.setName(txtNome.getText());
                        p.setSurname(txtCognome.getText());
                        LocalDate ld = datePickerDataNascita.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        p.setDay(String.valueOf(ld.getDayOfMonth()));
                        p.setMonth(String.valueOf(ld.getMonthValue()));
                        p.setYear(String.valueOf(ld.getYear()));
                        p.setBornCity(txtLuogoNascita.getText().toUpperCase());
                        p.setSex(cmbSesso.getItemAt(cmbSesso.getSelectedIndex()));
                        Engine e = null;
                        try {
                            e = new Engine(p);
                        } catch (IOException ex) {
                            return;
                        }
                        Integer i = al.get(cmbStazione.getSelectedIndex() - 1).getGeoname_id();

                        //registrazione dell'utente solamente se non esiste altro utente con codice operatore uguali
                        if (!ParserCSV.registraUtente(p.getName().toLowerCase(), p.getSurname().toLowerCase(), txtPass.getText(), e.getCode(), al.get(cmbStazione.getSelectedIndex() - 1).getGeoname_id(), txtIdOperatore.getText())) {
                            //finestra di errore in caso di un utente già registrato
                            JOptionPane.showMessageDialog(null, "Questo operatore ha già un account.", "Errore", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Le password devono corrispondere", "Errore", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Compilare tutti i campi", "Errore", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Codice operatore errato", "Errore", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Compilare tutti i campi", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrazioneActionPerformed

    /**
     * Metodo che apre la finestra per la creazione di una nuova stazione controllando l'esistenza del codice operatore
     * @param evt 
     */
    private void btnCreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreaActionPerformed
        //controllo esistenza codice operatore
        if (ParserCSV.checkCodiceOperatore(txtIdOperatore.getText())) {
            //apro la finestra per la creazione di una nuova stazione
            creaStazione cS = new creaStazione();
            cS.show();
        } else {
            JOptionPane.showMessageDialog(null, "Codice operatore errato", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCreaActionPerformed
    /**
     * Metodo che visualizza le stazioni possibili
     * @param evt 
     */
    private void cmbStazioneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbStazioneMousePressed
        // TODO add your handling code here:
        if (luogoNuovo != null) {
            //aggiorno lista e combobox
            al.add(luogoNuovo);
            cmbStazione.addItem(luogoNuovo.getNome());
        }
    }//GEN-LAST:event_cmbStazioneMousePressed

    private void txtLuogoNascitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuogoNascitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuogoNascitaActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

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
            java.util.logging.Logger.getLogger(registrazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrazione.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrazione().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrea;
    private javax.swing.JButton btnRegistrazione;
    private javax.swing.JComboBox<String> cmbSesso;
    private javax.swing.JComboBox<String> cmbStazione;
    private javax.swing.JLabel dataDiNascita;
    private com.toedter.calendar.JDateChooser datePickerDataNascita;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCognome;
    private javax.swing.JLabel labelLuogoNascita;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelPasswordConferma;
    private javax.swing.JLabel labelSesso;
    private javax.swing.JLabel labelTxt;
    private javax.swing.JTextField txtCognome;
    private javax.swing.JTextField txtIdOperatore;
    private javax.swing.JTextField txtLuogoNascita;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPassConferma;
    // End of variables declaration//GEN-END:variables
}
