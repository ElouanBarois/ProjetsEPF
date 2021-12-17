
package lights.out;

import java.util.Random;


public class Fenetre3 extends javax.swing.JFrame {

    Cellule[] [] CellulesJeu2 = new Cellule[9][9] ;
    Grille grilleJeu2;
    
    public Fenetre3() {
        initComponents();
        grilleJeu2 = new Grille ();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                CelluleGraphique2 CellGraph = new CelluleGraphique2(grilleJeu2.CellulesJeu2[i][j],i,j);
                grille_99.add(CellGraph);
            
                for (int z=0;z<40;z++){
                    grilleJeu2.ClicJoueur2(CellGraph.x,CellGraph.y);
                    Random rand = new Random();
                    int maxLigne = 9;
                    int maxColonne= 9;
                    int random_ligne =0;
                    int random_colonne=0;
                    random_ligne = rand.nextInt(maxLigne);
                    random_colonne= rand.nextInt(maxColonne);

                    grilleJeu2.ClicJoueur2(random_ligne,random_colonne);
                }
                
                
                grille_99.repaint() ;
                CellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        
                        System.out.println(CellGraph.x) ;
                        System.out.println(CellGraph.y) ;
                        
                        
                        
                        
                                                       
                        grilleJeu2.ClicJoueur2(CellGraph.x,CellGraph.y);
                        grille_99.repaint() ;

                        if (grilleJeu2.etreGagnantePourJoueur2()==true){
                            System.out.println("Gagné") ;

                        }
                    }        
                });            
            }
                        
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grille_99 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grille_99.setBackground(new java.awt.Color(255, 204, 204));
        grille_99.setLayout(new java.awt.GridLayout(9, 9));
        getContentPane().add(grille_99, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 729, 729));

        setBounds(0, 0, 1029, 912);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Fenetre3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenetre3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenetre3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenetre3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel grille_99;
    // End of variables declaration//GEN-END:variables
}
