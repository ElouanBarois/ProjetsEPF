
package lights.out;


public class fenetreDeJeu extends javax.swing.JFrame {

    int a ; // variable qui va permettre l'ouverture des différentes fenêtres
    public fenetreDeJeu() {
        initComponents();   // initialise les composants 
        button_facile.setVisible(false);  // cache le button facile
        button_difficile.setVisible(false); // cache le button difficile
        button_Play.setEnabled(false); // désactive le button play
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_difficile = new javax.swing.JButton();
        button_Play = new javax.swing.JButton();
        button_facile = new javax.swing.JButton();
        button_Menu = new javax.swing.JButton();
        lbl_bienvenue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 204, 0));
        setName("fenetre"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button_difficile.setBackground(new java.awt.Color(255, 153, 51));
        button_difficile.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        button_difficile.setText("DIFFICILE");
        button_difficile.setToolTipText("");
        button_difficile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_difficileActionPerformed(evt);
            }
        });
        getContentPane().add(button_difficile, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 250, 90));

        button_Play.setBackground(new java.awt.Color(255, 51, 51));
        button_Play.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        button_Play.setText("PLAY");
        button_Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_PlayActionPerformed(evt);
            }
        });
        getContentPane().add(button_Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 250, 90));

        button_facile.setBackground(new java.awt.Color(255, 255, 102));
        button_facile.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        button_facile.setText("FACILE");
        button_facile.setToolTipText("");
        button_facile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_facileActionPerformed(evt);
            }
        });
        getContentPane().add(button_facile, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 250, 90));

        button_Menu.setBackground(new java.awt.Color(51, 255, 51));
        button_Menu.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        button_Menu.setText("MENU");
        button_Menu.setToolTipText("");
        button_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_MenuActionPerformed(evt);
            }
        });
        getContentPane().add(button_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 250, 90));

        lbl_bienvenue.setFont(new java.awt.Font("sansserif", 3, 36)); // NOI18N
        lbl_bienvenue.setForeground(new java.awt.Color(51, 0, 51));
        lbl_bienvenue.setText("Bienvenue dans le jeu Lights Out!");
        getContentPane().add(lbl_bienvenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        setBounds(0, 0, 1058, 624);
    }// </editor-fold>//GEN-END:initComponents

    private void button_difficileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_difficileActionPerformed
        // Quand on clique sur le button difficile alors:
        button_facile.setVisible(false);  // cache le button facile
        button_difficile.setVisible(false); // cache le button fdifficile
        button_Play.setVisible(true); // affiche le button play
        button_Menu.setVisible(true); // affiche le button menu
        button_Play.setEnabled(true); // active le button play
        a = 2; // variable prend une certaine valeur 
    }//GEN-LAST:event_button_difficileActionPerformed

    private void button_PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_PlayActionPerformed
        // Quand on clique sur le button play alors:
        if (a==1){ // si on a cliqué sur le button facile
            Fenetre2 f2 = new Fenetre2(); // on crée une nouvelle fenêtre
            f2.show(); // cette fenêtre s'ouvre
            this.dispose(); // celle-ci se ferme
        }
        else{ // si on a cliqué sur le button difficile
            Fenetre3 f3 = new Fenetre3(); // on crée une nouvelle fenêtre
            f3.show(); // cette fenêtre s'ouvre
            this.dispose(); // celle-ci se ferme
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_button_PlayActionPerformed

    private void button_facileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_facileActionPerformed
        // Quand on clique sur le button facile alors:
        button_facile.setVisible(false); // cache le button facile
        button_difficile.setVisible(false); // cache le button difficile
        button_Play.setVisible(true); // affiche le button play
        button_Menu.setVisible(true); // affiche le button menu
        button_Play.setEnabled(true); // active le button play
        a = 1; // variable prend une certaine valeur 
    }//GEN-LAST:event_button_facileActionPerformed

    private void button_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_MenuActionPerformed
        // Quand on clique sur le button menu alors:
        button_facile.setVisible(true); // affiche le button facile
        button_difficile.setVisible(true); // affiche le button difficile
        button_Play.setVisible(false); // cache le button play
        button_Menu.setVisible(false); // cache le button menu
    }//GEN-LAST:event_button_MenuActionPerformed

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
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreDeJeu().setVisible(true); // Quand on run le programme, cela ouvre fenetreDeJeu() et l'affiche
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Menu;
    private javax.swing.JButton button_Play;
    private javax.swing.JButton button_difficile;
    private javax.swing.JButton button_facile;
    private javax.swing.JLabel lbl_bienvenue;
    // End of variables declaration//GEN-END:variables
}
