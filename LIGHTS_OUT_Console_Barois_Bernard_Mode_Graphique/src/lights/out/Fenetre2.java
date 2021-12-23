
package lights.out;

import java.util.Random;


public class Fenetre2 extends javax.swing.JFrame {
    

    Cellule[] [] CellulesJeu = new Cellule[5][5] ;
    Grille grilleJeu;   
    
    public Fenetre2() {
        
        initComponents();
        grilleJeu = new Grille ();
        but_rejouer.setVisible(false);
        Gagne.setVisible(false);
        txt_indice.setVisible(false) ;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                CelluleGraphique CellGraph = new CelluleGraphique(grilleJeu.CellulesJeu[i][j],i,j);
                
                
                
                grille_55.add(CellGraph);
                for (int z=0;z<20;z++){
                    grilleJeu.ClicJoueur(CellGraph.x,CellGraph.y);
                            Random rand = new Random();
                            int maxLigne = 5;
                            int maxColonne= 5;
                            int random_ligne =0;
                            int random_colonne=0;
                            random_ligne = rand.nextInt(maxLigne);
                            random_colonne= rand.nextInt(maxColonne);
                            
                            grilleJeu.ClicJoueur(random_ligne,random_colonne);
                            }
                
                
                grille_55.repaint() ;
                CellGraph.addActionListener(new java.awt.event.ActionListener() {
                    int cpt = 0 ;
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        
                        
                        
                        System.out.println(CellGraph.x) ;
                        System.out.println(CellGraph.y) ;
                        
                        
                        
                        
                                                       
                            grilleJeu.ClicJoueur(CellGraph.x,CellGraph.y);
                            grille_55.repaint() ;
                            cpt ++ ;
                            if (grilleJeu.etreGagnantePourJoueur()==true){
                                System.out.println(cpt);
                                but_rejouer.setVisible(true);
                                Gagne.setVisible(true);
                                
                                
                                
                                
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
        but_rejouer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reglesDuJeu = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Gagne = new javax.swing.JTextArea();
        indice = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_indice = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grille_55.setBackground(new java.awt.Color(255, 204, 204));
        grille_55.setLayout(new java.awt.GridLayout(5, 5));
        getContentPane().add(grille_55, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 485, 485));

        but_rejouer.setBackground(new java.awt.Color(0, 0, 0));
        but_rejouer.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        but_rejouer.setForeground(new java.awt.Color(255, 255, 255));
        but_rejouer.setText("Rejouer!");
        but_rejouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_rejouerActionPerformed(evt);
            }
        });
        getContentPane().add(but_rejouer, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 410, 90));

        reglesDuJeu.setColumns(20);
        reglesDuJeu.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        reglesDuJeu.setRows(5);
        reglesDuJeu.setText("Règles du jeu:\n\nLe but est très simple: éteindre toutes les lumières!\nUne lumière peut prendre deux états:\n-Allumée (Vert Clair)\n-Eteinte (Vert Foncé)\n\nQuand vous cliquez sur une lumière,  son état change\net celui des lumières autours d'elle change aussi.\n\nAlors... Bonne chance!!");
        jScrollPane1.setViewportView(reglesDuJeu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 410, 230));

        Gagne.setColumns(20);
        Gagne.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        Gagne.setForeground(new java.awt.Color(255, 0, 0));
        Gagne.setRows(5);
        Gagne.setText("\n    Bravo vous avez réussi la version facile!\n    Passez à la version difficile maintenant...");
        jScrollPane2.setViewportView(Gagne);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 268, 410, -1));

        indice.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        indice.setForeground(new java.awt.Color(51, 51, 51));
        indice.setText("Indice");
        indice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indiceActionPerformed(evt);
            }
        });
        getContentPane().add(indice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 390, 80));

        txt_indice.setColumns(20);
        txt_indice.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        txt_indice.setRows(5);
        txt_indice.setText("Vous auriez pu faire un effort...\n\nCliquez sous chaque lumière allumée en partant d'en\nhaut et en descendant petit à petit.\nPuis recommencez en cliquant une case aléatoire sur\nla ligne du haut.");
        jScrollPane3.setViewportView(txt_indice);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 120, 390, 140));

        setBounds(0, 0, 1452, 653);
    }// </editor-fold>//GEN-END:initComponents

    private void but_rejouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_rejouerActionPerformed
        fenetreDeJeu f1 = new fenetreDeJeu();
        f1.show();
        this.dispose() ;
    }//GEN-LAST:event_but_rejouerActionPerformed

    private void indiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indiceActionPerformed
        txt_indice.setVisible(true) ;
    }//GEN-LAST:event_indiceActionPerformed

    
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
    private javax.swing.JTextArea Gagne;
    private javax.swing.JButton but_rejouer;
    private javax.swing.JPanel grille_55;
    private javax.swing.JButton indice;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea reglesDuJeu;
    private javax.swing.JTextArea txt_indice;
    // End of variables declaration//GEN-END:variables
}
