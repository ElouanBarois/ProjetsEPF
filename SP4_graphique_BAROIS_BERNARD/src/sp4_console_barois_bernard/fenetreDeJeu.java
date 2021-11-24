package sp4_console_barois_bernard;

import java.util.Random;

public class fenetreDeJeu extends javax.swing.JFrame {

    Joueur[] listeJoueurs = new Joueur[2];
    Joueur JoueurCourant;
    Grille grilleJeu = new Grille();

    public fenetreDeJeu() {
        initComponents();
        grilleJeu.afficherGrilleSurConsole();

        panneau_info_joueurs.setVisible(false); // désactive les panneaux d'infos joueurs avant l'activation du bouton de but de partie
        panneau_info_partie.setVisible(false); // désactive les panneaux d'infos partie avant l'activation du bouton de but de partie

        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                CelluleGraphique cellGraph = new CelluleGraphique(grilleJeu.CellulesJeu[i][j]); // crée les cellulesgraphiques
                btn_col_0.setText("1 ");
                cellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Cellule c = cellGraph.celluleAssociee;
                        if (c.jetonCourant == null) {
                            return;
                        }
                        if (c.jetonCourant.Couleur == JoueurCourant.Couleur) {
                            message.setText("le joueur " + JoueurCourant.nom + " récupère un de ses jetons");
                            Jeton jrecup = c.recupererJeton();
                            c.supprimerJeton();
                            panneau_grille.repaint();
                            
                            JoueurCourant.ajouterJeton(jrecup);
                            joueurSuivant();
                        } else {
                            if (JoueurCourant.nombreDesintegrateurs > 0) {
                                message.setText("le joueur " + JoueurCourant.nom + " veut désintégrer un jeton");
                                c.supprimerJeton();
                                JoueurCourant.utiliserDesintegrateur();
                                panneau_grille.repaint();
                                
                                joueurSuivant();
                            } else {
                                return;
                            }
                        }
                        grilleJeu.tasserGrille();
                        
                        boolean vict_j1 = grilleJeu.etreGagnantePourJoueur(listeJoueurs[0]); // variable victoire joueur 1
                        boolean vict_j2 = grilleJeu.etreGagnantePourJoueur(listeJoueurs[1]); // variable victoire joueur 2

                        if (vict_j1 && !vict_j2) { // test de victoire quand on désintegre ou quand on retire un jeton ou quand on en désintegre un
                            message.setText("Victoire de " + listeJoueurs[0].nom); //affichage d'un message de victoire dans le panneau info partie
                        }

                        if (vict_j2 && !vict_j1) {
                            message.setText("Victoire de " + listeJoueurs[1].nom); //affichage d'un message de victoire dans le panneau info partie
                        }

                        if (vict_j1 && vict_j2) {

                            if (JoueurCourant == listeJoueurs[0]) {
                                message.setText("Victoire de " + listeJoueurs[1].nom + "Faute de jeu de l'autre joueur");
                            } else {
                                message.setText("Victoire de " + listeJoueurs[1].nom + "Faute de jeu de l'autre joueur");
                            }
                        }

                    }
                });
                panneau_grille.add(cellGraph);
            }
        }

    }
    
    
   
    
    public void joueurSuivant() { // échange le joueur courant et actualise la panneau d'infos joueur avec le nouveau joueur courant
        if (JoueurCourant == listeJoueurs[0]) {
            JoueurCourant = listeJoueurs[1];
            lbl_jcourant.setText(JoueurCourant.nom);
        } else {
            JoueurCourant = listeJoueurs[0];
            lbl_jcourant.setText(JoueurCourant.nom);
        }
    }

    public boolean jouerDansColonne(int indice_colonne) {

        boolean resultatAction;
        resultatAction = grilleJeu.ajouterJetonDansColonne(JoueurCourant.listeJetons[JoueurCourant.nombreJetonsRestants - 1], indice_colonne);
        panneau_grille.repaint(); // actualise la grille

        for (int z = 0; z < 6; z++) { // même code que dans la partie console

            if (grilleJeu.CellulesJeu[z][indice_colonne].presenceTrouNoir() && grilleJeu.celluleOccupee(z, indice_colonne)) {
                grilleJeu.CellulesJeu[z][indice_colonne].activerTrouNoir();
                if (grilleJeu.CellulesJeu[z][indice_colonne].presenceDesintegrateur()) {
                    grilleJeu.CellulesJeu[z][indice_colonne].recupererDesintegrateur();
                    JoueurCourant.obtenirDesintegrateur();
                }
            }

            if (grilleJeu.CellulesJeu[z][indice_colonne].presenceDesintegrateur() && grilleJeu.celluleOccupee(z, indice_colonne)) {
                grilleJeu.CellulesJeu[z][indice_colonne].recupererDesintegrateur();
                JoueurCourant.obtenirDesintegrateur();
            }
        }

        lbl_j1_desint.setText(listeJoueurs[0].nombreDesintegrateurs + "");
        lbl_j2_desint.setText(listeJoueurs[1].nombreDesintegrateurs + "");

        boolean vict_j1 = grilleJeu.etreGagnantePourJoueur(listeJoueurs[0]);
        boolean vict_j2 = grilleJeu.etreGagnantePourJoueur(listeJoueurs[1]);

        if (vict_j1 && !vict_j2) {
            message.setText("Victoire de " + listeJoueurs[0].nom);
        }

        if (vict_j2 && !vict_j1) {
            message.setText("Victoire de " + listeJoueurs[1].nom);
        }

        if (vict_j1 && vict_j2) {

            if (JoueurCourant == listeJoueurs[0]) {
                message.setText("Victoire de " + listeJoueurs[1].nom + "Faute de jeu de l'autre joueur");
            } else {
                message.setText("Victoire de " + listeJoueurs[1].nom + "Faute de jeu de l'autre joueur");
            }
        }

        if (resultatAction == true) {
            JoueurCourant.listeJetons[JoueurCourant.nombreJetonsRestants - 1] = null; // le jeton qui vient d'être joué est donc supprimé
            JoueurCourant.nombreJetonsRestants--; // décrémente le nombre de jetons restants du joueur courant
            return true;
        } else {
            return false;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneau_grille = new javax.swing.JPanel();
        panneau_info_joueurs = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_j1_couleur = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_j1_desint = new javax.swing.JLabel();
        lbl_j1_nom = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        lbl_j2_couleur2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_j2_desint = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_j2_nom2 = new javax.swing.JLabel();
        panneau_creation_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom_joueur2 = new javax.swing.JTextField();
        nom_joueur1 = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        panneau_info_partie = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_jcourant = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        btn_col_1 = new javax.swing.JButton();
        btn_col_2 = new javax.swing.JButton();
        btn_col_3 = new javax.swing.JButton();
        btn_col_4 = new javax.swing.JButton();
        btn_col_5 = new javax.swing.JButton();
        btn_col_6 = new javax.swing.JButton();
        btn_col_0 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(255, 255, 255));
        panneau_grille.setLayout(new java.awt.GridLayout(6, 7));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 672, 576));

        panneau_info_joueurs.setBackground(new java.awt.Color(204, 255, 204));
        panneau_info_joueurs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Infos Joueurs");
        panneau_info_joueurs.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("desintegrateur :");
        panneau_info_joueurs.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        lbl_j1_couleur.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_j1_couleur.setForeground(new java.awt.Color(51, 51, 51));
        lbl_j1_couleur.setText("couleurJoueur1");
        panneau_info_joueurs.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("couleur :");
        panneau_info_joueurs.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Joueur 2:");
        panneau_info_joueurs.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        lbl_j1_desint.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_j1_desint.setForeground(new java.awt.Color(51, 51, 51));
        lbl_j1_desint.setText("nbdesintJoueur1");
        panneau_info_joueurs.add(lbl_j1_desint, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        lbl_j1_nom.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_j1_nom.setForeground(new java.awt.Color(51, 51, 51));
        lbl_j1_nom.setText("nomJoueur1");
        panneau_info_joueurs.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));
        panneau_info_joueurs.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 270, 10));

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("desintegrateur :");
        panneau_info_joueurs.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        lbl_j2_couleur2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_j2_couleur2.setForeground(new java.awt.Color(51, 51, 51));
        lbl_j2_couleur2.setText("couleurJoueur2");
        panneau_info_joueurs.add(lbl_j2_couleur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("couleur :");
        panneau_info_joueurs.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        lbl_j2_desint.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_j2_desint.setForeground(new java.awt.Color(51, 51, 51));
        lbl_j2_desint.setText("nbdesintJoueur2");
        panneau_info_joueurs.add(lbl_j2_desint, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        jLabel11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Joueur 1:");
        panneau_info_joueurs.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lbl_j2_nom2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_j2_nom2.setForeground(new java.awt.Color(51, 51, 51));
        lbl_j2_nom2.setText("nomJoueur2");
        panneau_info_joueurs.add(lbl_j2_nom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        getContentPane().add(panneau_info_joueurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 290, 290));

        panneau_creation_partie.setBackground(new java.awt.Color(204, 255, 204));
        panneau_creation_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Nom joueur 2:");
        panneau_creation_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        jLabel2.setForeground(new java.awt.Color(51, 51, 0));
        jLabel2.setText("Nom joueur 1:");
        panneau_creation_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 30));

        nom_joueur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_joueur2ActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(nom_joueur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 120, -1));

        nom_joueur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_joueur1ActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(nom_joueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 120, -1));

        btn_start.setText("Démarrer partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        getContentPane().add(panneau_creation_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 290, 120));

        panneau_info_partie.setBackground(new java.awt.Color(204, 255, 204));
        panneau_info_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Infos Jeu");
        panneau_info_partie.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, -1));

        jLabel9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("joueur courant");
        panneau_info_partie.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lbl_jcourant.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_jcourant.setForeground(new java.awt.Color(51, 51, 51));
        lbl_jcourant.setText("nomjoueur");
        panneau_info_partie.add(lbl_jcourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        message.setColumns(20);
        message.setRows(5);
        jScrollPane1.setViewportView(message);

        panneau_info_partie.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 270, 90));

        getContentPane().add(panneau_info_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, 290, 180));

        btn_col_1.setText("2");
        btn_col_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 20, -1, -1));

        btn_col_2.setText("3");
        btn_col_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 20, -1, -1));

        btn_col_3.setText("4");
        btn_col_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 20, -1, -1));

        btn_col_4.setText("5");
        btn_col_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 20, -1, -1));

        btn_col_5.setText("6");
        btn_col_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        btn_col_6.setText("7");
        btn_col_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 20, -1, -1));

        btn_col_0.setText("1 ");
        btn_col_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        setBounds(0, 0, 1044, 702);
    }// </editor-fold>//GEN-END:initComponents

    private void nom_joueur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_joueur1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_joueur1ActionPerformed

    private void nom_joueur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_joueur2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_joueur2ActionPerformed

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        panneau_info_joueurs.setVisible(true); // affichage du panneau info joueurs
        panneau_info_partie.setVisible(true); // affichage du panneau info partie
        initialiserPartie(); 
        panneau_grille.repaint(); // actualisation de la grille
        btn_start.setEnabled(false); // desactivation du bouton de debut de partie
    }//GEN-LAST:event_btn_startActionPerformed

    private void btn_col_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_4ActionPerformed
        if (grilleJeu.colonneRemplie(4) == false) { // si la colonne n'est pas remplie, on joue dans la colonne et on passe au joueur suivant
            jouerDansColonne(4);
            joueurSuivant();
        }
    }//GEN-LAST:event_btn_col_4ActionPerformed

    private void btn_col_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_3ActionPerformed
        if (grilleJeu.colonneRemplie(3) == false) { // si la colonne n'est pas remplie, on joue dans la colonne et on passe au joueur suivant
            jouerDansColonne(3) ;
            joueurSuivant();
        }
     
    }//GEN-LAST:event_btn_col_3ActionPerformed

    private void btn_col_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_0ActionPerformed
        if (grilleJeu.colonneRemplie(0) == false) { // si la colonne n'est pas remplie, on joue dans la colonne et on passe au joueur suivant
            jouerDansColonne(0);
            joueurSuivant() ;
        }
        
    }//GEN-LAST:event_btn_col_0ActionPerformed

    private void btn_col_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_1ActionPerformed
        if (grilleJeu.colonneRemplie(1) == false) { // si la colonne n'est pas remplie, on joue dans la colonne et on passe au joueur suivant
            jouerDansColonne(1);
            joueurSuivant();
        }
    }//GEN-LAST:event_btn_col_1ActionPerformed

    private void btn_col_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_2ActionPerformed
        if (grilleJeu.colonneRemplie(2) == false) { // si la colonne n'est pas remplie, on joue dans la colonne et on passe au joueur suivant
            jouerDansColonne(2);
            joueurSuivant();
        }
    }//GEN-LAST:event_btn_col_2ActionPerformed

    private void btn_col_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_5ActionPerformed
        if (grilleJeu.colonneRemplie(5) == false) { // si la colonne n'est pas remplie, on joue dans la colonne et on passe au joueur suivant
            jouerDansColonne(5);
            joueurSuivant();
        }
        
    }//GEN-LAST:event_btn_col_5ActionPerformed

    private void btn_col_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_6ActionPerformed
       if (grilleJeu.colonneRemplie(6) == false) { // si la colonne n'est pas remplie, on joue dans la colonne et on passe au joueur suivant
            jouerDansColonne(6);
            joueurSuivant();
        }
    }//GEN-LAST:event_btn_col_6ActionPerformed

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
                new fenetreDeJeu().setVisible(true); // affiche la fenetre de jeu
            }
        });
    }

    public void attribuerCouleursAuxJoueurs() { // attribue la couleur des jouers aléatoirement en utilisant "upperbound" trouvé sur internet
        Random rand = new Random();
        int upperbound = 2;
        int int_random = rand.nextInt(upperbound);
        if (int_random == 0) {
            listeJoueurs[0].Couleur = "Rouge";
            listeJoueurs[1].Couleur = "Jaune";
        } else {
            listeJoueurs[0].Couleur = "Jaune";
            listeJoueurs[1].Couleur = "Rouge";
        }
    }

    public void initialiserPartie() {

        String nomJoueur1 = nom_joueur1.getText(); // attribue le nom du jouer 1 au nom rentré 
        Joueur J1 = new Joueur(nomJoueur1);
        String nomJoueur2 = nom_joueur2.getText(); // attribue le nom du jouer 2 au nom rentré 
        Joueur J2 = new Joueur(nomJoueur2);

        listeJoueurs[0] = J1;
        listeJoueurs[1] = J2;

        attribuerCouleursAuxJoueurs(); // on appelle la méthode attribuerCouleursAuxJoueurs pour leur attribuer chacun une coulueur "Rouge" ou "Jaune"

        lbl_j1_nom.setText(nomJoueur1); // le label prend le nom du joueur 1
        lbl_j2_nom2.setText(nomJoueur2); // le label prend le nom du joueur 2
        lbl_j1_couleur.setText(J1.Couleur); // le label prend la couleur du joueur 1
        lbl_j2_couleur2.setText(J2.Couleur); // le label prend la couleur du joueur 2
        lbl_j1_desint.setText(J1.nombreDesintegrateurs + ""); // le label prend le nombre de désintegrateurs du joueur 1
        lbl_j2_desint.setText(J2.nombreDesintegrateurs + ""); // le label prend le nombre de désintegrateurs du joueur 2

        Random rand = new Random();
        int maxLigne = 6;
        int maxColonne = 7;
        int random_ligne = 0;
        int random_colonne = 0;
        for (int i = 0; i < 5; i++) { // même code que dans la partie console
            random_ligne = rand.nextInt(maxLigne);
            random_colonne = rand.nextInt(maxColonne);
            if (grilleJeu.placerTrouNoir(random_ligne, random_colonne) == false) {
                i--;
            } else {
                continue;
            }
        }
        int deux_desint = 0;
        while (deux_desint < 2) {
            random_ligne = rand.nextInt(maxLigne);
            random_colonne = rand.nextInt(maxColonne);
            if (grilleJeu.CellulesJeu[random_ligne][random_colonne].presenceTrouNoir() == true) {
                grilleJeu.placerDesintegrateur(random_ligne, random_colonne);
                deux_desint++;
            }
        }
        int trois_desint = 0;
        while (trois_desint < 3) {
            random_ligne = rand.nextInt(maxLigne);
            random_colonne = rand.nextInt(maxColonne);
            if (grilleJeu.CellulesJeu[random_ligne][random_colonne].presenceTrouNoir() == false) {
                grilleJeu.placerDesintegrateur(random_ligne, random_colonne);
                trois_desint++;
            }
        }

        for (int i = 0; i < 21; i++) {
            Jeton unJeton = new Jeton("Rouge");
            if (J1.Couleur == "Rouge") {
                J1.ajouterJeton(unJeton);
                J1.nombreJetonsRestants++;
            } else {
                J2.ajouterJeton(unJeton);
                J2.nombreJetonsRestants++;
            }
        }
        for (int i = 0; i < 21; i++) {
            Jeton deuxJeton = new Jeton("Jaune");
            if (J2.Couleur == "Jaune") {
                J2.ajouterJeton(deuxJeton);
                J2.nombreJetonsRestants++;

            } else {
                J1.ajouterJeton(deuxJeton);
                J1.nombreJetonsRestants++;
            }
        }
        int upperbound = 2;
        int int_random = rand.nextInt(upperbound);
        if (int_random == 0) {
            JoueurCourant = J1;
            lbl_jcourant.setText(JoueurCourant.nom);
        } else {
            JoueurCourant = J2;
            lbl_jcourant.setText(JoueurCourant.nom);
        }

        grilleJeu.afficherGrilleSurConsole(); // utile pour des vérifications mais optionnel
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_col_0;
    private javax.swing.JButton btn_col_1;
    private javax.swing.JButton btn_col_2;
    private javax.swing.JButton btn_col_3;
    private javax.swing.JButton btn_col_4;
    private javax.swing.JButton btn_col_5;
    private javax.swing.JButton btn_col_6;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_j1_couleur;
    private javax.swing.JLabel lbl_j1_desint;
    private javax.swing.JLabel lbl_j1_nom;
    private javax.swing.JLabel lbl_j2_couleur2;
    private javax.swing.JLabel lbl_j2_desint;
    private javax.swing.JLabel lbl_j2_nom2;
    private javax.swing.JLabel lbl_jcourant;
    private javax.swing.JTextArea message;
    private javax.swing.JTextField nom_joueur1;
    private javax.swing.JTextField nom_joueur2;
    private javax.swing.JPanel panneau_creation_partie;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_info_joueurs;
    private javax.swing.JPanel panneau_info_partie;
    // End of variables declaration//GEN-END:variables

}
