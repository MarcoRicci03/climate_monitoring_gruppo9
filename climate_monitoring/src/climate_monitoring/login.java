/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package climate_monitoring;

import classi.JUser;
import classi.ParserCSV;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class login extends javax.swing.JFrame implements WindowListener {

    JUser utenteLoggato = null;

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        nascondiOggettiPannelSinistro();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);

        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        labelUserLoggato = new javax.swing.JLabel();
        btnAggiungiStazione = new javax.swing.JButton();
        btnGestionePrevisioni = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnRegistrati = new javax.swing.JButton();
        btnAccedi = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        labelPasswd = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(40, 54, 24));
        setMaximumSize(new java.awt.Dimension(361, 260));
        setMinimumSize(new java.awt.Dimension(361, 260));
        setResizable(false);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                formComponentRemoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(177, 212, 224));

        labelUserLoggato.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelUserLoggato.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelUserLoggato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user.png"))); // NOI18N
        labelUserLoggato.setLabelFor(txtUsername);

        btnAggiungiStazione.setBackground(new java.awt.Color(177, 212, 224));
        btnAggiungiStazione.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAggiungiStazione.setText("Aggiungi stazione");
        btnAggiungiStazione.setPreferredSize(new java.awt.Dimension(72, 28));
        btnAggiungiStazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggiungiStazioneActionPerformed(evt);
            }
        });

        btnGestionePrevisioni.setBackground(new java.awt.Color(177, 212, 224));
        btnGestionePrevisioni.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnGestionePrevisioni.setText("Gestione Previsioni");
        btnGestionePrevisioni.setPreferredSize(new java.awt.Dimension(72, 28));
        btnGestionePrevisioni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionePrevisioniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGestionePrevisioni, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(btnAggiungiStazione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelUserLoggato, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelUserLoggato, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGestionePrevisioni, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAggiungiStazione, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 260));

        jPanel1.setBackground(new java.awt.Color(177, 212, 224));

        btnRegistrati.setBackground(new java.awt.Color(177, 212, 224));
        btnRegistrati.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnRegistrati.setText("Registrati");
        btnRegistrati.setPreferredSize(new java.awt.Dimension(79, 28));
        btnRegistrati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistratiActionPerformed(evt);
            }
        });

        btnAccedi.setBackground(new java.awt.Color(177, 212, 224));
        btnAccedi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAccedi.setText("Accedi");
        btnAccedi.setPreferredSize(new java.awt.Dimension(72, 28));
        btnAccedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccediActionPerformed(evt);
            }
        });

        txtPass.setBackground(new java.awt.Color(177, 212, 224));
        txtPass.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtPass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPass.setText("asd");
        txtPass.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtUsername.setBackground(new java.awt.Color(177, 212, 224));
        txtUsername.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUsername.setText("m_ricci1");
        txtUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        labelPasswd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPasswd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/passwd_.png"))); // NOI18N
        labelPasswd.setToolTipText("");
        labelPasswd.setPreferredSize(new java.awt.Dimension(80, 80));

        labelUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user.png"))); // NOI18N
        labelUser.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAccedi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrati, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelPasswd, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(txtUsername))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(labelPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAccedi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrati, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo che apre la finestra crea stazione
     *
     * @param evt
     */
    private void btnAggiungiStazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiungiStazioneActionPerformed
        // TODO add your handling code here:
        creaStazione cp = new creaStazione();
        cp.addWindowListener(this);
        cp.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnAggiungiStazioneActionPerformed

    /**
     * Metodo che apre la finestra gestione previsioni con l'utente loggato
     *
     * @param evt
     */
    private void btnGestionePrevisioniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionePrevisioniActionPerformed
        // TODO add your handling code here:
        admin_panel ap = new admin_panel(utenteLoggato);
        ap.addWindowListener(this);
        ap.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnGestionePrevisioniActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    /**
     * Metodo che controlla se l'utente esiste, in caso positivo mostra le
     * funzioni disponili
     */
    private void btnAccediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccediActionPerformed
        try {
            //Controllo la correttezza dei dati inseriti
            if (!txtUsername.getText().isBlank() || !txtPass.getText().isBlank()) {
                utenteLoggato = ParserCSV.creaUtenteLoggato(txtUsername.getText(), txtPass.getText()); 
                if (utenteLoggato != null) {
                    mostraOggettiPannelSinistro();
                    nascondiOggettiPannelDestro();
                    //admin_panel ap = new admin_panel(utenteLoggato);
                    //ap.addWindowListener(this);
                    //ap.setVisible(true);
                    //setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Username/Password errata", "Errore", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Inserisci Username/Password", "Errore", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAccediActionPerformed

    /**
     * Metodo che apre la finestra Registrazione
     *
     * @param evt
     */
    private void btnRegistratiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistratiActionPerformed
        registrazione r = new registrazione();
        r.addWindowListener(this);
        r.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnRegistratiActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentRemoved

    /**
     * Nasconte pannel di accesso
     */
    private void nascondiOggettiPannelDestro() {
        jPanel1.setVisible(false);
        labelPasswd.setVisible(false);
        labelUser.setVisible(false);
        txtPass.setVisible(false);
        txtUsername.setVisible(false);
        btnAccedi.setVisible(false);
        btnRegistrati.setVisible(false);
    }

    //Mostra pannel utente loggato
    public void mostraOggettiPannelSinistro() {
        jPanel2.setVisible(true);
        labelUserLoggato.setText(utenteLoggato.getUsername());
        labelUserLoggato.setVisible(true);
        btnAggiungiStazione.setVisible(true);
        btnGestionePrevisioni.setVisible(true);
    }

    /**
     * Nasconde pannel utente loggato
     */
    public void nascondiOggettiPannelSinistro() {
        jPanel2.setVisible(false);
        labelUserLoggato.setVisible(false);
        btnAggiungiStazione.setVisible(false);
        btnGestionePrevisioni.setVisible(false);
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccedi;
    private javax.swing.JButton btnAggiungiStazione;
    private javax.swing.JButton btnGestionePrevisioni;
    private javax.swing.JButton btnRegistrati;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelPasswd;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel labelUserLoggato;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        setVisible(true);
        if (utenteLoggato != null) {
            nascondiOggettiPannelDestro();
            mostraOggettiPannelSinistro();
        }
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
