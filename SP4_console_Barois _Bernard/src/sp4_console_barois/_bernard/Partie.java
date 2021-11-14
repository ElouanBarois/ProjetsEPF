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
        Random rand = new Random();
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
        System.out.println("Le joueur " +JoueurCourant.nom+ " "+JoueurCourant.Couleur+" commence");
        while (test==false){
            
            
            grilleJeu.afficherGrilleSurConsole();
            System.out.println("Dans quelle colonne voulez-vous placer votre Jeton?") ;
            int numColonne = sc.nextInt()-1 ;
            if (JoueurCourant.Couleur=="Rouge"){
                grilleJeu.ajouterJetonDansColonne(JoueurCourant.listeJetons[i],numColonne);
                JoueurCourant.listeJetons[i]=null;
                i++;
                System.out.println(JoueurCourant.listeJetons[i].Couleur);
            }
            if (JoueurCourant.Couleur=="Jaune"){
                grilleJeu.ajouterJetonDansColonne(JoueurCourant.listeJetons[j],numColonne);
                JoueurCourant.listeJetons[j]=null;
                j++;
            }
                
            test=grilleJeu.etreGagnantePourJoueur(JoueurCourant);  
                
            if (JoueurCourant==listeJoueurs[0]){
                JoueurCourant=listeJoueurs[1];
            }else{ JoueurCourant=listeJoueurs[0];}
            System.out.println(JoueurCourant.Couleur);
            
            
        }
    }
}




















