/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lights.out;

/**
 *
 * @author loic1
 */
public class fenetreDeJeu extends javax.swing.JFrame {

    /**
     * Creates new form fenetreDeJeu
     */
    public fenetreDeJeu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_Menu = new javax.swing.JButton();
        button_Play = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 204, 0));
        setName("fenetre"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button_Menu.setBackground(new java.awt.Color(51, 255, 51));
        button_Menu.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        button_Menu.setText("MENU");
        button_Menu.setToolTipText("");
        button_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_MenuActionPerformed(evt);
            }
        });
        getContentPane().add(button_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 250, 90));

        button_Play.setBackground(new java.awt.Color(255, 51, 51));
        button_Play.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        button_Play.setText("PLAY");
        button_Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_PlayActionPerformed(evt);
            }
        });
        getContentPane().add(button_Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 250, 90));

        setBounds(0, 0, 1058, 686);
    }// </editor-fold>//GEN-END:initComponents

    private void button_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_MenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_MenuActionPerformed

    private void button_PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_PlayActionPerformed

  Fenetre2 f2 =new Fenetre2();
  f2.show();
  this.dispose(); 
        // TODO add your handling code here:
    }//GEN-LAST:event_button_PlayActionPerformed

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
                new fenetreDeJeu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Menu;
    private javax.swing.JButton button_Play;
    // End of variables declaration//GEN-END:variables
}
