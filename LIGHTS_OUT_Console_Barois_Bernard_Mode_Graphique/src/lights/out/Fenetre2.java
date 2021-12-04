
package lights.out;


public class Fenetre2 extends javax.swing.JFrame {

    Cellule[] [] CellulesJeu = new Cellule[5][5] ;
    Grille grilleJeu;
    
    
    public Fenetre2() {
        initComponents();
        grilleJeu = new Grille ();
       

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                CelluleGraphique CellGraph = new CelluleGraphique(grilleJeu.CellulesJeu[i][j]);
                grille_55.add(CellGraph);
                CellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        
                        
                        if (CellGraph.celluleAssociee.Couleur=="Clair"){
                            CellGraph.celluleAssociee.ChangerDeCouleur();
                            System.out.println(CellGraph.celluleAssociee.Couleur) ;
                        }
                        
                    }
                });
                
            }
        }
                
            
        
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grille_55 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grille_55.setBackground(new java.awt.Color(255, 204, 204));
        grille_55.setLayout(new java.awt.GridLayout(5, 5));
        getContentPane().add(grille_55, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 485, 485));

        setBounds(0, 0, 835, 605);
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(Fenetre2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenetre2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenetre2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenetre2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel grille_55;
    // End of variables declaration//GEN-END:variables
}
