/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.climate_monitoring_CLIENT;

import classi.JUser;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Classe che crea e gestisce la finestra login visibile da tutti, permette agli
 * operatori già registrati di accedere alla pagina degli operatori, mentre se
 * un operatore non è ancora registrato può aprire la pagina della registrazione
 * tramite l'apposito bottone.
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class login extends javax.swing.JFrame implements WindowListener {

    /**
     * L'utente attualmente loggato.
     *
     * @see JUser
     */
    private JUser utenteLoggato = null;

    /**
     * La finestra precedente che ha aperto questa finestra.
     *
     * @see JFrame
     */
    private Object paginaPrec;

    /**
     * Crea una nuova finestra di login.
     *
     * @param paginaPrec la finestra precedente che ha aperto questa finestra.
     */
    public login(Object paginaPrec) {
        this.paginaPrec = paginaPrec;
        initComponents();
        nascondiOggettiPannelSinistro();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
    }

    /**
     * Questo metodo è chiamato all'interno del costruttore per inizializzare il modulo.
     * ATTENZIONE: non modificare questo codice. Il contenuto di questo metodo è sempre
     * rigenerato dall'Editor di Form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        labelUserLoggato = new javax.swing.JLabel();
        btnAggiungiStazione = new javax.swing.JButton();
        btnGestionePrevisioni = new javax.swing.JButton();
        btnIndietro = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnIndietro1 = new javax.swing.JButton();
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

        btnIndietro.setBackground(new java.awt.Color(177, 212, 224));
        btnIndietro.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnIndietro.setText("Indietro");
        btnIndietro.setPreferredSize(new java.awt.Dimension(72, 28));
        btnIndietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndietroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnIndietro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addComponent(btnAggiungiStazione, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIndietro, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 330));

        jPanel1.setBackground(new java.awt.Color(177, 212, 224));

        btnIndietro1.setBackground(new java.awt.Color(177, 212, 224));
        btnIndietro1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnIndietro1.setText("Indietro");
        btnIndietro1.setPreferredSize(new java.awt.Dimension(72, 28));
        btnIndietro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndietro1ActionPerformed(evt);
            }
        });

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
        txtPass.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtUsername.setBackground(new java.awt.Color(177, 212, 224));
        txtUsername.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

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
                                                        .addComponent(txtUsername)))
                                        .addComponent(btnIndietro1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(btnAccedi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegistrati, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIndietro1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo che apre la finestra crea stazione
     *
     * @param evt
     */
    private void btnAggiungiStazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggiungiStazioneActionPerformed
        creaStazione cp = new creaStazione(this);
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
        admin_panel ap = new admin_panel(utenteLoggato, this);
        ap.addWindowListener(this);
        ap.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnGestionePrevisioniActionPerformed

    /**
     * Metodo che controlla se l'utente esiste, in caso positivo mostra le
     * funzioni disponibili
     *
     * @param evt evento generato dal clic sul pulsante.
     */
    private void btnAccediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccediActionPerformed
        try {
            //Controllo la correttezza dei dati inseriti
            if (!txtUsername.getText().isEmpty() || !txtPass.getText().isEmpty()) {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(txtPass.getText().getBytes());
                byte[] digest = md.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b));
                }
                try {
                    utenteLoggato = DatiCondivisi.getInstance().gestore_db.getUser(txtUsername.getText(), sb.toString());
                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Server non raggiungibile", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }
                if (utenteLoggato != null) {
                    mostraOggettiPannelSinistro();
                    nascondiOggettiPannelDestro();
                } else {
                    JOptionPane.showMessageDialog(null, "Username/Password errata", "Errore", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Inserisci Username/Password", "Errore", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
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

    private void btnIndietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIndietroActionPerformed
        ((JFrame) paginaPrec).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIndietroActionPerformed

    private void btnIndietro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIndietro1ActionPerformed
        ((JFrame) paginaPrec).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIndietro1ActionPerformed

    /**
     * Nasconde gli oggetti del pannello di accesso.
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

    /**
     * Mostra gli oggetti del pannello utente loggato.
     */
    public void mostraOggettiPannelSinistro() {
        jPanel2.setVisible(true);
        labelUserLoggato.setText(utenteLoggato.getUsername());
        labelUserLoggato.setVisible(true);
        btnAggiungiStazione.setVisible(true);
        btnGestionePrevisioni.setVisible(true);
    }

    /**
     * Nasconde gli oggetti del pannello utente loggato.
     */
    public void nascondiOggettiPannelSinistro() {
        jPanel2.setVisible(false);
        labelUserLoggato.setVisible(false);
        btnAggiungiStazione.setVisible(false);
        btnGestionePrevisioni.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccedi;
    private javax.swing.JButton btnAggiungiStazione;
    private javax.swing.JButton btnGestionePrevisioni;
    private javax.swing.JButton btnIndietro;
    private javax.swing.JButton btnIndietro1;
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
