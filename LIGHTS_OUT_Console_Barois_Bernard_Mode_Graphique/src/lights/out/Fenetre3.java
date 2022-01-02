
package lights.out;

import java.util.Random;


public class Fenetre3 extends javax.swing.JFrame {

    Cellule[] [] CellulesJeu2 = new Cellule[9][9] ; // Création d'une grille 9x9
    Grille grilleJeu; // initialise la grille grilleJeu 
    
    public Fenetre3() {
        initComponents(); // initialise les composants 
        grilleJeu = new Grille (); // création d'une nouvelle grille grilleJeu
        but_rejouer.setVisible(false); // cache le button rejouer 
        Gagne.setVisible(false); // cache le button gagne 
        txt_indice.setVisible(false) ; // cache le texte indice

        for (int i = 0; i < 9; i++) { // boucle parcourant les lignes du tableau
            for (int j = 0; j < 9; j++) { // boucle parcourant les colonnes du tableau
                CelluleGraphique2 CellGraph = new CelluleGraphique2(grilleJeu.CellulesJeu2[i][j],i,j);
                // associe à chaque cellule du tableau une celluleGraphique correspondante ayant les mêmes coordonnées (i,j)
                
                grille_99.add(CellGraph);// ajoute les cellulesGraphiques dans la grille 9x9 créée en graphique
            
                for (int z=0;z<40;z++){ // boucle pour créer des clics aléatoires avant le début de la partie
                    
                    Random rand = new Random();
                    int maxLigne = 9; // nombre max de lignes
                    int maxColonne= 9; // nombre max de colonnes
                    int random_ligne =0; // initialise une variable de type int correspondant à un numero de ligne
                    int random_colonne=0; // initialise une variable de type int correspondant à un numero de colonne
                    random_ligne = rand.nextInt(maxLigne); // associe à la variable random_ligne une nombre aléatoire entre 0 et le nombre max de lignes (9)
                    random_colonne= rand.nextInt(maxColonne); // associe à la variable random_colonne une nombre aléatoire entre 0 et le nombre max de colonnes (9)

                    grilleJeu.ClicJoueur2(random_ligne,random_colonne); // effectue un clic joueur avec les coordonnées aléatoires générées juste avant
                }
                
                
                grille_99.repaint() ; // actualise l'affichage de la grille 
                CellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        
                       
                                                       
                        grilleJeu.ClicJoueur2(CellGraph.x,CellGraph.y); // clic joueur sur une cellgraph
                        grille_99.repaint() ; // actualise l'affichage de la grille 

                        if (grilleJeu.etreGagnantePourJoueur2()==true){ // si la grille est gagnante alors:
                            but_rejouer.setVisible(true); // affiche le button rejouer 
                            Gagne.setVisible(true); // affiche le button gagne

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
        jScrollPane1 = new javax.swing.JScrollPane();
        reglesDuJeu = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Gagne = new javax.swing.JTextArea();
        but_rejouer = new javax.swing.JButton();
        indice = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_indice = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grille_99.setBackground(new java.awt.Color(255, 204, 204));
        grille_99.setLayout(new java.awt.GridLayout(9, 9));
        getContentPane().add(grille_99, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 729, 729));

        reglesDuJeu.setColumns(20);
        reglesDuJeu.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        reglesDuJeu.setRows(5);
        reglesDuJeu.setText("Règles du jeu:\n\nLe but est très simple: éteindre toutes les lumières!\nUne lumière peut prendre deux états:\n-Allumée (Vert Clair)\n-Eteinte (Vert Foncé)\n\nQuand vous cliquez sur une lumière,  son état change\net celui des lumières autour d'elle change aussi.\n\nAlors... Bonne chance!!");
        jScrollPane1.setViewportView(reglesDuJeu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 410, 230));

        Gagne.setColumns(20);
        Gagne.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        Gagne.setForeground(new java.awt.Color(255, 0, 0));
        Gagne.setRows(5);
        Gagne.setText("\n            \n                      \tQuel boss...");
        jScrollPane2.setViewportView(Gagne);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, 410, -1));

        but_rejouer.setBackground(new java.awt.Color(0, 0, 0));
        but_rejouer.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        but_rejouer.setForeground(new java.awt.Color(255, 255, 255));
        but_rejouer.setText("Rejouer!");
        but_rejouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_rejouerActionPerformed(evt);
            }
        });
        getContentPane().add(but_rejouer, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 410, 410, 90));

        indice.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        indice.setForeground(new java.awt.Color(51, 51, 51));
        indice.setText("Indice");
        indice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indiceActionPerformed(evt);
            }
        });
        getContentPane().add(indice, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, 410, 80));

        txt_indice.setColumns(20);
        txt_indice.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        txt_indice.setRows(5);
        txt_indice.setText("Vous auriez pu faire un effort...\n\nCliquez sous chaque lumière allumée en partant d'en\nhaut et en descendant petit à petit.\nPuis recommencez en cliquant une case aléatoire sur\nla ligne du haut.");
        jScrollPane3.setViewportView(txt_indice);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 600, 410, 140));

        setBounds(0, 0, 1344, 912);
    }// </editor-fold>//GEN-END:initComponents

    private void but_rejouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_rejouerActionPerformed
        // Quand on clique sur le button rejouer alors:
        fenetreDeJeu f1 = new fenetreDeJeu(); // on crée une nouvelle fenêtre
        f1.show(); // on l'affiche
        this.dispose() ; // on quitte celle-ci
    }//GEN-LAST:event_but_rejouerActionPerformed

    private void indiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indiceActionPerformed
       // Quand on clique sur le button indice alors:
        txt_indice.setVisible(true) ; // on affiche le texte indice
    }//GEN-LAST:event_indiceActionPerformed

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
                new Fenetre3().setVisible(true); // affiche la fenetre 3 quand on run le programme
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Gagne;
    private javax.swing.JButton but_rejouer;
    private javax.swing.JPanel grille_99;
    private javax.swing.JButton indice;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea reglesDuJeu;
    private javax.swing.JTextArea txt_indice;
    // End of variables declaration//GEN-END:variables
}
