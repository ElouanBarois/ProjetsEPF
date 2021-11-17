/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_console_barois._bernard;

import java.util.Scanner;

/**
 *
 * @author Elou
 */
public class SP4_console_Barois_Bernard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner sc = new Scanner(System.in) ;
       String nomJ1 ; 
       String nomJ2 ;

       System.out.println("Veuillez entrer le nom du premier joueur:") ;
       nomJ1 = sc.next() ;
       Joueur Joueur1 = new Joueur(nomJ1)  ;

       System.out.println("Veuillez entrer le nom du deuxième joueur:") ;
       nomJ2 = sc.next() ;
       Joueur Joueur2 = new Joueur(nomJ2)  ;
        
       Partie unePartie=new Partie(Joueur1,Joueur2);
       unePartie.attribuerCouleursAuxJoueurs();
       unePartie.initialiserPartie();
       unePartie.debuterPartie();
       unePartie.grilleJeu.afficherGrilleSurConsole();
       
       System.out.println(unePartie.JoueurCourant.Couleur);
       if (unePartie.JoueurCourant.Couleur=="Rouge"){
           System.out.println("Le joueur Rouge a gagné !");
       }
       if (unePartie.JoueurCourant.Couleur=="Jaune"){
           System.out.println("Le joueur Jaune a gagné !");
       }
       if (unePartie.JoueurCourant.Couleur=="Noir"){
           System.out.println(unePartie.JoueurCourant.nom+"a perdu car il a provoqué une faute de jeu");
       }
    }
    
}

    