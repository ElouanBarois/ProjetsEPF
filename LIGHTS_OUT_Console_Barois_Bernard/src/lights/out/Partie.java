
package lights.out;


import java.util.Random;
import java.util.Scanner;
public class Partie {
    Scanner sc = new Scanner(System.in) ;
    Grille grilleJeu; // initialisation d'une grille frilleJeu
    String[] tab={"Clair","Foncé"}; // création d'un tableau de deux cases contenant des strings correspondants aux couleurs
    
    public void debuterPartie(){ // méthode permettant de lancer la partie
        grilleJeu= new Grille (); // création d'une nouvelle grille
        Random rand = new Random();
        for (int i=0;i<5;i++){ // boucle parcourant les 5 lignes
            for (int j=0;j<5;j++){ // boucle parcourant les 5 colonnes
                int Coul=rand.nextInt(2); // association d'une valeur entre 1 et 2 à une variable couleur
                grilleJeu.CellulesJeu[i][j].Couleur=tab[Coul]; // on associe la couleur du tableau avec celle de la case
            }
        }
        boolean test1=false;
        while (test1==false){ // boucle infine tant que personne ne gagne
            grilleJeu.afficherGrilleSurConsole();
            System.out.println("Quelle case voulez-vous taper?");
            System.out.print("Tapez la ligne:");
            int ligne_choisie = sc.nextInt()-1; // variables qui prend le numero de la ligne
            System.out.print("Tapez la colonne:");
            int colonne_choisie = sc.nextInt()-1; // variables qui prend le numero de la colonne
            grilleJeu.ClicJoueur(ligne_choisie,colonne_choisie); // clic joueur sur la case avec le numero de la ligne et de la colonne rentrée juste avant
            if (grilleJeu.etreGagnantePourJoueur()){ // si un joueur gagne:
                test1=true; // la variable devient true donc on ne rentre plus dans la boucle
            }
            
        }
        System.out.print("Vous avez gagné!");
        
    }
    
    
}
