/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_barois._bernard;

/**
 *
 * @author Elou
 */
import java.util.Random;
import java.util.Scanner;
public class Partie {
    Joueur [] listeJoueurs =  new Joueur[2];
    Joueur JoueurCourant;
    Grille grilleJeu;
    
    public Partie(Joueur Joueur1,Joueur Joueur2){
        listeJoueurs[0]=Joueur1;
        listeJoueurs[1]=Joueur2;
    }
    public void attribuerCouleursAuxJoueurs(){
        Random rand = new Random();
        int upperbound = 2;
        int int_random = rand.nextInt(upperbound);
        if (int_random==0){
            listeJoueurs[0].Couleur="Rouge";
            listeJoueurs[1].Couleur="Jaune";
        } else{
            listeJoueurs[0].Couleur="Jaune";
            listeJoueurs[1].Couleur="Rouge";
        }
    }
    public void initialiserPartie(){
        grilleJeu= new Grille ();
        Random rand = new Random();
        int maxLigne = 6;
        int maxColonne= 7;
        int random_ligne =0;
        int random_colonne=0;
        for (int i=0; i<5;i++){
           random_ligne = rand.nextInt(maxLigne);
           random_colonne= rand.nextInt(maxColonne);
           if (grilleJeu.placerTrouNoir(random_ligne,random_colonne)==false){
               i--;
           }else{
               continue;
           }
        }
        
        
        
        for (int i=0;i<21;i++){
            Jeton unJeton= new Jeton("Rouge");
            if (listeJoueurs[0].Couleur=="Rouge"){
                listeJoueurs[0].ajouterJeton(unJeton);
                listeJoueurs[0].nombreJetonsRestants++;
            }else{
                listeJoueurs[1].ajouterJeton(unJeton);
                listeJoueurs[1].nombreJetonsRestants++;
            }
        }
        for (int i=0;i<21;i++){
            Jeton deuxJeton= new Jeton("Jaune");
            if (listeJoueurs[1].Couleur=="Jaune"){
                listeJoueurs[1].ajouterJeton(deuxJeton);
                listeJoueurs[1].nombreJetonsRestants++;
                
            }else{
                listeJoueurs[0].ajouterJeton(deuxJeton);
                listeJoueurs[0].nombreJetonsRestants++;
            }
        }
        int upperbound = 2;
        int int_random = rand.nextInt(upperbound);
        if (int_random==0){
            JoueurCourant=listeJoueurs[0];
        }else{
            JoueurCourant=listeJoueurs[1];
        }
    }
    
    public void debuterPartie(){
        Scanner sc = new Scanner(System.in) ;
        int i=0;
        int j=0;
        boolean test=false;
        while (test==false){
            
            System.out.println("Au tour de " +JoueurCourant.nom+ " le Joueur de couleur "+JoueurCourant.Couleur+" !");
            System.out.println();
            grilleJeu.afficherGrilleSurConsole();
            System.out.println("Si vous voulez jouer un Jeton: Tapez 1\nSi vous voulez en récupérer: Tapez 2 ");
            int Choix = sc.nextInt();
            if (Choix==2){
                for (int t=0;t<100;t++){
                    System.out.println("Quel jeton souhaitez-vous récupérer?");
                    System.out.print("Tapez la ligne:");
                    int ligne_choisie = sc.nextInt()-1;
                    System.out.print("Tapez la colonne:");
                    int colonne_choisie = sc.nextInt()-1;
                    if (grilleJeu.celluleOccupee(ligne_choisie, colonne_choisie)){
                        grilleJeu.recupererJeton(ligne_choisie, colonne_choisie);
                        grilleJeu.tasserGrille(colonne_choisie);
                        break;
                    }else{
                        System.out.println("Il n'y a pas de jeton à vous dans cette case!");
                    }
                }
            }
            
                
                
                
                
            
            if (Choix==1){
                System.out.println("Dans quelle colonne voulez-vous placer votre Jeton?") ;
                int numCol=0;
                int testBug=1;
                while (testBug!=0){
                    testBug=0;
                    try{
                        numCol=sc.nextInt();
                    }
                    catch(Exception e){
                        testBug=1;
                        System.out.println("erreur: Rentrez une colonne entre 1 et 7");
                        sc.reset();
                        sc.next();
                    }
                }
                int numColonne ;
                numColonne=numCol-1 ;
                if (JoueurCourant.Couleur=="Rouge"){
                    grilleJeu.ajouterJetonDansColonne(JoueurCourant.listeJetons[i],numColonne);
                    JoueurCourant.listeJetons[i]=null;
                    i++;
                    for (int z=0;z<6;z++){
                        if (grilleJeu.CellulesJeu[z][numColonne].presenceTrouNoir() && grilleJeu.celluleOccupee(z,numColonne)){
                            grilleJeu.CellulesJeu[z][numColonne].activerTrouNoir();
                            break;
                        }
                    }
                }
                if (JoueurCourant.Couleur=="Jaune"){
                    grilleJeu.ajouterJetonDansColonne(JoueurCourant.listeJetons[j],numColonne);
                    JoueurCourant.listeJetons[j]=null;
                    j++;
                    for (int y=0;y<6;y++){
                        if (grilleJeu.CellulesJeu[y][numColonne].presenceTrouNoir() && grilleJeu.celluleOccupee(y,numColonne)){
                            grilleJeu.CellulesJeu[y][numColonne].activerTrouNoir();
                            break;
                        }
                    }
                }
                
            test=grilleJeu.etreGagnantePourJoueur(JoueurCourant);  
                
            if (JoueurCourant==listeJoueurs[0]){
                JoueurCourant=listeJoueurs[1];
            }else{ JoueurCourant=listeJoueurs[0];}
            
        }
        }
        
    }
}




















